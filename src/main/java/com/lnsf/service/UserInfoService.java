package com.lnsf.service;

import com.lnsf.bean.UserInfo;

import java.util.List;

public interface UserInfoService {
    /*商家管理*/
    List<UserInfo> findAllUser(UserInfo userInfo);
    /*商家模糊查询*/
    List<UserInfo> getBusinessLikeName(UserInfo userInfo);
    /*验证用户名的唯一性*/
    boolean stuIsExist(UserInfo userInfo);
    /*添加用户*/
    boolean addUser(UserInfo userInfo);
    /*删除用户*/
    boolean deleteUser(int uid);
    /*根据用户id查询用户*/
    UserInfo getUserById(int userId);
    /*更新用户*/
    int updateUser(UserInfo userInfo);


}
