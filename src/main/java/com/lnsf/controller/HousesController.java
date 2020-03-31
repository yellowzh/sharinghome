package com.lnsf.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.HousesDTO;
import com.lnsf.entity.HousesDetailsEntity;
import com.lnsf.entity.HousesEntity;
import com.lnsf.entity.SysDictEntity;
import com.lnsf.entity.UserInfoEntity;
import com.lnsf.service.HousesDetailsService;
import com.lnsf.service.HousesService;
import com.lnsf.service.SysDictService;
import com.lnsf.service.UserInfoService;
import com.lnsf.util.UploadImgUtil;
import com.lnsf.vo.HousesDetailsVO;
import com.lnsf.vo.HousesExamineVO;
import com.lnsf.vo.HousesVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Api(description = "房源模块",tags = "房源模块控制层")
@RequestMapping("api")
@RestController
public class HousesController {
    @Autowired
    private HousesService housesService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private HousesDetailsService housesDetailsService;
    @Autowired
    private SysDictService sysDictService;

    private static Logger log = Logger.getLogger(LoginController.class);
    /*查看所有房源*/
    /*value：方法标注*/
    @ApiOperation(value = "查看所有房源", notes = "记录",httpMethod = "GET")
    @RequestMapping("/getAllHomeShow")
    public ModelAndView getAllHomeShow(Map<String, Object> map, Integer page){
        log.info("获取用户数据"+map.get("user"));
        if (page==null)
        {page=1;}
        IPage<HousesEntity> infoEntityIPage = housesService.getAllHomeShowPage(page);
        /*如果为最后一页则返回最后一页数据*/
        if(infoEntityIPage.getCurrent()>infoEntityIPage.getPages()){
            page=Integer.parseInt(String.valueOf(infoEntityIPage.getPages()));
            infoEntityIPage = housesService.getAllHomeShowPage(page);
        }
        map=maps(infoEntityIPage,map);
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
        if (house.getHousesTitle()==null){
            house.setHousesTitle(housesTitle);
        }else {
            housesTitle=house.getHousesTitle();
        }
        log.info("house.getHousesTitle():"+house.getHousesTitle()+"--housesTitle:"+housesTitle);
        IPage<HousesEntity> infoEntityIPage = housesService.getAllHousesShowLikeTitle(house,page);
        if(infoEntityIPage.getCurrent()>infoEntityIPage.getPages()){
            page=Integer.parseInt(String.valueOf(infoEntityIPage.getPages()));
            infoEntityIPage = housesService.getAllHousesShowLikeTitle(house,page);
        }
        map=maps(infoEntityIPage,map);
        /*返回跳转页面*/
        map.put("request","getHousesLikeName");
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/houses");
        return model_html;
    }
    /*分页数据返回*/
    public Map<String,Object> maps(IPage<HousesEntity> list, Map<String,Object> map ){
        System.out.println("页面取值：size"+list.getSize()+"-to-:"+list.getTotal()+"=page=="+list.getPages()+"cun:"+list.getCurrent());
        List<HousesDTO> houses = new ArrayList<>();
        for (HousesEntity h:list.getRecords()) {
            HousesDTO housesDTO = new HousesDTO();
            UserInfoEntity userInfoEntity =userInfoService.getUserById(h.getBusinessId());
            BeanUtil.copyProperties(h, housesDTO);
            housesDTO.setUserInfo(userInfoEntity);
            houses.add(housesDTO);
        }
        map.put("houses",houses);
        map.put("totalPage",list.getPages());
        map.put("indexPage",list.getCurrent());
        return map;
    }
    /**
    *@Description 删除房源
    *@Author huangrunzhi
    *@Date 2020/1/27 10:24
    */
    @ApiOperation(value = "删除房源", notes = "删除用户",httpMethod = "DELETE")
    @RequestMapping("/deleteHouse")
    @CacheEvict(value = "findAllHouses",allEntries = true)
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
    @CacheEvict(value = "findAllHouses",allEntries = true)
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
    @CacheEvict(value = "findAllHouses",allEntries = true)
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
    @CacheEvict(value = "findAllHouses",allEntries = true)
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

