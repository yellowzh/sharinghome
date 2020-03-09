package com.lnsf.dao;

import com.lnsf.entity.SysLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.lnsf.dto.SysLogDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 日志表 Mapper 接口
 *
 * @author 黄润志
 * @since 2020-03-06 14:12
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLogEntity> {

    List<SysLogEntity> page(@Param("dto")SysLogDTO dto, IPage<SysLogEntity> page);

}
