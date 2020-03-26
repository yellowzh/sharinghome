package com.lnsf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.ExamineLogDTO;
import com.lnsf.entity.ExamineLogEntity;

import java.util.List;


/**
 *  服务类
 *
 * @author 黄润志
 * @since 2020-03-24 20:41
 */
public interface ExamineLogService {

    ExamineLogEntity getExamineLog(Long examineId);

    List<ExamineLogEntity> list();

    ExamineLogEntity create(ExamineLogDTO dto);

    void delete(Long examineId);

    ExamineLogEntity update(Long examineId, ExamineLogDTO dto);

    List<ExamineLogEntity> page(ExamineLogDTO dto, IPage<ExamineLogEntity> page);
}
