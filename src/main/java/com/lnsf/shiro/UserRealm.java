package com.lnsf.shiro;

import com.lnsf.service.UserInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 自定义的Realm程序
 * 需要继承一个AuthorizingRealm类
 * @Author huangrunzhi
 * @Date 2019/12/26
 * @Time 9:59
*/
public class UserRealm extends AuthorizingRealm {
    /**
     * 执行授权逻辑
     * @param arg0
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        System.out.println("执行授权逻辑");
        return null;
    }

    /**
     * 执行一些认证的逻辑
     * @param arg0
     * @return
     * @throws AuthenticationException
     */
    @Autowired
    private UserInfoService userInfoService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        System.out.println("执行一些认证的逻辑");
        //shiro判断逻辑:判断用户名密码
        //1.判断用户名

        UsernamePasswordToken token = (UsernamePasswordToken) arg0;
        if (!token.getUsername().equals("huang")){
            //用户名不存在
            return null;//shiro底层会抛出UnknowAccountException
        }
        //2.判断密码
        return new SimpleAuthenticationInfo("","数据库的密码","");
    }
}
