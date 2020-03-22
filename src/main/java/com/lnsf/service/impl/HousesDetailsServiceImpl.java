package com.lnsf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lnsf.entity.HousesDetailsEntity;
import com.lnsf.dto.HousesDetailsDTO;
import com.lnsf.dao.HousesDetailsMapper;
import com.lnsf.service.HousesDetailsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.hutool.core.bean.BeanUtil;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 *  服务实现类
 *
 * @author 黄润志
 * @since 2020-03-10 15:10
 */
@Service
public class HousesDetailsServiceImpl implements HousesDetailsService {

    @Autowired
    private HousesDetailsMapper housesDetailsMapper;

    @Override
    public HousesDetailsEntity getHousesDetails(Integer housesId){
        return housesDetailsMapper.selectById(housesId);
    }

    @Override
    public HousesDetailsEntity create(HousesDetailsEntity housesDetailsEntity) {
        if (null == housesDetailsEntity) {
            throw new ServiceException("参数为空!");
        }
        housesDetailsMapper.insert(housesDetailsEntity);
        return housesDetailsEntity;
    }
    @Override
    public HousesDetailsEntity updateHousesDeByUser(Integer housesId, HousesDetailsDTO dto) {
        if (null == housesId) {
            return null;
        }
        HousesDetailsEntity existEntity = housesDetailsMapper.selectById(housesId);
        if (null == existEntity) {
            return null;
        }
        BeanUtil.copyProperties(dto, existEntity);
        housesDetailsMapper.updateById(existEntity);
        return existEntity;
    }
//    /*首页搜索查询列表*/
//    @Override
//    public List<String> list(HousesDetailsEntity housesDetailsEntity){
//        List<String> idList = new ArrayList<>();
//        if (null == housesDetailsEntity) {
//
//            return idList;
//        }else {
//            QueryWrapper wrapper = new QueryWrapper();
//            if (null!=housesDetailsEntity.getInNum()){
//                wrapper.eq("in_num",housesDetailsEntity.getInNum());
//            }if (null!=housesDetailsEntity.getDictId()){
//                wrapper.eq("dict_id",housesDetailsEntity.getDictId());
//            }
//            List<HousesDetailsEntity> housesDetailsEntityList =  housesDetailsMapper.selectList(wrapper);
//            for (HousesDetailsEntity h:housesDetailsEntityList) {
//                idList.add(h.getHousesId()+"");
//            }
//            return idList;
//        }
//    }


//
//    @Override
//    public void delete(Integer housesId) {
//        if (null == housesId) {
//            return;
//        }
//        housesDetailsMapper.deleteById(housesId);
//    }
//

//
//    @Override
//    public List<HousesDetailsEntity> page(HousesDetailsDTO dto, IPage<HousesDetailsEntity> page) {
//        return housesDetailsMapper.page(dto, page);
//    }

}
