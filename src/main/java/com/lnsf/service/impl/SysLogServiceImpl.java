package com.lnsf.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lnsf.entity.SysLogEntity;
import com.lnsf.dto.SysLogDTO;
import com.lnsf.dao.SysLogMapper;
import com.lnsf.service.SysLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.hutool.core.bean.BeanUtil;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Random;

/**
 * 日志表 服务实现类
 *
 * @author 黄润志
 * @since 2020-03-06 14:12
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;



    @Override
    public List<SysLogEntity> list(){
        return sysLogMapper.selectList(null);
    }

    @Override
    public SysLogEntity create(SysLogDTO dto) {
        if (null == dto) {
            throw new ServiceException("参数为空!");
        }
        SysLogEntity entity = new SysLogEntity();
        BeanUtil.copyProperties(dto, entity);
        String path="log"+ DateUtil.today().replace("-","");
        /*生成一个5位数的随机数*/
        int radom = new Random().nextInt(999);
        if (radom < 100) {
            radom += 100;
        }
        entity.setLogId(path+radom);
        sysLogMapper.insert(entity);
        return entity;
    }

    /*查询近五天登录人数*/
    public Integer loginNum(){
        QueryWrapper wrapper = new QueryWrapper();
        String day = DateUtil.today();
        wrapper.ge("start_time",day);
        wrapper.eq("method","login");
        return sysLogMapper.selectCount(wrapper);
    }

}
