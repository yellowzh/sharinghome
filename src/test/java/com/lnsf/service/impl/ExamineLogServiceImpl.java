package com.lnsf.service.impl;

import com.lnsf.entity.ExamineLogEntity;
import com.lnsf.dto.ExamineLogDTO;
import com.lnsf.dao.ExamineLogMapper;
import com.lnsf.service.ExamineLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.hutool.core.bean.BeanUtil;
import com.bgy.cs.common.core.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 *  服务实现类
 *
 * @author 黄润志
 * @since 2020-03-24 20:41
 */
@Service
public class ExamineLogServiceImpl implements ExamineLogService {

    @Autowired
    private ExamineLogMapper examineLogMapper;

    @Override
    public ExamineLogEntity getExamineLog(Long examineId){
        return examineLogMapper.selectById(examineId);
    }

    @Override
    public List<ExamineLogEntity> list(){
        return examineLogMapper.selectList(null);
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

    @Override
    public void delete(Long examineId) {
        if (null == examineId) {
            return;
        }
        examineLogMapper.deleteById(examineId);
    }

    @Override
    public ExamineLogEntity update(Long examineId, ExamineLogDTO dto) {
        if (null == examineId) {
            return null;
        }
        ExamineLogEntity existEntity = examineLogMapper.selectById(examineId);
        if (null == existEntity) {
            return null;
        }
        BeanUtil.copyProperties(dto, existEntity);
        examineLogMapper.updateById(existEntity);
        return existEntity;
    }

    @Override
    public List<ExamineLogEntity> page(ExamineLogDTO dto, IPage<ExamineLogEntity> page) {
        return examineLogMapper.page(dto, page);
    }

}
