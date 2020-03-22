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

    HousesDetailsEntity create(HousesDetailsEntity housesDetailsEntity);

    HousesDetailsEntity updateHousesDeByUser(Integer housesId, HousesDetailsDTO dto);
//    List<String> list(HousesDetailsEntity housesDetailsEntity);
//

//
//    void delete(Integer housesId);
//

//
//    List<HousesDetailsEntity> page(HousesDetailsDTO dto, IPage<HousesDetailsEntity> page);
}
