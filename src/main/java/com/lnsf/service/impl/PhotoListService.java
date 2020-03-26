package com.lnsf.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.PhotoListDTO;
import com.lnsf.entity.PhotoListEntity;

import java.util.List;


/**
 *  服务类
 *
 * @author 黄润志
 * @since 2020-03-06 19:58
 */
public interface PhotoListService {

    List<PhotoListEntity> list(Integer housesId);

    PhotoListEntity addHousesPhoto(PhotoListEntity dto);

    void delete(String photoId);

    PhotoListEntity getPhotoById(String photoId);

//    PhotoListEntity update(String photoId, PhotoListDTO dto);

}
