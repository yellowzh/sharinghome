package com.lnsf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.SysDictEntity;
import com.lnsf.service.SysDictService;
import java.util.List;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lnsf.dto.SysDictDTO;
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

    @ApiOperation("新增字典表")
    @PostMapping(path = "create")
    public SysDictEntity create(@RequestBody @Valid SysDictDTO dto){
        return sysDictService.create(dto);
    }

    @ApiOperation("删除字典表")
    @DeleteMapping("{dictId}")
    public void delete(@ApiParam("主键id") @PathVariable(name = "dictId") Long dictId) {
        sysDictService.delete(dictId);
    }

    @ApiOperation("更新字典表")
    @PutMapping("{dictId}")
    public SysDictEntity update(@ApiParam("主键id") @PathVariable("dictId") Long dictId,
                            @RequestBody @Valid SysDictDTO dto) {
        return sysDictService.update(dictId, dto);
    }

}
