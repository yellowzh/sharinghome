package com.lnsf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lnsf.dto.HousesDTO;
import com.lnsf.entity.HousesEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.mapstruct.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *  Mapper 接口
 *
 * @author 黄润志
 * @since 2020-03-05 19:15
 */
public interface HousesMapper extends BaseMapper<HousesEntity> {

    List<HousesEntity> page(@Param("dto") HousesDTO dto, IPage<HousesEntity> page);

}
