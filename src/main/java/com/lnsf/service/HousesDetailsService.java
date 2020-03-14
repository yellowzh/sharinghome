package com.lnsf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.HousesDetailsDTO;
import com.lnsf.entity.HousesDetailsEntity;

import java.util.List;


/**
 *  服务类
 *
 * @author 黄润志
 * @since 2020-03-10 15:10
 */
public interface HousesDetailsService {

    HousesDetailsEntity getHousesDetails(Integer housesId);

//    List<String> list(HousesDetailsEntity housesDetailsEntity);
//
//    HousesDetailsEntity create(HousesDetailsDTO dto);
//
//    void delete(Integer housesId);
//
//    HousesDetailsEntity update(Integer housesId, HousesDetailsDTO dto);
//
//    List<HousesDetailsEntity> page(HousesDetailsDTO dto, IPage<HousesDetailsEntity> page);
}
