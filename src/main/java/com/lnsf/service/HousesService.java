package com.lnsf.service;


import com.lnsf.dto.HousesDTO;
import com.lnsf.entity.HousesEntity;

import java.util.List;

public interface HousesService {
    /*首页查询在线出租的房源*/
    List<HousesDTO> getIndexHomeShow();
    /*后台查询所有*/
    List<HousesDTO> getAllHomeShow();
    //模糊查询，后期添加状态查询
    List<HousesDTO> getAllHousesShowLikeTitle(HousesEntity houses);

    Boolean deleteHouse(Integer houseId);

    HousesDTO getHomeShowById(Integer id);
    /*更新*/
    int updateHouses(HousesEntity houses);
    /*添加*/
    int insertHouses(HousesEntity houses);
}