package com.lnsf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lnsf.bean.UserInfo;
import com.lnsf.bean.UserInfoExample;
import com.lnsf.dao.UserInfoMapper;
import com.lnsf.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    /**
    *@Description 查询所有商家
    *@Author huangrunzhi
    *@Date 2020/1/4 9:41
    */
    @Override
    public List<UserInfo> findAllUser(UserInfo userInfo) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andUserPowerEqualTo(userInfo.getUserPower());
        userInfoExample.getOredCriteria().add(criteria);
       // System.out.println("userInfo"+userInfo.getUserPower());
        return userInfoMapper.selectByExample(userInfoExample);
    }
    /**
    *@Description 商家模糊查询，根据名字模糊查询，传入名字以及权限
    *@Author huangrunzhi
    *@Date 2020/1/4 12:31
    */
    @Override
    public List<UserInfo> getBusinessLikeName(UserInfo userInfo) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andUserPowerEqualTo(userInfo.getUserPower());
        criteria.andRealNameLike('%'+userInfo.getRealName()+'%');
        userInfoExample.getOredCriteria().add(criteria);
        return userInfoMapper.selectByExample(userInfoExample);
    }
    /*验证用户名的唯一性*/
    @Override
    public boolean stuIsExist(UserInfo userInfo) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andUsernameEqualTo(userInfo.getUsername());
        userInfoExample.getOredCriteria().add(criteria);
        List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);
        if (userInfoList.size()==0){
            return false;
        }else {
            return true;
        }
    }
    /*添加用户*/
    @Override
    public boolean addUser(UserInfo userInfo) {
        int a =userInfoMapper.insertSelective(userInfo);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean deleteUser(int uid) {
        int a =userInfoMapper.deleteByPrimaryKey(uid);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    /*根据用户id查询用户*/
    @Override
    public UserInfo getUserById(int userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateUser(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }
}
