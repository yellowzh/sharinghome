package com.lnsf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.IndexSlideDTO;
import com.lnsf.entity.IndexSlideEntity;

import java.util.List;


/**
 *  服务类
 *
 * @author 黄润志
 * @since 2020-03-07 09:32
 */
public interface IndexSlideService {

    IndexSlideEntity getIndexSlide(Long slideId);

    List<IndexSlideEntity> list();

    IndexSlideEntity create(IndexSlideDTO dto);

    void delete(Long slideId);

    IndexSlideEntity update(Long slideId, IndexSlideDTO dto);
    /*查询原先轮播图列表*/
    List<IndexSlideEntity> selectOldSlideList();
}
