package com.lnsf.service.impl;

import com.lnsf.bean.UserInfo;
import com.lnsf.bean.UserInfoExample;
import com.lnsf.dao.UserInfoMapper;
import com.lnsf.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 黄润志
     * 登录模块逻辑验证
     * 验证逻辑有：账户密码错误、失败次数过多被锁定、账号被禁用、账号过期、账号不存在
     * */
    @Override
    public String Login(String username, String password) {
        UserInfoExample loginExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = loginExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        loginExample.getOredCriteria().add(criteria);
       List<UserInfo> loginUser =  userInfoMapper.selectByExample(loginExample);
       if (loginUser.size()==0){
           System.out.println("该用户名不存在");
           return "该用户名不存在";
       }else {
           criteria.andPasswordEqualTo(password);
           loginExample.getOredCriteria().add(criteria);
           List<UserInfo> loginpasswords=  userInfoMapper.selectByExample(loginExample);
           int user_num=0;
           int user_id=0;
           for ( UserInfo num: loginUser) {
               System.out.println("密码错误数量："+num.getUserNum());
               user_id = num.getUserId();
               user_num = num.getUserNum();
           }
           if (loginpasswords.size()==0){
               String str = null;
               UserInfo userInfo =new UserInfo();
               userInfo.setUserId(user_id);
               if (user_num>=4){
                   userInfo.setUserNum(5);
                   userInfo.setUserStatus("1");//密码错误5次则锁定账户
                   str="账户被锁定";
               }else {
                   user_num++;
                   userInfo.setUserNum(user_num);
                   str="1"+user_num;
                   /*控制输入密码错误次数*/
                   System.out.println("密码错误1"+user_num);
               }
               userInfoMapper.updateByPrimaryKeySelective(userInfo);
               return str;
           }else {
               for ( UserInfo loginpassword: loginpasswords) {
                   if (loginpassword.getUserStatus().equals("1")){
                       System.out.println("账户被锁定");
                       return "账户被锁定";
                   }else if(loginpassword.getUserStatus().equals("2")){
                       System.out.println("账户被冻结");
                       return "账户被冻结";
                   }else {
                       UserInfo userInfo =new UserInfo();
                       userInfo.setUserId(user_id);
                       userInfo.setUserNum(0);
                       userInfoMapper.updateByPrimaryKeySelective(userInfo);
                       System.out.println("登录成功：" + loginpassword.getUserPower()+"账户状态："+loginpassword.getUserStatus());
                       return "" + loginpassword.getUserPower();
                   }
               }
           }
       }
       return "登录成功";
    }
}
