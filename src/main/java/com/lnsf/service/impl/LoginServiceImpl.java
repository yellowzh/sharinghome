package com.lnsf.service.impl;

import com.lnsf.bean.Login;
import com.lnsf.bean.LoginExample;
import com.lnsf.dao.LoginMapper;
import com.lnsf.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginMapper loginMapper;
    @Override
    public String Login(String username, String password) {
        LoginExample loginExample = new LoginExample();
        LoginExample.Criteria criteria = loginExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        loginExample.getOredCriteria().add(criteria);
       List<Login> loginUser =  loginMapper.selectByExample(loginExample);
       if (loginUser.size()==0){
           System.out.println("该用户名不存在");
           return "该用户名不存在";

       }else {
           criteria.andPasswordEqualTo(password);
           loginExample.getOredCriteria().add(criteria);
           List<Login> loginpasswords=  loginMapper.selectByExample(loginExample);
           if (loginpasswords.size()==0){
               System.out.println("密码错误");
               return "密码错误";
           }else {
               for ( Login loginpassword: loginpasswords) {
                   System.out.println("登录成功："+loginpassword.getPower());
                   return "登录成功："+loginpassword.getPower();
               }
           }
       }
       return "登录成功";
    }
}