    /*首页查看房源详情*/
    @ApiOperation(value = "查看房源详情", notes = "记录",httpMethod = "POST")
    @RequestMapping("/getHomeShowById")
    public HousesDTO getHomeShowById(Integer houserId){
        return housesService.getHomeShowById(houserId);
    }

    @ApiOperation("查看所有房源")
    @GetMapping(path = "/select/findAllHouses")
    @Cacheable(value = "findAllHouses")
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
    /**
    *@Description
    *@Author huangrunzhi
    *@Date 2020/3/15 23:35
    */
    @ApiOperation(value = "查询我的房源", notes = "查询我的房源",httpMethod = "GET")
    @RequestMapping("/getMyHouses")
    public List<HousesDTO> getMyHouses(HttpServletRequest httpServletRequest){
        UserInfoEntity userInfoEntity = (UserInfoEntity)httpServletRequest.getSession().getAttribute("user");
        if (null==userInfoEntity){
            return null;
        }else {
            return housesService.getMyHousesByUserId(userInfoEntity.getUserId());
        }
    }
    @ApiOperation(value = "查询我的房源页面跳转", notes = "查询我的房源",httpMethod = "GET")
    @RequestMapping("/myHouse")
    public ModelAndView myHouses(){
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("user/myhouses");
        return model_html;
    }

    @ApiOperation(value = "查询我的房源页面跳转", notes = "查询我的房源",httpMethod = "POST")
    @RequestMapping("/updateMyHouses")
    public String updateMyHouses(String housesFalgs,Integer housesId){
        return housesService.updateHousesByFalgs(housesFalgs,housesId);
    }
    /*后台管理系统推荐列表的推荐*/
    @ApiOperation("查看所有推荐房源")
    @GetMapping(path = "/getRecommendHouses")
    public List<HousesDTO> getRecommendHouses(){
        log.info("查看所有推荐房源：");
        List<HousesDTO> houses = housesService.getIndexHomeShow();
        return houses;
    }
    @ApiOperation("未推荐的所有在线房源")
    @GetMapping(path = "/getNotRecommendHouses")
    public List<HousesDTO> getNotRecommendHouses(){
        log.info("查看所有推荐房源：");
        List<HousesDTO> houses = housesService.getNotRecommendHouses();
        return houses;
    }
    @ApiOperation("推荐房源")
    @GetMapping(path = "/recomHouses")
    public String recomHouses(Integer houserId){
        log.info("查看所有推荐房源：");
        String falg = housesService.recomHouses(houserId);
        return falg;
    }
    @ApiOperation("推荐房源")
    @GetMapping(path = "/delrecomHouses")
    public String delrecomHouses(Integer houserId){
        log.info("查看所有推荐房源：");
        String falg = housesService.delrecomHouses(houserId);
        return falg;
    }
    @ApiOperation("查看所有在线房源")
    @GetMapping(path = "/getAllHousesByNow")
    public List<HousesDTO> getAllHousesByNow(){
        log.info("查看所有在线房源：");
        List<HousesDTO> houses = housesService.getAllHousesByNow();
        return houses;
    }

    @ApiOperation("前台查看所有在线房源")
    @GetMapping(path = "/select/findAllHousesNow")
    public List<HousesDTO> findAllHousesNow(){
        log.info("前台查看所有在线房源：");
        List<HousesDTO> houses = housesService.getAllHousesByNow();
        return houses;
    }

    @ApiOperation("查看所有房源列表")
    @GetMapping(path = "/getAllHouses")
    public List<HousesDTO> getAllHouses(){
        log.info("查看所有在线房源：");
        List<HousesDTO> houses = housesService.getAllHouses();
        return houses;
    }

