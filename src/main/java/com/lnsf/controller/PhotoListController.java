package com.lnsf.controller;

import com.lnsf.entity.UserInfoEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.PhotoListEntity;
import com.lnsf.service.PhotoListService;
import java.util.List;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lnsf.dto.PhotoListDTO;

import javax.servlet.http.HttpSession;
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

    /*添加房源图片*/
    @ApiOperation("添加房源图片")
    @PostMapping(path ="/addHousesPhoto" )
    @Transactional
    public List<PhotoListEntity> addHousesPhoto(@RequestBody PhotoListEntity photoListEntity, HttpSession session){
        /*添加*/
        UserInfoEntity user = (UserInfoEntity) session.getAttribute("user");
        System.out.println("添加房源图片:"+photoListEntity.getHousesId());
        photoListEntity.setCreateUser("huang");
//        photoListEntity.setCreateUser(user.getUsername());
        photoListService.addHousesPhoto(photoListEntity);
       return photoListService.list(photoListEntity.getHousesId());
    }


    @ApiOperation("删除")
    @GetMapping("/delPhoto")
    public List<PhotoListEntity> delete(String photoId) {
        PhotoListEntity photoListEntity = photoListService.getPhotoById(photoId);
        photoListService.delete(photoId);
        return photoListService.list(photoListEntity.getHousesId());
    }
//
//    @ApiOperation("更新")
//    @PutMapping("{photoId}")
//    public PhotoListEntity update(@ApiParam("") @PathVariable("photoId") String photoId,
//                            @RequestBody @Valid PhotoListDTO dto) {
//        return photoListService.update(photoId, dto);
//    }


}
