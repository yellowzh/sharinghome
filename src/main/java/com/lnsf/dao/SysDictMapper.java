package com.lnsf.dao;

import com.lnsf.entity.SysDictEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.lnsf.dto.SysDictDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 字典表 Mapper 接口
 *
 * @author 黄润志
 * @since 2020-03-09 12:36
 */
@Mapper
public interface SysDictMapper extends BaseMapper<SysDictEntity> {

    List<SysDictEntity> page(@Param("dto")SysDictDTO dto, IPage<SysDictEntity> page);

}
