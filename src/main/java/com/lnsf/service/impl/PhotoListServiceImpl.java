package com.lnsf.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lnsf.entity.PhotoListEntity;
import com.lnsf.dao.PhotoListMapper;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Random;

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
        wrapper.eq("is_del",false);
        wrapper.eq("housesId",housesId);
        wrapper.orderByDesc("create_time");
        return photoListMapper.selectList(wrapper);
    }

    @Override
    public PhotoListEntity addHousesPhoto(PhotoListEntity photoListEntity) {
        if (null == photoListEntity) {
            throw new ServiceException("参数为空!");
        }
        String path="p"+ DateUtil.today().replace("-","");
        /*生成一个5位数的随机数*/
        int radom = new Random().nextInt(999);
        if (radom < 100) {
            radom += 100;
        }
        String photoId = path+radom;
        photoListEntity.setPhotoId(photoId);
        photoListMapper.insert(photoListEntity);
        return photoListEntity;
    }

    @Override
    public void delete(String photoId) {
        if (null == photoId) {
            return;
        }
        photoListMapper.deleteById(photoId);
    }
   public PhotoListEntity getPhotoById(String photoId){
        return photoListMapper.selectById(photoId);
    }
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
