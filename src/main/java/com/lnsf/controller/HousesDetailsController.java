package com.lnsf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.HousesDetailsEntity;
import com.lnsf.service.HousesDetailsService;
import java.util.List;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lnsf.dto.HousesDetailsDTO;
import javax.validation.Valid;



/**
 *  前端控制器
 *
 * @author 黄润志
 * @since 2020-03-10 13:30
 */

@Api(tags = "")
@RestController
@RequestMapping("/api")
public class HousesDetailsController {

    @Autowired
    private HousesDetailsService housesDetailsService;


    @ApiOperation("查看房源详细信息查看")
    @GetMapping("/select/housesDetailsById")
    public HousesDetailsEntity housesDetailsById(Integer housesId){
        return housesDetailsService.getHousesDetails(housesId);
    }

    @ApiOperation("新增")
    @PostMapping("/addHousesDeByUser")
    public HousesDetailsEntity create(@RequestBody HousesDetailsEntity photoDto){
        System.out.println(photoDto.getHousesId());
        return housesDetailsService.create(photoDto);
    }
    @ApiOperation("更新")
    @PostMapping("/updateHousesDeByUser")
    public HousesDetailsEntity updateHousesDeByUser(Integer housesId,@RequestBody HousesDetailsDTO dto) {
        return housesDetailsService.updateHousesDeByUser(housesId, dto);
    }
//    @ApiOperation("列表")
//    @GetMapping
//    public List<HousesDetailsEntity> list(){
//        return housesDetailsService.list();
//    }
//

//
//    @ApiOperation("删除")
//    @DeleteMapping("{housesId}")
//    public void delete(@ApiParam("") @PathVariable(name = "housesId") Integer housesId) {
//        housesDetailsService.delete(housesId);
//    }
//


}
