package com.lnsf.dao;

import com.lnsf.entity.IndexSlideEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.lnsf.dto.IndexSlideDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 *  Mapper 接口
 *
 * @author 黄润志
 * @since 2020-03-07 09:32
 */
@Mapper
public interface IndexSlideMapper extends BaseMapper<IndexSlideEntity> {

    List<IndexSlideEntity> page(@Param("dto")IndexSlideDTO dto, IPage<IndexSlideEntity> page);

}
