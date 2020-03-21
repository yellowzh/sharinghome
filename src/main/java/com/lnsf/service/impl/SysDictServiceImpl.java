package com.lnsf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lnsf.entity.SysDictEntity;
import com.lnsf.dto.SysDictDTO;
import com.lnsf.dao.SysDictMapper;
import com.lnsf.service.SysDictService;
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
        wrapper.eq("is_del",false);
        QueryWrapper wrappers =null;
        List<SysDictEntity> sysDictEntityList= null;
        SysDictEntity sysDictEntity = sysDictMapper.selectOne(wrapper);
        if (null == sysDictEntity) {
            throw new ServiceException("暂无该类型!");
        }else {
            wrappers = new QueryWrapper();
            wrappers.eq("pid",sysDictEntity.getDictId());
            wrappers.eq("is_del",false);
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
    public List<SysDictEntity> getAllDictList(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.isNull("pid");
        wrapper.eq("is_del",false);
        return sysDictMapper.selectList(wrapper);
    }
/*新增字典*/
    @Override
    public SysDictEntity createAllDict(SysDictDTO dto) {
        if (null == dto) {
            throw new ServiceException("参数为空!");
        }
        SysDictEntity entity = new SysDictEntity();
        BeanUtil.copyProperties(dto, entity);
        sysDictMapper.insert(entity);
        return entity;
    }
/*删除字典*/
    @Override
    public String delete(Long dictId) {
        if (null == dictId) {
            return "参数为空";
        }
        SysDictEntity sysDictEntity = new SysDictEntity();
        sysDictEntity.setDictId(dictId);
        sysDictEntity.setIsDel(true);
       int num =  sysDictMapper.updateById(sysDictEntity);
       if (num>0){
           return "删除成功";
       }else {
           return "删除失败";
       }
    }
    /*验证添加字典的唯一性*/
    public Boolean dictIsExist(String name){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",name);
        wrapper.eq("is_del",false);
        SysDictEntity sysDictEntity=sysDictMapper.selectOne(wrapper);
        if (null==sysDictEntity){
            return false;
        }else {
            return true;
        }
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
    public List<SysDictEntity> selectDictson(Long dictId){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("pid",dictId);
        wrapper.eq("is_del",false);
        return sysDictMapper.selectList(wrapper);
    }

}
