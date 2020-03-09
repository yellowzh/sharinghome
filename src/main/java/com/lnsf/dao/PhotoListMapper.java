package com.lnsf.dao;

import com.lnsf.entity.PhotoListEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.lnsf.dto.PhotoListDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 *  Mapper 接口
 *
 * @author 黄润志
 * @since 2020-03-06 19:58
 */
@Mapper
public interface PhotoListMapper extends BaseMapper<PhotoListEntity> {

    List<PhotoListEntity> page(@Param("dto")PhotoListDTO dto, IPage<PhotoListEntity> page);

}
