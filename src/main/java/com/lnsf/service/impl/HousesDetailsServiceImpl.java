package com.lnsf.service.impl;

import com.lnsf.entity.HousesDetailsEntity;
import com.lnsf.dto.HousesDetailsDTO;
import com.lnsf.dao.HousesDetailsMapper;
import com.lnsf.service.HousesDetailsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.hutool.core.bean.BeanUtil;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<HousesDetailsEntity> list(){
        return housesDetailsMapper.selectList(null);
    }

    @Override
    public HousesDetailsEntity create(HousesDetailsDTO dto) {
        if (null == dto) {
            throw new ServiceException("参数为空!");
        }
        HousesDetailsEntity entity = new HousesDetailsEntity();
        BeanUtil.copyProperties(dto, entity);
        housesDetailsMapper.insert(entity);
        return entity;
    }

    @Override
    public void delete(Integer housesId) {
        if (null == housesId) {
            return;
        }
        housesDetailsMapper.deleteById(housesId);
    }

    @Override
    public HousesDetailsEntity update(Integer housesId, HousesDetailsDTO dto) {
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

    @Override
    public List<HousesDetailsEntity> page(HousesDetailsDTO dto, IPage<HousesDetailsEntity> page) {
        return housesDetailsMapper.page(dto, page);
    }

}
