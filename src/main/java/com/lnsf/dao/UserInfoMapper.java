package com.lnsf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

import com.lnsf.dto.UserInfoDTO;
import com.lnsf.entity.UserInfoEntity;
import org.mapstruct.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfoEntity> {

    List<UserInfoEntity> page(@Param("dto") UserInfoDTO dto, IPage<UserInfoEntity> page);

}