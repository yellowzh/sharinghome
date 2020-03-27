package com.lnsf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.UserInfoDTO;
import com.lnsf.entity.UserInfoEntity;

import java.util.List;

public interface UserInfoService {
    /*商家管理*/
//    List<UserInfoEntity> findAllUser(UserInfoEntity userInfo);

    /*商家管理分页修改*/
    IPage<UserInfoEntity> findAllUserPage(UserInfoEntity userInfo,Integer page);
    /*商家模糊查询*/
    IPage<UserInfoEntity> getBusinessLikeNamePage(UserInfoEntity userInfo,Integer page);
    /*验证用户名的唯一性*/
    boolean stuIsExist(UserInfoEntity userInfo);
    /*添加用户*/
    boolean addUser(UserInfoEntity userInfo);
    /*删除用户*/
    boolean deleteUser(int uid);
    /*根据用户id查询用户*/
    UserInfoEntity getUserById(int userId);
    /*更新用户*/
    int updateUser(UserInfoEntity userInfo);
    /*根据用户名查询用户*/
    UserInfoEntity findUser(UserInfoEntity userInfo);
    /*修改用户*/
    int updataUserInfo(UserInfoEntity userInfo);
    /*记录登录日志*/
    void insertSysLog(UserInfoEntity userInfoEntity,String method,String req);
    /*分页查询*/
    List<UserInfoEntity> page(UserInfoDTO dto, IPage<UserInfoEntity> page);
    /*更新用户个人信息*/
    UserInfoEntity updateUserByUser(UserInfoEntity userInfoEntity);

}
