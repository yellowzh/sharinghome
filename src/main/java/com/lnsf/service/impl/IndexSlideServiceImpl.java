package com.lnsf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lnsf.dto.HousesDTO;
import com.lnsf.entity.IndexSlideEntity;
import com.lnsf.dto.IndexSlideDTO;
import com.lnsf.dao.IndexSlideMapper;
import com.lnsf.service.HousesService;
import com.lnsf.service.IndexSlideService;
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
 * @since 2020-03-07 09:32
 */
@Service
public class IndexSlideServiceImpl implements IndexSlideService {

    @Autowired
    private IndexSlideMapper indexSlideMapper;
    @Autowired
    private HousesService housesService;
    @Override
    public IndexSlideDTO getIndexSlide(Integer slideId){
            IndexSlideDTO indexSlideDTO = new IndexSlideDTO();
            IndexSlideEntity indexSlideEntity  = indexSlideMapper.selectById(slideId);
            HousesDTO housesDTO = housesService.getHomeShowById(indexSlideEntity.getHouseId());
            BeanUtil.copyProperties(indexSlideEntity, indexSlideDTO);
            indexSlideDTO.setHousesTilte(housesDTO.getHousesTitle());
        return indexSlideDTO;
    }

    @Override
    public List<IndexSlideEntity> list(){
        return indexSlideMapper.selectList(null);
    }



    @Override
    public void delete(Integer slideId) {
        if (null == slideId) {
            return;
        }
        indexSlideMapper.deleteById(slideId);
    }
    /*更新*/
    @Override
    public IndexSlideEntity update(Integer slideId, IndexSlideDTO dto) {
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
    public List<IndexSlideDTO> selectOldSlideList(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("is_del",false);
        wrapper.orderByAsc("slide_order");
        List<IndexSlideEntity> list = indexSlideMapper.selectList(wrapper);
        List<IndexSlideDTO> lists = new ArrayList<>();
        for (IndexSlideEntity i:list) {
            IndexSlideDTO indexSlideDTO = new IndexSlideDTO();
          HousesDTO housesDTO = housesService.getHomeShowById(i.getHouseId());
            BeanUtil.copyProperties(i, indexSlideDTO);
            indexSlideDTO.setHousesTilte(housesDTO.getHousesTitle());
            lists.add(indexSlideDTO);
        }
        return lists;
    }
    /*删除轮播*/
    public String delSlideUpdate(Integer slideId){
        IndexSlideEntity indexSlideEntity = new IndexSlideEntity();
        indexSlideEntity.setSlideId(slideId);
        indexSlideEntity.setIsDel(true);
        int num = indexSlideMapper.updateById(indexSlideEntity);
        if (num>0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }
    /*添加*/
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

}
