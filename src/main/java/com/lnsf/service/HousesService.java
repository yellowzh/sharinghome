package com.lnsf.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.HousesDTO;
import com.lnsf.entity.HousesEntity;
import com.lnsf.vo.HousesVO;

import java.util.List;

public interface HousesService {
    /*首页查询在线出租的房源*/
    List<HousesDTO> getIndexHomeShow();
    /*首页搜索在线出租的房源*/
    List<HousesDTO> getIndexHomeSelect(HousesVO housesVO);
    /*后台查询所有*/
    IPage<HousesEntity> getAllHomeShowPage(Integer page);

    //模糊查询，后期添加状态查询
    IPage<HousesEntity> getAllHousesShowLikeTitle(HousesEntity houses,Integer page);

    Boolean deleteHouse(Integer houseId);

    HousesDTO getHomeShowById(Integer id);
    /*首页查看房源详情*/
    HousesDTO getIndexHomeShowById(Integer id);
    /*更新*/
    int updateHouses(HousesEntity houses);
    /*添加*/
    int insertHouses(HousesEntity houses);
    /*查看我的房源*/
    List<HousesDTO> getMyHousesByUserId(Integer userId);
    /*更具id更新房源状态*/
    String updateHousesByFalgs(String falgs ,Integer housesId);
    /*查询在线出租但是未推荐的房源*/
    List<HousesDTO> getNotRecommendHouses();
    /*推荐房源*/
    String recomHouses(Integer houseId);
    /*取消推荐房源*/
    String delrecomHouses(Integer houseId);
    /*查看所有在线房源*/
    List<HousesDTO> getAllHousesByNow();
    /*查看所有房源*/
    List<HousesDTO> getAllHouses();
    /*用户申请房源出租*/
    HousesEntity createHousesByUser(HousesDTO housesDTO);
    /*申请时更新*/
    HousesEntity updateHousesByUser(Integer housesId, HousesDTO dto);

}
