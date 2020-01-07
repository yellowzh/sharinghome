package com.lnsf.dao;

import com.lnsf.bean.Houses;
import com.lnsf.bean.HousesExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface HousesMapper {
    int countByExample(HousesExample example);

    int deleteByExample(HousesExample example);

    int deleteByPrimaryKey(Integer housesId);

    int insert(Houses record);

    int insertSelective(Houses record);

    List<Houses> selectByExample(HousesExample example);

    Houses selectByPrimaryKey(Integer housesId);

    int updateByExampleSelective(@Param("record") Houses record, @Param("example") HousesExample example);

    int updateByExample(@Param("record") Houses record, @Param("example") HousesExample example);

    int updateByPrimaryKeySelective(Houses record);

    int updateByPrimaryKey(Houses record);
}