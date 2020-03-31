package com.lnsf.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.SysDictEntity;
import com.lnsf.service.SysDictService;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lnsf.dto.SysDictDTO;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;



/**
 * 字典表 前端控制器
 *
 * @author 黄润志
 * @since 2020-03-09 12:36
 */

@Api(tags = "字典表")
@RestController
@RequestMapping("/api")
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;
    /*添加缓存*/
    @Cacheable(value="getHousesType",key = "#name")
    @ApiOperation("房源类型查询列表")
    @GetMapping(path = "/select/getHousesType")
    public List<SysDictEntity> getHousesType(String name){
        return sysDictService.getHousesType(name);
    }

    @ApiOperation("查看字典表")
    @GetMapping("/select/sysDictById")
    public SysDictEntity sysDictById(Long dictId){
        System.out.println("查看字典表"+dictId);
        return sysDictService.getSysDict(dictId);
    }
    @ApiOperation("查看字典表")
    @GetMapping("/sysDictById")
    public SysDictEntity sysDictByIdH(Long dictId){
        System.out.println("查看字典表"+dictId);
        return sysDictService.getSysDict(dictId);
    }

    /*管理端查询字典*/
    @ApiOperation("字典查询列表")
    @GetMapping(path = "/getAllDict")
    public List<SysDictEntity> getAllDict(){
        return sysDictService.getAllDictList();
    }
    /*清楚缓存*/
    @CacheEvict(value="getHousesType",allEntries = true)
    @ApiOperation("新增字典表")
    @PostMapping(path = "createAllDict")
    public SysDictEntity createAllDict(@RequestBody SysDictDTO dto){
        return sysDictService.createAllDict(dto);
    }
    /*删除*/
    @CacheEvict(value="getHousesType",allEntries = true)
    @ApiOperation("删除字典")
    @GetMapping("/deleteDict")
    public String deleteDict(Long dictId) {
        return sysDictService.delete(dictId);
    }
    @ApiOperation("管理员端跳转字典管理页面")
    @GetMapping(path = "/getDict")
    public ModelAndView getDict(){
        //获取当前用户
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/dict");
        return model_html;

    }
    @ApiOperation(value = "验证验证字典名称唯一性", notes = "验证字典名",httpMethod = "GET")
    @ResponseBody
    @RequestMapping("dict-exist")
    public Boolean dictIsExist(String name){
        System.out.println("字典名称："+name);
        Boolean dictIsExist = sysDictService.dictIsExist(name);
        System.out.println(dictIsExist);
        return dictIsExist;
    }
    @CacheEvict(value="getHousesType",allEntries = true)
    @ApiOperation("更新字典表")
    @PostMapping("/updateDict")
    public SysDictEntity updateDict(Long dictId,@RequestBody SysDictDTO dto) {
        return sysDictService.update(dictId, dto);
    }
    @ApiOperation("查看子字典")
    @GetMapping("/selectDictson")
    public ModelAndView selectDictson(Long dictId, Map<String, Object> map) {

        map.put("dictId",dictId);
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/dictSon");
        return model_html;
    }
    @ApiOperation("字典查询列表")
    @GetMapping(path = "/getDictson")
    public List<SysDictEntity> getDictson(Long dictId){
        List<SysDictEntity> sysDicts = sysDictService.selectDictson(dictId);
        return sysDicts;
    }



//    @ApiOperation("新增字典表")
//    @PostMapping(path = "create")
//    public SysDictEntity create(@RequestBody @Valid SysDictDTO dto){
//        return sysDictService.create(dto);
//    }
//
//    @ApiOperation("删除字典表")
//    @DeleteMapping("{dictId}")
//    public void delete(@ApiParam("主键id") @PathVariable(name = "dictId") Long dictId) {
//        sysDictService.delete(dictId);
//    }
//


}
