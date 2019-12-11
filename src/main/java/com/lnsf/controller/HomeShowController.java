package com.lnsf.controller;

import com.lnsf.bean.Homeshow;
import com.lnsf.service.HomeShowService;
import com.lnsf.util.FileSave;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Api(description = "房源模块",tags = "房源模块控制层")
@RequestMapping("api")
@RestController
public class HomeShowController {
    @Autowired
    private HomeShowService homeShowService;
    /*查看所有房源*/
    /*value：方法标注*/
    @ApiOperation(value = "查看所有房源", notes = "记录",httpMethod = "POST")
    @RequestMapping("/getAllHomeShow")
    public List<Homeshow> getAllHomeShow(){
        return homeShowService.getAllHomeShow();
    }
    /*查看房源详情*/
    @ApiOperation(value = "查看所有房源详情", notes = "记录",httpMethod = "POST")
    @RequestMapping("/getHomeShow")
    public Homeshow getAllHomeShow(Integer homeId){
        return homeShowService.getHomeShowById(homeId);
    }
    @ApiOperation(value = "查看所有房源详情", notes = "记录",httpMethod = "DELETE")
    @RequestMapping("/deleteHome")
    public int deleteHome(Integer homeId){
        return 0;
    }
    /*上传房源*/
    String path1=null;
    @ApiOperation(value = "发布房源", notes = "记录",httpMethod = "PUT")
    @RequestMapping("/upload")
    public String upload(String localPath,MultipartFile file){
        String path = FileSave.fileSave(file,localPath);
        System.out.println(localPath+"----"+file.getName());
        path1=path;
        return path;
    }
    @ApiOperation(value = "上传图片", notes = "记录", httpMethod = "GET")
    @RequestMapping("uploadHome")
    public Map<String,String> uploadHome(Integer count,String title){
        Map<String,String> res = new HashMap<>();
        System.out.println(count+"----"+title+"----"+path1);
        res.put("msg",title);
        return res;
    }
}
