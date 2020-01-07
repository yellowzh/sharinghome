package com.lnsf.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置类
 * @author yellowz
 */
@Configuration
public class ShiroConfig {
    /**
     * 1.创建shiroFilterFactoryBean类
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //添加shiro内置过滤器
        /**
         * shiro内置过滤器，实现权限相关的拦截器
         * 常用过滤器
         * anon：无需认证（登录）可以访问
         * authc：必须认证才可以访问
         * user：如果使用rememberMe的功能可以直接访问
         * perms：该资源必须得到资源权限才可以访问
         * role：给资源必须得到角色权限才可以访问
         * */
        Map<String,String> filterMap = new LinkedHashMap<String,String>();

        /*使用统配符的方式对一个目录下的所以资源进行拦截*/
        filterMap.put("/user/*","authc");
        filterMap.put("/admin/*","authc");
        /*让某些资源无需拦截*/
        /*filterMap.put("/login","anon");*/
        //修改页面跳转登录页面
        shiroFilterFactoryBean.setLoginUrl("/api/indexToLogin");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 2.创建DefaultWebSecurityManager类
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("UserRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    /**
     * 2、创建realm类
     */
    @Bean(name = "UserRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }
}
