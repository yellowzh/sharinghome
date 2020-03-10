package com.lnsf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.SysDictDTO;
import com.lnsf.entity.SysDictEntity;

import java.util.List;


/**
 * 字典表 服务类
 *
 * @author 黄润志
 * @since 2020-03-09 12:36
 */
public interface SysDictService {
    /*房源类型查询*/
    List<SysDictEntity> getHousesType(String name);

    SysDictEntity getSysDict(Long dictId);

    List<SysDictEntity> list();

    SysDictEntity create(SysDictDTO dto);

    void delete(Long dictId);

    SysDictEntity update(Long dictId, SysDictDTO dto);

    List<SysDictEntity> page(SysDictDTO dto, IPage<SysDictEntity> page);
}
