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



    List<IndexSlideEntity> list();

    void delete(Integer slideId);
    /*修改*/
    IndexSlideEntity update(Integer slideId, IndexSlideDTO dto);
    /*查询原先轮播图列表*/
    List<IndexSlideDTO> selectOldSlideList();
    /*删除轮播*/
    String delSlideUpdate(Integer slideId);
    /*查询单条*/
    IndexSlideDTO getIndexSlide(Integer slideId);
    /*添加*/
    IndexSlideEntity create(IndexSlideDTO dto);
}