    @ApiOperation(value = "查询预定页面跳转", notes = "查询我的房源",httpMethod = "GET")
    @RequestMapping("/select/houserlease")
    public ModelAndView houserlease(){
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("user/houserlease");
        return model_html;
    }

    @ApiOperation(value = "我要出租房源认证页面跳转", notes = "出租房源认证",httpMethod = "GET")
    @RequestMapping("/rentalHousing")
    public ModelAndView rentalHousing(){
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("user/rentalHousing");
        return model_html;
    }


    @ApiOperation(value = "我要出租房源认证", notes = "出租房源认证",httpMethod = "POST")
    @RequestMapping("/addHousesByUser")
    public HousesEntity addHousesByUser(@RequestBody HousesDTO housesDTO,HttpSession session){
        UserInfoEntity user = (UserInfoEntity) session.getAttribute("user");
        housesDTO.setBusinessId(user.getUserId());
        housesDTO.setHousesFalgs(3+"");
        return housesService.createHousesByUser(housesDTO);
    }
    @ApiOperation("更新")
    @PostMapping("/updateHousesByUser")
    @CacheEvict(value = "findAllHouses",allEntries = true)
    public HousesEntity updateHousesByUser(Integer housesId,@RequestBody HousesDTO dto) {
        return housesService.updateHousesByUser(housesId, dto);
    }

    /*后台管理商家审核*/
    @RequestMapping("/housesExamine")
    public ModelAndView housesExamine(){
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/housesExamine");
        return model_html;
    }
    /*商家审核*/
    @ApiOperation("商家审核列表分页显示")
    @GetMapping("/gethousesExamineList")
    public HousesExamineVO gethousesExamineList(Integer page){
        if (page==null)
        {page=1;}
        IPage<HousesEntity> EntityIPage = housesService.gethousesExamineList(page);
        /*如果为最后一页则返回最后一页数据*/
        if(EntityIPage.getCurrent()>EntityIPage.getPages()){
            page=Integer.parseInt(String.valueOf(EntityIPage.getPages()));
            EntityIPage = housesService.gethousesExamineList(page);
        }
        List<HousesDTO> houses = new ArrayList<>();
        for (HousesEntity h:EntityIPage.getRecords()) {
            HousesDTO housesDTO = new HousesDTO();
            UserInfoEntity userInfo =userInfoService.getUserById(h.getBusinessId());
            BeanUtil.copyProperties(h, housesDTO);
            housesDTO.setUserInfo(userInfo);
            houses.add(housesDTO);
        }
        HousesExamineVO housesExamineVO = new HousesExamineVO();
        housesExamineVO.setHousesDTOS(houses);
        housesExamineVO.setIndexPage(EntityIPage.getCurrent());
        housesExamineVO.setTotalPage(EntityIPage.getPages());
        return housesExamineVO;
    }
    @ApiOperation("获取商家审核详细信息")
    @GetMapping("/gethousesExamineInfo")
    public HousesDetailsVO gethousesExamineInfo(Integer housesId){
        HousesDetailsVO housesDetailsVO = new HousesDetailsVO();
        HousesDetailsEntity housesDetailsEntity = housesDetailsService.getHousesDetails(housesId);
        if (null==housesDetailsEntity){
            return null;
        }else {
            BeanUtils.copyProperties(housesDetailsEntity,housesDetailsVO);
        }
        /*注入类型*/
        SysDictEntity sysDictEntity = sysDictService.getSysDict(housesDetailsEntity.getDictId());
        housesDetailsVO.setDictType(sysDictEntity.getName());
        return housesDetailsVO;
    }
    /*前台用户修改页面跳转*/

    @RequestMapping("/updateHouseByUser")
    @CacheEvict(value = "findAllHouses",allEntries = true)
    public ModelAndView updateHouseByUser(Integer housesId,Map<String,Object> map){
        map.put("housesId",housesId);
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("user/updateHouses");
        return model_html;
    }
    @RequestMapping("/adminAddHouse")
    public ModelAndView adminAddHouse(){
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/rentalHousing");
        return model_html;
    }





}
