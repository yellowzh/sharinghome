package com.lnsf.controller;


import com.lnsf.dto.HousesDTO;
import com.lnsf.entity.HousesEntity;
import com.lnsf.service.HousesService;
import com.lnsf.util.UploadImgUtil;
import com.lnsf.vo.HousesVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
    public ModelAndView getAllHomeShow(Map<String, Object> map, Integer page){
        log.info("获取用户数据"+map.get("user"));
        if (page==null)
        {page=1;}
//        PageHelper.startPage(page,5);
        List<HousesDTO> houses = housesService.getAllHomeShow();
        map=maps(houses,map);
        log.info("所有房源查询"+houses);
        map.put("houses",houses);
        map.put("request","getAllHomeShow");
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/houses");
        return model_html;
    }
    private String housesTitle;
    @ApiOperation(value = "模糊查询房源", notes = "模糊查询",httpMethod = "GET")
    @RequestMapping("/getHousesLikeName")
    public ModelAndView getHousesLikeName(Map<String,Object> map,String power,HousesEntity house,Integer page){
        if (page==null)
        { page=1;}
//        PageHelper.startPage(page,10);

        if (house.getHousesTitle()==null){
            house.setHousesTitle(housesTitle);
        }else {
            housesTitle=house.getHousesTitle();
        }
        log.info("house.getHousesTitle():"+house.getHousesTitle()+"--housesTitle:"+housesTitle);
        List<HousesDTO> houses = housesService.getAllHousesShowLikeTitle(house);
        map=maps(houses,map);
        for (HousesDTO houses1: houses) {
            log.info("模糊查询houses标题:"+houses1.getHousesTitle());
        }
        map.put("houses",houses);
        /*返回跳转页面*/
        map.put("request","getHousesLikeName");
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/houses");
        return model_html;
    }
    /*分页插件数据返回*/
    public Map<String,Object> maps(List<HousesDTO> list,Map<String,Object> map ){
//        PageInfo<HousesDTO> pageInfo = new PageInfo<HousesDTO>(list);
//        map.put("houses",pageInfo.getList());
//        map.put("totalPage",pageInfo.getPages());
//        map.put("indexPage",pageInfo.getPageNum());
        return map;
    }
    /**
    *@Description 删除房源
    *@Author huangrunzhi
    *@Date 2020/1/27 10:24
    */
    @ApiOperation(value = "删除房源", notes = "删除用户",httpMethod = "DELETE")
    @RequestMapping("/deleteHouse")
    public ModelAndView deleteHouse(int houseId,Map<String,Object> map){

        log.info("单个删除houseId{}:"+houseId);
        boolean house = housesService.deleteHouse(houseId);
        /*返回跳转页面*/
        if (house==true){
            map.put("msg","删除房源成功");
        }else {
            map.put("msg","删除房源失败");
        }
        /*页面跳转*/
        /*返回跳转页面*/
        getAllHomeShow(map,1);
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/houses");
        return model_html;
    }
    /**
    *@Description 批量删除房源
    *@Author huangrunzhi
    *@Date 2020/1/27 14:02
    */
    @ApiOperation(value = "批量删除房源", notes = "批量删除房源",httpMethod = "DELETE")
    @RequestMapping("deleteHouses")
    public ModelAndView deleteHouses(String checkedID,Map<String,Object> map){
        String[] strs=checkedID.split(",");
        boolean house=false;
        for (String str:strs) {
            house = housesService.deleteHouse(Integer.parseInt(str));
        }
        /*返回跳转页面*/
        if (house==true){
            map.put("msg","批量删除用户成功");
        }else {
            map.put("msg","批量删除用户失败");
        }
        /*页面跳转*/
        getAllHomeShow(map,1);
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/houses");
        return model_html;
    }
/**
*@Description 修改页面跳转
*@Author huangrunzhi
*@Date 2020/1/27 14:02
*/
@ApiOperation(value = "单个房源查询", notes = "单个房源查询",httpMethod = "DELETE")
    @RequestMapping("updateHousesIndex")
    public ModelAndView updateHousesIndex(Integer housesId,Map<String,Object> map){
    HousesDTO houses = housesService.getHomeShowById(housesId);
        /*返回跳转页面*/
        /*页面跳转*/
        map.put("houses",houses);
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/updateHouses");
        return model_html;
    }
    /**
    *@Description 更新房源
    *@Author huangrunzhi
    *@Date 2020/1/27 14:35
    */
    @ApiOperation(value = "更新房源", notes = "更新房源",httpMethod = "POST")
    @RequestMapping("updateHouses")
    public ModelAndView updateHouses(HousesEntity houses,Map<String,Object> map){
        int falg = housesService.updateHouses(houses);
        /*返回跳转页面*/
        /*页面跳转*/
        if (falg>0){
            map.put("msg","更新成功");
        }else {
            map.put("msg","更新失败");
        }
        getAllHomeShow(map,1);
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/houses");
        return model_html;
    }
    /**
    *@Description 添加房源
    *@Author huangrunzhi
    *@Date 2020/2/4 19:49
    */
    @ApiOperation(value = "添加房源", notes = "添加房源",httpMethod = "POST")
    @RequestMapping("addHouses")
    public ModelAndView addHouses( @RequestParam("file") MultipartFile file,HousesEntity houses,Map<String,Object> map){
        try {
            map= UploadImgUtil.uplond(file,map);
            log.info("上传图片后需要获取的路径："+map.get("filename"));
            houses.setHousesPhoto(String.valueOf(map.get("filename")));
           int falg =  housesService.insertHouses(houses);
            /*返回跳转页面*/
            /*页面跳转*/
            if (falg>0){
                map.put("msg","添加成功");
            }else {
                map.put("msg","添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        getAllHomeShow(map,1);
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/houses");
        return model_html;
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

    @ApiOperation("查看所有房源")
    @GetMapping(path = "/select/findAllHouses")
    public List<HousesDTO> findAllHouses(){
        log.info("查看所有房源：");
        List<HousesDTO> houses = housesService.getIndexHomeShow();
        return houses;
    }
    @ApiOperation(value = "查看房源详情", notes = "查看房源详情",httpMethod = "GET")
    @RequestMapping("/select/findHousesById")
    public ModelAndView findHousesById(Integer houserId,Map<String,Object> map){
        log.info("查看房源详情");
        HousesDTO houses = housesService.getIndexHomeShowById(houserId);
        /*查询房屋详情*/
        map.put("houses",houses);
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("user/housesInfo");
        return model_html;
    }

    /**
    *@Description 拼接查询房源信息
    *@Author huangrunzhi
    *@Date 2020/3/11 10:39
    */
    @ApiOperation(value = "拼接查询房源", notes = "拼接查询房源",httpMethod = "POST")
    @RequestMapping("/select/selectHousesByCondition")
    public List<HousesDTO> selectHousesByCondition(@RequestBody HousesVO housesVO){
        log.info("拼接查询房源--地址："+housesVO.getHousesAddress()+"--时间："+housesVO.getStartTime()+"--入住人数："+housesVO.getPeopleNum());
       List<HousesDTO> houses =  housesService.getIndexHomeSelect(housesVO);
        return houses;
    }

}
