package com.lnsf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lnsf.entity.ExamineLogEntity;
import com.lnsf.dto.ExamineLogDTO;
import com.lnsf.dao.ExamineLogMapper;
import com.lnsf.service.ExamineLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.hutool.core.bean.BeanUtil;
import com.lnsf.util.DateUtil;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *  服务实现类
 *
 * @author 黄润志
 * @since 2020-03-23 11:55
 */
@Service
public class ExamineLogServiceImpl implements ExamineLogService {

    @Autowired
    private ExamineLogMapper examineLogMapper;


    @Override
    public Integer list(){
        QueryWrapper wrapper = new QueryWrapper();
        /*计算前五天时间*/
        String preDay= DateUtil.dayago();
        wrapper.ge("create_time",preDay);
        return examineLogMapper.selectCount(wrapper);
    }

    @Override
    public ExamineLogEntity create(ExamineLogDTO dto) {
        if (null == dto) {
            throw new ServiceException("参数为空!");
        }
        ExamineLogEntity entity = new ExamineLogEntity();
        BeanUtil.copyProperties(dto, entity);
        examineLogMapper.insert(entity);
        return entity;
    }

}
