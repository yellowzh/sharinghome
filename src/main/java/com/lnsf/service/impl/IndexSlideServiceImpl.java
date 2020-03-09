package com.lnsf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lnsf.entity.IndexSlideEntity;
import com.lnsf.dto.IndexSlideDTO;
import com.lnsf.dao.IndexSlideMapper;
import com.lnsf.service.IndexSlideService;
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
 * @since 2020-03-07 09:32
 */
@Service
public class IndexSlideServiceImpl implements IndexSlideService {

    @Autowired
    private IndexSlideMapper indexSlideMapper;

    @Override
    public IndexSlideEntity getIndexSlide(Long slideId){
        return indexSlideMapper.selectById(slideId);
    }

    @Override
    public List<IndexSlideEntity> list(){
        return indexSlideMapper.selectList(null);
    }

    @Override
    public IndexSlideEntity create(IndexSlideDTO dto) {
        if (null == dto) {
            throw new ServiceException("参数为空!");
        }
        IndexSlideEntity entity = new IndexSlideEntity();
        BeanUtil.copyProperties(dto, entity);
        indexSlideMapper.insert(entity);
        return entity;
    }

    @Override
    public void delete(Long slideId) {
        if (null == slideId) {
            return;
        }
        indexSlideMapper.deleteById(slideId);
    }

    @Override
    public IndexSlideEntity update(Long slideId, IndexSlideDTO dto) {
        if (null == slideId) {
            return null;
        }
        IndexSlideEntity existEntity = indexSlideMapper.selectById(slideId);
        if (null == existEntity) {
            return null;
        }
        BeanUtil.copyProperties(dto, existEntity);
        indexSlideMapper.updateById(existEntity);
        return existEntity;
    }
    /*查询原先轮播图列表*/
    public List<IndexSlideEntity> selectOldSlideList(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("is_del",false);
        wrapper.orderByAsc("slide_order");
        return indexSlideMapper.selectList(wrapper);
    }

}
