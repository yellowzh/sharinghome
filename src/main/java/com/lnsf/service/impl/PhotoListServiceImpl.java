package com.lnsf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lnsf.entity.PhotoListEntity;
import com.lnsf.dto.PhotoListDTO;
import com.lnsf.dao.PhotoListMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.hutool.core.bean.BeanUtil;
import com.lnsf.service.PhotoListService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 *  服务实现类
 *
 * @author 黄润志
 * @since 2020-03-06 19:58
 */
@Service
public class PhotoListServiceImpl implements PhotoListService {

    @Autowired
    private PhotoListMapper photoListMapper;

    @Override
    public List<PhotoListEntity> list(Integer housesId){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("housesId",housesId);
        return photoListMapper.selectList(null);
    }

//    @Override
//    public PhotoListEntity create(PhotoListDTO dto) {
//        if (null == dto) {
//            throw new ServiceException("参数为空!");
//        }
//        PhotoListEntity entity = new PhotoListEntity();
//        BeanUtil.copyProperties(dto, entity);
//        photoListMapper.insert(entity);
//        return entity;
//    }

//    @Override
//    public void delete(String photoId) {
//        if (null == photoId) {
//            return;
//        }
//        photoListMapper.deleteById(photoId);
//    }
//
//    @Override
//    public PhotoListEntity update(String photoId, PhotoListDTO dto) {
//        if (null == photoId) {
//            return null;
//        }
//        PhotoListEntity existEntity = photoListMapper.selectById(photoId);
//        if (null == existEntity) {
//            return null;
//        }
//        BeanUtil.copyProperties(dto, existEntity);
//        photoListMapper.updateById(existEntity);
//        return existEntity;
//    }
//


}
