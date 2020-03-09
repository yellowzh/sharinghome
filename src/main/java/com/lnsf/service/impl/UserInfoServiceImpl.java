package com.lnsf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lnsf.dao.UserInfoMapper;
import com.lnsf.dto.SysLogDTO;
import com.lnsf.entity.UserInfoEntity;
import com.lnsf.service.SysLogService;
import com.lnsf.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private SysLogService sysLogService;
    /**
    *@Description 查询所有商家
    *@Author huangrunzhi
    *@Date 2020/1/4 9:41
    */
    @Override
    public List<UserInfoEntity> findAllUser(UserInfoEntity userInfo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_power",userInfo.getUserPower());
        userInfoMapper.selectList(queryWrapper);
        return userInfoMapper.selectList(queryWrapper);
    }
    /**
    *@Description 商家模糊查询，根据名字模糊查询，传入名字以及权限
    *@Author huangrunzhi
    *@Date 2020/1/4 12:31
    */
    @Override
    public List<UserInfoEntity> getBusinessLikeName(UserInfoEntity userInfo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_power",userInfo.getUserPower());
        queryWrapper.like("real_name",userInfo.getRealName());
        return userInfoMapper.selectList(queryWrapper);
    }
    /*验证用户名的唯一性*/
    @Override
    public boolean stuIsExist(UserInfoEntity userInfo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",userInfo.getUsername());
        List<UserInfoEntity> userInfoList = userInfoMapper.selectList(queryWrapper);
        if (userInfoList.size()==0){
            return false;
        }else {
            return true;
        }
    }
    /*添加用户*/
    @Override
    public boolean addUser(UserInfoEntity userInfo) {
        int a =userInfoMapper.insert(userInfo);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean deleteUser(int uid) {
        int a =userInfoMapper.deleteById(uid);
        if (a>0){
            return true;
        }else {
            return false;
        }
    }
    /*根据用户id查询用户*/
    @Override
    public UserInfoEntity getUserById(int userId) {
        return userInfoMapper.selectById(userId);
    }

    @Override
    public int updateUser(UserInfoEntity userInfo) {
        return userInfoMapper.updateById(userInfo);
    }

    /*登录模块*/
    @Override
    public UserInfoEntity findUser(UserInfoEntity userInfo) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",userInfo.getUsername());
        List<UserInfoEntity> user=userInfoMapper.selectList(wrapper);
        UserInfoEntity userInfoEntity = null;
        if (user.size()!=0){
            userInfoEntity = new UserInfoEntity();
            for (UserInfoEntity u:user) {
                userInfoEntity=u;
            }
        }
        return userInfoEntity;
    }
    /*修改用户*/
    @Override
    public int updataUserInfo(UserInfoEntity userInfo) {
        return userInfoMapper.updateById(userInfo);
    }

    @Override
    public void insertSysLog(UserInfoEntity userInfoEntity,String method,String req) {
        SysLogDTO sysLogDTO = new SysLogDTO();
        sysLogDTO.setUserId(""+userInfoEntity.getUserId());
        sysLogDTO.setUserName(userInfoEntity.getUsername());
        sysLogDTO.setMethod(method);
        sysLogDTO.setDescription(req);
        sysLogService.create(sysLogDTO);
    }


}
