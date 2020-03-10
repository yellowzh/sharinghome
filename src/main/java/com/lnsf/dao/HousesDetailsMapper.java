package com.lnsf.dao;

import com.lnsf.entity.HousesDetailsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.lnsf.dto.HousesDetailsDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 *  Mapper 接口
 *
 * @author 黄润志
 * @since 2020-03-10 15:10
 */
@Mapper
public interface HousesDetailsMapper extends BaseMapper<HousesDetailsEntity> {

    List<HousesDetailsEntity> page(@Param("dto")HousesDetailsDTO dto, IPage<HousesDetailsEntity> page);

}
