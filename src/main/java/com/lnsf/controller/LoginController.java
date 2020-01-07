package com.lnsf.controller;

import com.lnsf.bean.UserInfo;
import com.lnsf.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@Api(description = "登录模块",tags = "登录模块控制层")
@RequestMapping("api")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

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
    @ApiOperation(value = "登录", notes = "记录",httpMethod = "POST")
    @RequestMapping("/login1")
    public String login(@RequestBody UserInfo userInfo ,Model model){
        /**
         * 使用shiro编写认证登录操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(),userInfo.getPassword());
        //3.执行登录方法
        try {
            subject.login(token);
            //登录成功：跳转页面
            return "redirect:/admin/index";
        }catch (UnknownAccountException e){
            //登录失败；用户名不存在
            model.addAttribute("msg","用户名不存在");
        }catch (IncorrectCredentialsException e){
            //登录失败：密码错误
            model.addAttribute("msg","密码错误");
        }


        System.out.println("用户名："+userInfo.getUsername()+"密码："+userInfo.getPassword());
        String msg=loginService.Login(userInfo.getUsername(),userInfo.getPassword());
        System.out.println("msg:"+msg);
        return msg;
    }

    /*value：方法标注*/
    @ApiOperation(value = "登录", notes = "记录",httpMethod = "POST")
    @RequestMapping("/login")
    public String getAllHomeShow(@RequestBody UserInfo login){
        log.info("用户名："+login.getUsername()+"密码："+login.getPassword());
        String msg=loginService.Login(login.getUsername(),login.getPassword());
        log.info("msg:"+msg);
        return msg;
    }
    @ApiOperation(value = "登录", notes = "记录",httpMethod = "POST")
    @RequestMapping("/loginOut")
    public ModelAndView loginOut(){
        log.info("用户：退出");
        //拦截器待加
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("login");
        return model_html;
    }

    @ApiOperation(value = "登录成功", notes = "记录",httpMethod = "PUT")
    @RequestMapping("/admin")
    public ModelAndView admin(Model model){
        log.info("黄润志登录成功");
        /*返回数据*/
        model.addAttribute("name","黄润志登录成功");
        /*返回跳转页面*/
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/index");
        return model_html;
    }
    /*商家与旅客登录成功跳转*/
    @RequestMapping("/users")
    public ModelAndView users(Model model){
        /*返回数据*/
        model.addAttribute("name","黄润志");
        /*返回跳转页面*/
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("user/index");
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
    public ModelAndView test(){
        /*返回跳转页面*/
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/success");/*redirect:重定向*/
        return model_html;
    }


}
