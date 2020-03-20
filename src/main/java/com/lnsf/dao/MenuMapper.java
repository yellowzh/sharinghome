package com.lnsf.dao;

import com.lnsf.entity.MenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.lnsf.dto.MenuDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 *  Mapper 接口
 *
 * @author 黄润志
 * @since 2020-03-15 22:11
 */
@Repository
public interface MenuMapper extends BaseMapper<MenuEntity> {

    List<MenuEntity> page(@Param("dto")MenuDTO dto, IPage<MenuEntity> page);

}
