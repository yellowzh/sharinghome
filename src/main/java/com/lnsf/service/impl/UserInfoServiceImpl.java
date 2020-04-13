package com.lnsf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lnsf.dao.UserInfoMapper;
import com.lnsf.dto.SysLogDTO;
import com.lnsf.dto.UserInfoDTO;
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
//    @Override
//    public List<UserInfoEntity> findAllUser(UserInfoEntity userInfo) {
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("user_power",userInfo.getUserPower());
//        userInfoMapper.selectList(queryWrapper);
//        return userInfoMapper.selectList(queryWrapper);
//    }
    /*分页修改*/
   public IPage<UserInfoEntity> findAllUserPage(UserInfoEntity userInfo,Integer page){
       IPage<UserInfoEntity> ipage = new Page<>(page, 7);
       UserInfoEntity userInfoEntity = new UserInfoEntity();
       QueryWrapper<UserInfoEntity> wrapper = new QueryWrapper<>(userInfoEntity);
       wrapper.eq("user_power",userInfo.getUserPower());
       IPage<UserInfoEntity> pages = userInfoMapper.selectPage(ipage,wrapper);
       return pages;
    }
    /**
    *@Description 商家模糊查询，根据名字模糊查询，传入名字以及权限
    *@Author huangrunzhi
    *@Date 2020/1/4 12:31
    */
    @Override
    public IPage<UserInfoEntity> getBusinessLikeNamePage(UserInfoEntity userInfo,Integer page) {
        IPage<UserInfoEntity> ipage = new Page<>(page, 7);
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        QueryWrapper<UserInfoEntity> wrapper = new QueryWrapper<>(userInfoEntity);
        wrapper.eq("user_power",userInfo.getUserPower());
        wrapper.like("real_name",userInfo.getRealName());
        IPage<UserInfoEntity> pages = userInfoMapper.selectPage(ipage,wrapper);
        return pages;
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
    /*分页查询*/
    @Override
    public List<UserInfoEntity> page(UserInfoDTO dto, IPage<UserInfoEntity> page) {
        return userInfoMapper.page(dto, page);
    }
   public UserInfoEntity updateUserByUser(UserInfoEntity userInfoEntity){
        userInfoMapper.updateById(userInfoEntity);
      return userInfoMapper.selectById(userInfoEntity.getUserId());
    }

}
