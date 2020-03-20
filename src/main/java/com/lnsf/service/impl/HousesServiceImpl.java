package com.lnsf.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lnsf.dao.HousesMapper;
import com.lnsf.dto.HousesDTO;
import com.lnsf.entity.HousesDetailsEntity;
import com.lnsf.entity.HousesEntity;
import com.lnsf.entity.SysDictEntity;
import com.lnsf.entity.UserInfoEntity;
import com.lnsf.service.HousesDetailsService;
import com.lnsf.service.HousesService;
import com.lnsf.service.UserInfoService;
import com.lnsf.vo.HousesVO;
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

    private HousesDetailsService housesDetailsService;

    /*查询所有房屋*/
    @Override
    public IPage<HousesEntity> getAllHomeShowPage(Integer page) {
        IPage<HousesEntity> ipage = new Page<>(page, 8);
        IPage<HousesEntity> pages = housesMapper.selectPage(ipage,null);
        return pages;
    }

    @Override
    public List<HousesDTO> getIndexHomeShow() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("houses_falgs",0);
        /*推荐列表*/
        wrapper.eq("is_recommend",true);
        List<HousesEntity> houses = housesMapper.selectList(wrapper);
        List<HousesDTO> housesDTOS = getUserByHId(houses);
        return housesDTOS;
    }
    /*拼接搜索*/
    @Override
    public List<HousesDTO> getIndexHomeSelect(HousesVO housesVO){
        List<HousesDTO> housesDTOS = housesMapper.selectHousesByCondition(housesVO);
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
    public IPage<HousesEntity> getAllHousesShowLikeTitle(HousesEntity houses,Integer page) {
        IPage<HousesEntity> ipage = new Page<>(page, 8);
        HousesEntity housesEntity = new HousesEntity();
        QueryWrapper<HousesEntity> wrapper = new QueryWrapper<>(housesEntity);
        wrapper.like("houses_title",houses.getHousesTitle());
        IPage<HousesEntity> pages = housesMapper.selectPage(ipage,wrapper);
        return pages;
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
    public HousesDTO getIndexHomeShowById(Integer id){
        HousesEntity housesEntity = housesMapper.selectById(id);
        HousesDTO housesDTO =new HousesDTO();

        if (null != housesEntity) {
            BeanUtil.copyProperties(housesEntity, housesDTO);
            UserInfoEntity userInfoEntity = userInfoService.getUserById(housesEntity.getBusinessId());
            housesDTO.setUserInfo(userInfoEntity);
        }
        /*更新预览量*/
        int num = housesEntity.getHousesView()+1;
        housesEntity.setHousesView(num);
        housesMapper.updateById(housesEntity);

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

    /*查看我的房源*/
    public List<HousesDTO> getMyHousesByUserId(Integer userId){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("business_id",userId);
        wrapper.ne("houses_falgs",2);
        List<HousesEntity> housesLike = housesMapper.selectList(wrapper);
        List<HousesDTO> housesDTOS = getUserByHId(housesLike);
        return housesDTOS;
    }
    /*更新房源状态*/
    public String updateHousesByFalgs(String falgs ,Integer housesId){
        HousesEntity housesEntity = new HousesEntity();
        housesEntity.setHousesFalgs(falgs);
        housesEntity.setHousesId(housesId);
       int houses = housesMapper.updateById(housesEntity);
       if (houses>0){
            if ("0".equals(falgs)){
                return "房源上架成功";
            }
            if ("1".equals(falgs)){
                return "房源下架成功";
            }
            if ("2".equals(falgs)){
                return "房源删除成功";
            }
        }else {
           if ("0".equals(falgs)){
               return "房源上架失败";
           }
           if ("1".equals(falgs)){
               return "房源下架失败";
           }
           if ("2".equals(falgs)){
               return "房源删除失败";
           }
       }
       return null;
    }
   public List<HousesDTO> getNotRecommendHouses(){
       QueryWrapper wrapper = new QueryWrapper();
       wrapper.eq("houses_falgs",0);
       /*推荐列表*/
       wrapper.eq("is_recommend",false);
       List<HousesEntity> houses = housesMapper.selectList(wrapper);
       List<HousesDTO> housesDTOS = getUserByHId(houses);
       return housesDTOS;
    }

    public String recomHouses(Integer houseId){
        HousesEntity housesEntity = new HousesEntity();
        housesEntity.setHousesId(houseId);
        housesEntity.setIsRecommend(true);
        int num = housesMapper.updateById(housesEntity);
        if (num>0){
            return "推荐成功";
        }else {
            return "推荐失败";
        }
    }
    public String delrecomHouses(Integer houseId){
        HousesEntity housesEntity = new HousesEntity();
        housesEntity.setHousesId(houseId);
        housesEntity.setIsRecommend(false);
        int num = housesMapper.updateById(housesEntity);
        if (num>0){
            return "取消成功";
        }else {
            return "取消失败";
        }
    }
    /*查看所有在线出租房源*/
    public List<HousesDTO> getAllHousesByNow(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("houses_falgs",0);
        List<HousesEntity> houses = housesMapper.selectList(wrapper);
        List<HousesDTO> housesDTOS = getUserByHId(houses);
        return housesDTOS;
    }
    /*查看所有房源*/
    public List<HousesDTO> getAllHouses(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.ne("houses_falgs",2);
        List<HousesEntity> houses = housesMapper.selectList(wrapper);
        List<HousesDTO> housesDTOS = getUserByHId(houses);
        return housesDTOS;
    }


}
