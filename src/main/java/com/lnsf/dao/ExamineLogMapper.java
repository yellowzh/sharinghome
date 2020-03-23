package com.lnsf.dao;

import com.lnsf.entity.ExamineLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import com.lnsf.dto.ExamineLogDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 *  Mapper 接口
 *
 * @author 黄润志
 * @since 2020-03-23 11:55
 */
@Repository
public interface ExamineLogMapper extends BaseMapper<ExamineLogEntity> {

    List<ExamineLogEntity> page(@Param("dto")ExamineLogDTO dto, IPage<ExamineLogEntity> page);

}
