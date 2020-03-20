package com.lnsf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lnsf.dto.HousesDTO;
import com.lnsf.entity.HousesEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.vo.HousesVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  Mapper 接口
 *
 * @author 黄润志
 * @since 2020-03-05 19:15
 */
@Repository
public interface HousesMapper extends BaseMapper<HousesEntity> {

    List<HousesEntity> page(@Param("dto") HousesDTO dto, IPage<HousesEntity> page);

    List<HousesDTO> selectHousesByCondition(@Param("vo") HousesVO vo);

}
