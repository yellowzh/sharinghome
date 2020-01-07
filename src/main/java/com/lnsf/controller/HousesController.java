package com.lnsf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lnsf.bean.Houses;
import com.lnsf.bean.UserInfo;
import com.lnsf.service.HousesService;
import com.lnsf.util.FileSave;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Api(description = "房源模块",tags = "房源模块控制层")
@RequestMapping("api")
@RestController
public class HousesController {
    @Autowired
    private HousesService housesService;

    private static Logger log = Logger.getLogger(LoginController.class);
    /*查看所有房源*/
    /*value：方法标注*/
    @ApiOperation(value = "查看所有房源", notes = "记录",httpMethod = "GET")
    @RequestMapping("/getAllHomeShow")
    public ModelAndView getAllHomeShow(Map<String,Object> map, Integer page){
        if (page==null)
        {page=1;}
        PageHelper.startPage(page,6);

        List<Houses> houses = housesService.getAllHomeShow();
        map=maps(houses,map);
        log.info("所有用户查询"+houses);
        map.put("houses",houses);
        map.put("request","getAllHomeShow");
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/houses");
        return model_html;
    }
    /*分页插件数据返回*/
    public Map<String,Object> maps(List<Houses> list,Map<String,Object> map ){
        PageInfo<Houses> pageInfo = new PageInfo<Houses>(list);
        map.put("houses",pageInfo.getList());
        map.put("totalPage",pageInfo.getPages());
        map.put("indexPage",pageInfo.getPageNum());
        return map;
    }
    /*查看房源详情*/
    /*@ApiOperation(value = "查看所有房源详情", notes = "记录",httpMethod = "POST")
    @RequestMapping("/getHomeShow")
    public Houses getAllHomeShow(Integer homeId){
        return homeShowService.getHomeShowById(homeId);
    }
    @ApiOperation(value = "查看所有房源详情", notes = "记录",httpMethod = "DELETE")
    @RequestMapping("/deleteHome")
    public int deleteHome(Integer homeId){
        return 0;
    }*/
    /*上传房源*/
   /* String path1=null;
    @ApiOperation(value = "发布房源", notes = "记录",httpMethod = "PUT")
    @RequestMapping("/upload")
    public String upload(String localPath,MultipartFile file){
        String path = FileSave.fileSave(file,localPath);
        System.out.println(localPath+"----"+file.getName());
        path1=path;
        return path;
    }*/
    /*@ApiOperation(value = "上传图片", notes = "记录", httpMethod = "GET")
    @RequestMapping("uploadHome")
    public Map<String,String> uploadHome(Integer count,String title){
        Map<String,String> res = new HashMap<>();
        System.out.println(count+"----"+title+"----"+path1);
        res.put("msg",title);
        return res;
    }*/
}
