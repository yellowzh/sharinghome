package com.lnsf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.PhotoListEntity;
import com.lnsf.service.PhotoListService;
import java.util.List;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lnsf.dto.PhotoListDTO;
import javax.validation.Valid;



/**
 *  前端控制器
 *
 * @author 黄润志
 * @since 2020-03-06 19:58
 */

@Api(tags = "")
@RestController
@RequestMapping("/api")
public class PhotoListController {

    @Autowired
    private PhotoListService photoListService;


    @ApiOperation("列表")
    @GetMapping(path ="/select/photoList" )
    public List<PhotoListEntity> photoList(Integer housesId){
        return photoListService.list(housesId);
    }

//    @ApiOperation("删除")
//    @DeleteMapping("{photoId}")
//    public void delete(@ApiParam("") @PathVariable(name = "photoId") String photoId) {
//        photoListService.delete(photoId);
//    }
//
//    @ApiOperation("更新")
//    @PutMapping("{photoId}")
//    public PhotoListEntity update(@ApiParam("") @PathVariable("photoId") String photoId,
//                            @RequestBody @Valid PhotoListDTO dto) {
//        return photoListService.update(photoId, dto);
//    }


}
