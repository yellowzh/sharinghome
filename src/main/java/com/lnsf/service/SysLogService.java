package com.lnsf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.SysLogDTO;
import com.lnsf.entity.SysLogEntity;

import java.util.List;


/**
 * 日志表 服务类
 *
 * @author 黄润志
 * @since 2020-03-06 14:12
 */
public interface SysLogService {

//    SysLogEntity getSysLog(String logId);

    List<SysLogEntity> list();

    SysLogEntity create(SysLogDTO dto);
    /*查询近五天登录人数*/
    Integer loginNum();
}
