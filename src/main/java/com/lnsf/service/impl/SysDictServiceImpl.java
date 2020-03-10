package com.lnsf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lnsf.entity.SysDictEntity;
import com.lnsf.dto.SysDictDTO;
import com.lnsf.dao.SysDictMapper;
import com.lnsf.service.SysDictService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.hutool.core.bean.BeanUtil;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * 字典表 服务实现类
 *
 * @author 黄润志
 * @since 2020-03-09 12:36
 */
@Service
public class SysDictServiceImpl implements SysDictService{

    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    public List<SysDictEntity> getHousesType(String name){
        QueryWrapper wrapper =new QueryWrapper();
        wrapper.eq("name",name);
        QueryWrapper wrappers =null;
        List<SysDictEntity> sysDictEntityList= null;
        SysDictEntity sysDictEntity = sysDictMapper.selectOne(wrapper);
        if (null == sysDictEntity) {
            throw new ServiceException("暂无该类型!");
        }else {
            wrappers = new QueryWrapper();
            wrappers.eq("pid",sysDictEntity.getDictId());
            sysDictEntityList=sysDictMapper.selectList(wrappers);
        }
        if (null==sysDictEntityList){
            throw new ServiceException("该类型为空!");
        }else {
            return sysDictEntityList;
        }
    }
    @Override
    public SysDictEntity getSysDict(Long dictId){
        return sysDictMapper.selectById(dictId);
    }

    @Override
    public List<SysDictEntity> list(){
        return sysDictMapper.selectList(null);
    }

    @Override
    public SysDictEntity create(SysDictDTO dto) {
        if (null == dto) {
            throw new ServiceException("参数为空!");
        }
        SysDictEntity entity = new SysDictEntity();
        BeanUtil.copyProperties(dto, entity);
        sysDictMapper.insert(entity);
        return entity;
    }

    @Override
    public void delete(Long dictId) {
        if (null == dictId) {
            return;
        }
        sysDictMapper.deleteById(dictId);
    }

    @Override
    public SysDictEntity update(Long dictId, SysDictDTO dto) {
        if (null == dictId) {
            return null;
        }
        SysDictEntity existEntity = sysDictMapper.selectById(dictId);
        if (null == existEntity) {
            return null;
        }
        BeanUtil.copyProperties(dto, existEntity);
        sysDictMapper.updateById(existEntity);
        return existEntity;
    }

    @Override
    public List<SysDictEntity> page(SysDictDTO dto, IPage<SysDictEntity> page) {
        return sysDictMapper.page(dto, page);
    }

}
