package com.lnsf.controller;

import com.lnsf.bean.Login;
import com.lnsf.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    /*查看所有房源*/
    /*value：方法标注*/
    @ApiOperation(value = "登录", notes = "记录",httpMethod = "POST")
    @RequestMapping("/login")
    public String getAllHomeShow(@RequestBody Login login){
        System.out.println("用户名："+login.getUsername()+"密码："+login.getPassword());
        String msg=loginService.Login(login.getUsername(),login.getPassword());
        return msg;
    }
    @ApiOperation(value = "登录成功", notes = "记录",httpMethod = "PUT")
    @RequestMapping("/success")
    public ModelAndView success(Model model){
        /*返回数据*/
        model.addAttribute("name","黄润志登录成功");
        /*返回跳转页面*/
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/success");
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



}
