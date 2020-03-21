package com.lnsf.controller;


import cn.hutool.db.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lnsf.dto.UserInfoDTO;
import com.lnsf.entity.UserInfoEntity;
import com.lnsf.service.UserInfoService;
import com.lnsf.util.UploadImgUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
//    @ApiOperation(value = "查询所有商家", notes = "记录",httpMethod = "GET")
//    @RequestMapping("/getBusiness2")
//    public ModelAndView business2(Map<String,Object> map,String power,Integer page){
//        if (page==null)
//        {page=1;}
////        PageHelper.startPage(page,5);
//        UserInfoEntity userInfo = new UserInfoEntity();
//        userInfo.setUserPower(power);
//        log.info("power:"+power);
//        List<UserInfoEntity> userInfos = userInfoService.findAllUser(userInfo);
////        map=maps(userInfos,map,page);
//        log.info("所有用户查询"+userInfos);
//        map.put("users",userInfos);
//        map.put("business","getBusiness");
//        ModelAndView model = model(power);
//        return model;
//    }
    /*查询所有商家*/
    @ApiOperation(value = "查询所有商家", notes = "记录",httpMethod = "GET")
    @RequestMapping("/getBusiness")
    public ModelAndView business(Map<String,Object> map,String power,Integer page){
        if (page==null)
        {page=1;}
        UserInfoEntity userInfo = new UserInfoEntity();
        userInfo.setUserPower(power);
        IPage<UserInfoEntity> infoEntityIPage = userInfoService.findAllUserPage(userInfo,page);
        /*如果为最后一页则返回最后一页数据*/
        if(infoEntityIPage.getCurrent()>infoEntityIPage.getPages()){
            page=Integer.parseInt(String.valueOf(infoEntityIPage.getPages()));
            infoEntityIPage = userInfoService.findAllUserPage(userInfo,page);
        }
        map=maps(infoEntityIPage,map);
        map.put("business","getBusiness");
        ModelAndView model = model(power);
        return model;
    }
    /*分页插件数据返回*/
    public Map<String,Object> maps(IPage<UserInfoEntity> list, Map<String,Object> map){
        System.out.println("页面取值：size"+list.getSize()+"-to-:"+list.getTotal()+"=page=="+list.getPages()+"cun:"+list.getCurrent());
        map.put("users",list.getRecords());
        map.put("totalPage",list.getPages());
        map.put("indexPage",list.getCurrent());
        return map;
    }
    private String Sname;
    @ApiOperation(value = "模糊查询商家", notes = "模糊查询",httpMethod = "GET")
    @RequestMapping("/getBusinessLikeName")
    public ModelAndView getBusinessLikeName(Map<String,Object> map,String power,String name,Integer page){
        if (page==null)
        { page=1;}
        UserInfoEntity userInfo = new UserInfoEntity();
        userInfo.setUserPower(power);
        if (name==null){
            userInfo.setRealName(Sname);
        }else {
            userInfo.setRealName(name);
            Sname=name;
        }
        IPage<UserInfoEntity> infoEntityIPage = userInfoService.getBusinessLikeNamePage(userInfo,page);
        /*如果为最后一页则返回最后一页数据*/
        if(infoEntityIPage.getCurrent()>infoEntityIPage.getPages()){
            page=Integer.parseInt(String.valueOf(infoEntityIPage.getPages()));
            infoEntityIPage = userInfoService.getBusinessLikeNamePage(userInfo,page);
        }
        map=maps(infoEntityIPage,map);
        for (UserInfoEntity u: infoEntityIPage.getRecords()) {
            log.info("u:"+u.getRealName());
        }
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
        UserInfoEntity userInfo = new UserInfoEntity();
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
    public ModelAndView addUser(UserInfoEntity user , String falg, Map<String,Object> map){
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
    *@Description 批量删除。
    *@Author huangrunzhi
    *@Date 2020/1/5 10:04
    */
    @ApiOperation(value = "批量删除用户", notes = "批量删除用户",httpMethod = "DELETE")
    @Transactional
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
        UserInfoEntity user1 = userInfoService.getUserById(uid);
        map.put("user",user1);
        /*页面跳转*/
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/updateUser");/*redirect:重定向*/
        return model_html;
    }
    /*更新用户*/
    @RequestMapping("updateUser")
    public ModelAndView updateUser(UserInfoEntity userInfo, Map<String,Object> map){
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

    /*个人中心页面跳转*/
    @ApiOperation(value = "个人中心", notes = "个人中心",httpMethod = "GET")
    @RequestMapping("myself")
    public ModelAndView getMyself(String users, int userId, Map<String,Object> map){
        System.out.println("个人中心"+userId);
        UserInfoEntity user1 = userInfoService.getUserById(userId);
        map.put("user",user1);
        /*页面跳转*/
        ModelAndView model_html = new ModelAndView();
        if ("admin".equals(users)) {
            model_html.setViewName("admin/myself");/*redirect:重定向*/
        }
        if ("user".equals(users)) {
            model_html.setViewName("user/myself");/*redirect:重定向*/
        }
        return model_html;
    }
    @ApiOperation(value = "修改头像", notes = "修改头像",httpMethod = "POST")
    @RequestMapping("upload")
    public ModelAndView upload( @RequestParam("upload-file") MultipartFile file,String users, int userId, Map<String,Object> map){
        try {
            map=UploadImgUtil.uplond(file,map);
            log.info("上传图片后需要获取的路径："+map.get("filename"));
            /*更新头像*/
            UserInfoEntity userInfo = new UserInfoEntity();
            userInfo.setUserBackup2(String.valueOf(map.get("filename")));
            userInfo.setUserId(userId);
            userInfoService.updateUser(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
            ModelAndView model_html = getMyself(users,userId,map);
            return model_html;
    }
    @ApiOperation(value = "修改个人信息", notes = "修改个人信息",httpMethod = "POST")
    @RequestMapping("updateUserInfo")
    public ModelAndView updateUserInfo(UserInfoEntity userInfo, String users, Map<String,Object> map){
        log.info("userInfo:"+userInfo.getUserId());
       int user = userInfoService.updateUser(userInfo);
       if (user>0) {
           map.put("msg","更新成功");
           ModelAndView model_html = getMyself(users, userInfo.getUserId(), map);
           return model_html;
       }else {
           log.info("更新失败");
           ModelAndView model_html = getMyself(users, userInfo.getUserId(), map);
           model_html.setViewName("myself");
           return model_html;
       }
    }
    //获取当前用户
    @ApiOperation(value = "修改个人信息", notes = "修改个人信息",httpMethod = "GET")
    @RequestMapping("/getUser")
    public UserInfoEntity updateUserInfo(HttpSession session){
        UserInfoEntity user = (UserInfoEntity) session.getAttribute("user");
        return user;
    }



}
