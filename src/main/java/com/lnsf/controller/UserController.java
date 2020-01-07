package com.lnsf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lnsf.bean.UserInfo;
import com.lnsf.dao.UserInfoMapper;
import com.lnsf.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Api(description = "用户管理模块",tags = "用户管理模块控制层")
@RequestMapping("api")
@RestController
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    private static Logger log = Logger.getLogger(LoginController.class);

    public static ModelAndView model(String power){
        ModelAndView model_html = new ModelAndView();
        if (power.equals("2")) {
            model_html.setViewName("admin/business");/*redirect:重定向*/
        }else if (power.equals("0")) {
            model_html.setViewName("admin/passenger");/*redirect:重定向*/
        }else if (power.equals("f")){
            model_html.setViewName("/register");/*redirect:重定向*/

        }else {
            model_html.setViewName("/login");/*redirect:重定向*/
        }
        return model_html;
    }
    /*查询所有商家*/
    @ApiOperation(value = "查询所有商家", notes = "记录",httpMethod = "GET")
    @RequestMapping("/getBusiness")
    public ModelAndView business(Map<String,Object> map,String power,Integer page){
        if (page==null)
        {page=1;}
        PageHelper.startPage(page,5);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserPower(power);
        log.info("power:"+power);
        List<UserInfo> userInfos = userInfoService.findAllUser(userInfo);
        map=maps(userInfos,map);
        log.info("所有用户查询"+userInfos);
        map.put("users",userInfos);
        map.put("business","getBusiness");
        ModelAndView model = model(power);
        return model;
    }
    /*分页插件数据返回*/
    public Map<String,Object> maps(List<UserInfo> list,Map<String,Object> map ){
        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(list);
        map.put("users",pageInfo.getList());
        map.put("totalPage",pageInfo.getPages());
        map.put("indexPage",pageInfo.getPageNum());
        return map;
    }
    private String Sname;
    @ApiOperation(value = "模糊查询商家", notes = "模糊查询",httpMethod = "GET")
    @RequestMapping("/getBusinessLikeName")
    public ModelAndView getBusinessLikeName(Map<String,Object> map,String power,String name,Integer page){
        if (page==null)
        { page=1;}
        PageHelper.startPage(page,10);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserPower(power);
        if (name==null){
            userInfo.setRealName(Sname);
        }else {
            userInfo.setRealName(name);
            Sname=name;
        }
        log.info("power:"+power);
        log.info("name:"+name+"--Sname:"+Sname);
        List<UserInfo> userInfos = userInfoService.getBusinessLikeName(userInfo);
        map=maps(userInfos,map);
        for (UserInfo u: userInfos) {
            log.info("u:"+u.getRealName());
        }
        map.put("users",userInfos);
        map.put("business","getBusinessLikeName");
        /*返回跳转页面*/
        ModelAndView model = model(power);
        return model;
    }
/**
*@Description 验证用户名的唯一性
*@Author huangrunzhi
*@Date 2020/1/4 15:30
*/
    @ApiOperation(value = "验证登录名唯一性", notes = "验证用户名",httpMethod = "GET")
    @ResponseBody
    @RequestMapping("stu-exist")
    public Boolean stuIsExist(String username){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        Boolean stuIsExist = userInfoService.stuIsExist(userInfo);
        System.out.println(stuIsExist);
        return stuIsExist;
    }
    /**
    *@Description 添加用户，添加商家，旅客以及用户注销。
    *@Author huangrunzhi
    *@Date 2020/1/5 15:26
    */
    @ApiOperation(value = "添加用户", notes = "添加用户",httpMethod = "POST")
    @RequestMapping("/addUser")
    public ModelAndView addUser(UserInfo user ,String falg,Map<String,Object> map){
        if (falg.equals("3")){
            user.setUserPower("0");
        }else {
            user.setUserPower(falg);
        }
        log.info("user{}:"+user.getUsername()+"---"+user.getPassword()+"----"+user.getUserPower());
        boolean user1 = userInfoService.addUser(user);
        /*返回跳转页面*/
        if (user1==true){
            if (!falg.equals("3")){
                map.put("msg","添加用户成功");
            }else {
                map.put("msg","注册成功");
            }
        }else {
            if (!falg.equals("3")){
                map.put("msg","添加用户失败");
            }else {
                map.put("msg","注册失败");
                falg="f";
            }
        }
        /*页面跳转*/
        business(map,falg,1);
        return model(falg);
    }
    /**
    *@Description 单个删除用户
    *@Author huangrunzhi
    *@Date 2020/1/5 9:30
    */
    @ApiOperation(value = "删除用户", notes = "删除用户",httpMethod = "DELETE")
    @RequestMapping("/deleteUser")
    public ModelAndView deleteUser(int uid,String falg,Map<String,Object> map){

        log.info("uid{}:"+uid);
        boolean user1 = userInfoService.deleteUser(uid);
        /*返回跳转页面*/
        if (user1==true){
            map.put("msg","删除用户成功");
        }else {
            map.put("msg","删除用户失败");
        }
        /*页面跳转*/
        business(map,falg,1);
        return model(falg);
    }
    /**
    *@Description 批量删除。还需加事务
    *@Author huangrunzhi
    *@Date 2020/1/5 10:04
    */
    @ApiOperation(value = "批量删除用户", notes = "批量删除用户",httpMethod = "DELETE")
    @RequestMapping("deleteUsers")
    public ModelAndView deleteUsers(String checkedID,String falg,Map<String,Object> map){
        String[] strs=checkedID.split(",");
        boolean user1=false;
        for (String str:strs) {
            user1 = userInfoService.deleteUser(Integer.parseInt(str));
        }
        /*返回跳转页面*/
        if (user1==true){
            map.put("msg","批量删除用户成功");
        }else {
            map.put("msg","批量删除用户失败");
        }
        /*页面跳转*/
        business(map,falg,1);
        return model(falg);
    }
    /*更新用户跳转更新页面*/
    @RequestMapping("updateUserIndex")
    public ModelAndView updateUserIndex(Integer uid,Map<String,Object> map){
        System.out.println("用户更新"+uid);
        UserInfo user1 = userInfoService.getUserById(uid);
        map.put("user",user1);
        /*页面跳转*/
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/updateUser");/*redirect:重定向*/
        return model_html;
    }
    /*更新用户*/
    @RequestMapping("updateUser")
    public ModelAndView updateUser(UserInfo userInfo,Map<String,Object> map){
        log.info("更新用户编号："+userInfo.getUserId());
        log.info("更新用户密码："+userInfo.getPassword());
        log.info("用户名："+userInfo.getUsername());
        log.info("用户状态："+userInfo.getUserStatus());
        int user1 = userInfoService.updateUser(userInfo);
        /*页面跳转*/
        /*返回跳转页面*/
        if (user1>0){
            map.put("msg","更新用户成功");
        }else {
            map.put("msg","更新用户失败");
        }
        business(map,userInfo.getUserPower(),1);
        return model(userInfo.getUserPower());
    }

}
