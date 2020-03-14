package com.lnsf.controller;

import com.lnsf.dto.SysLogDTO;
import com.lnsf.entity.UserInfoEntity;
import com.lnsf.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;


@Api(description = "登录模块",tags = "登录模块控制层")
@RequestMapping("api")
@RestController
public class LoginController {
    @Autowired
    private UserInfoService userInfoService;

    private static Logger log = Logger.getLogger(LoginController.class);

    /**
     *@Description shiro登录方法
     *@Params
     * @param userInfo
     * @param model
     *@return Model
     *@Author huangrunzhi
     *@Date 2019/12/26 12:09
     */
    @ApiOperation(value = "shiro登录", notes = "记录",httpMethod = "POST")
    @RequestMapping("/login")
    public String login(@RequestBody UserInfoEntity userInfo , Model model){
        /**
         * 使用shiro编写认证登录操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(),userInfo.getPassword());
        //3.执行登录方法
        try {
            log.info("shiro登录进入");
            subject.login(token);
            UserInfoEntity userInfos = userInfoService.findUser(userInfo);
            userInfos.setUserId(userInfos.getUserId());
            userInfos.setUserNum(0);
            userInfoService.updataUserInfo(userInfos);
            //登录成功：跳转页面
            model.addAttribute("msg","登录成功");
            return userInfos.getUserPower();
        }catch (UnknownAccountException e){
            log.info("该用户名不存在");
            model.addAttribute("msg","该用户名不存在");
            return "该用户名不存在";
        }catch (IncorrectCredentialsException e){
            log.info("IncorrectCredentialsException：密码错误");
            String str = null;
            int user_num=0;
            UserInfoEntity userInfo1 = userInfoService.findUser(userInfo);
            UserInfoEntity userInfo2 =new UserInfoEntity();
            userInfo2.setUserId(userInfo1.getUserId());
            user_num=userInfo1.getUserNum();
            if (user_num>=4){
                userInfo2.setUserNum(5);
                userInfo2.setUserStatus("1");//密码错误5次则锁定账户
                str="账户被锁定";
            }else {
                user_num++;
                userInfo2.setUserNum(user_num);
                str="1"+user_num;
                /*控制输入密码错误次数*/
                System.out.println("密码错误1"+user_num);
            }
            userInfoService.updataUserInfo(userInfo2);
            return str;
        }catch (LockedAccountException e){
            log.info("LockedAccountException：账户被锁定");
            model.addAttribute("msg","账户被锁定");
            return "账户被锁定";
        }catch (DisabledAccountException e){
            log.info("ExcessiveAttemptsException：账户被冻结");
            model.addAttribute("msg","账户被冻结");
            return "账户被冻结";
        }

    }

    /*value：方法标注*/
/* @ApiOperation(value = "普通登录", notes = "记录",httpMethod = "POST")
    @RequestMapping("/login1")
    public String getAllHomeShow(@RequestBody UserInfo1 login){
        log.info("用户名："+login.getUsername()+"密码："+login.getPassword());
        String msg=loginService.Login(login.getUsername(),login.getPassword());
        log.info("msg:"+msg);
        return msg;
    }*/
    @ApiOperation(value = "退出", notes = "为接口文档使用，其实页面访问并不经过这里，而是使用shiro底层执行退出以及清除session功能",httpMethod = "GET")
    @RequestMapping("/loginOut")
    public void loginOut(HttpSession session, HttpServletResponse response)throws Exception{
        //获取当前用户
        UserInfoEntity user = (UserInfoEntity) session.getAttribute("user");
        /*记录退出时间*/
        user.setUserLoginouttime(new Date());
        userInfoService.updateUser(user);
        /*写进日志表*/
        userInfoService.insertSysLog(user,"loginOut","退出");
        /*跳转到shiro的退出功能*/
        response.sendRedirect("/api/loginOutS");
    }

    @ApiOperation(value = "登录成功", notes = "记录",httpMethod = "PUT")
    @RequestMapping("/success")
    public ModelAndView admin(String username, String users, Map<String,Object> map, HttpServletRequest httpServletRequest){
        log.info("登录成功"+"---用户名："+username+"--用户权限--："+users);
        /*返回数据*/
        UserInfoEntity userInfo1 = new UserInfoEntity();
        /*返回用户信息*/
        userInfo1.setUsername(username);
        userInfo1 = userInfoService.findUser(userInfo1);
        map.put("user",userInfo1);
        httpServletRequest.getSession().setAttribute("user",userInfo1);
        /*记录登录时间*/
        userInfo1.setUserLogintime(new Date());
        userInfoService.updateUser(userInfo1);
        /*记录进入日志表*/
        userInfoService.insertSysLog(userInfo1,"login","登录");
        /*返回跳转页面*/
        ModelAndView model_html = new ModelAndView();
        /*商家与旅客登录成功跳转*/
        if("user".equals(users)){
            model_html.setViewName("index");
        }
        if("admin".equals(users)){
            model_html.setViewName("admin/index");
        }
        return model_html;
    }


    @RequestMapping("/indexToLogin")
    public ModelAndView indexToLogin(){
        /*返回跳转页面*/
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("login");
        return model_html;
    }
    @RequestMapping("/indexToRegister")
    public ModelAndView indexToRegister(){
        /*返回跳转页面*/
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("register");/*redirect:重定向*/
        return model_html;
    }
    @RequestMapping("/indexToAbout")
    public ModelAndView indexToAbout(){
        /*返回跳转页面*/
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("about");/*redirect:重定向*/
        return model_html;
    }
    /*管理员首页引用跳转*/
    @RequestMapping("/count")
    public ModelAndView info(){
        /*返回跳转页面*/
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/count");/*redirect:重定向*/
        return model_html;
    }

    /*测试跳转*/
    @RequestMapping("/test")
    public ModelAndView test(HttpSession session){
        /*返回跳转页面*/
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("test");/*redirect:重定向*/
        return model_html;
    }


}
