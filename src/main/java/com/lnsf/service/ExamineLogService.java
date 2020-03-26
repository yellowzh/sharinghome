package com.lnsf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.ExamineLogDTO;
import com.lnsf.entity.ExamineLogEntity;

import java.util.List;


/**
 *  服务类
 *
 * @author 黄润志
 * @since 2020-03-23 11:55
 */
public interface ExamineLogService {



    Integer list();

    ExamineLogEntity create(ExamineLogDTO dto);

}
