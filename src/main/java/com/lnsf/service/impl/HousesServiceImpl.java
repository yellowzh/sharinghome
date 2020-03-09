package com.lnsf.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lnsf.dao.HousesMapper;
import com.lnsf.dto.HousesDTO;
import com.lnsf.entity.HousesEntity;
import com.lnsf.entity.UserInfoEntity;
import com.lnsf.service.HousesService;
import com.lnsf.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class HousesServiceImpl implements HousesService {
    @Autowired
    private HousesMapper housesMapper;

    @Autowired
    private UserInfoService userInfoService;

    /*查询所有房屋*/
    @Override
    public List<HousesDTO> getAllHomeShow() {
        List<HousesEntity> houses = housesMapper.selectList(null);
        List<HousesDTO> housesDTOS = getUserByHId(houses);
        return housesDTOS;
    }

    @Override
    public List<HousesDTO> getIndexHomeShow() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("houses_falgs",0);
        List<HousesEntity> houses = housesMapper.selectList(wrapper);
        List<HousesDTO> housesDTOS = getUserByHId(houses);
        return housesDTOS;
    }

    /*查房屋主人*/
    public List<HousesDTO> getUserByHId(List<HousesEntity> houses) {
        List<HousesDTO> housesDTOS = new ArrayList<>();
        if (houses.size() != 0) {
            HousesDTO housesDTO = null;
            /*把房主装进去*/
            for (HousesEntity h : houses) {
                UserInfoEntity userInfo = userInfoService.getUserById(h.getBusinessId());
                housesDTO = new HousesDTO();
                BeanUtil.copyProperties(h, housesDTO);
                if (null != userInfo) {
                    housesDTO.setUserInfo(userInfo);
                }
                housesDTOS.add(housesDTO);
            }
            return housesDTOS;
        }else {
            return null;
        }
    }
    /*模糊查询，加状态查询*/
    @Override
    public List<HousesDTO> getAllHousesShowLikeTitle(HousesEntity houses) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("houses_title",houses.getHousesTitle());
        List<HousesEntity> housesLike = housesMapper.selectList(wrapper);
        List<HousesDTO> housesDTOS = getUserByHId(housesLike);
        return housesDTOS;
    }

    @Override
    public Boolean deleteHouse(Integer houseId) {
        HousesEntity houses = new HousesEntity();
        houses.setHousesId(houseId);
        houses.setHousesFalgs("2");
        boolean falg=false;
        int num = housesMapper.updateById(houses);
        if (num>0){
            falg=true;
        }
        return falg;
    }

    @Override
    public HousesDTO getHomeShowById(Integer id) {
        HousesEntity housesEntity = housesMapper.selectById(id);
        HousesDTO housesDTO =new HousesDTO();

        if (null != housesEntity) {
            BeanUtil.copyProperties(housesEntity, housesDTO);
            UserInfoEntity userInfoEntity = userInfoService.getUserById(housesEntity.getBusinessId());
            housesDTO.setUserInfo(userInfoEntity);
        }
        return housesDTO;
    }

    @Override
    public int updateHouses(HousesEntity houses) {
        return housesMapper.updateById(houses);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHouses(HousesEntity houses) {
        return housesMapper.insert(houses);
    }
}
