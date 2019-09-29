package com.lnsf.dao;


import java.util.List;

import com.lnsf.bean.Collectionhome;
import com.lnsf.bean.CollectionhomeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CollectionhomeMapper {
    int countByExample(CollectionhomeExample example);

    int deleteByExample(CollectionhomeExample example);

    int deleteByPrimaryKey(Integer collectionid);

    int insert(Collectionhome record);

    int insertSelective(Collectionhome record);

    List<Collectionhome> selectByExample(CollectionhomeExample example);

    Collectionhome selectByPrimaryKey(Integer collectionid);

    int updateByExampleSelective(@Param("record") Collectionhome record, @Param("example") CollectionhomeExample example);

    int updateByExample(@Param("record") Collectionhome record, @Param("example") CollectionhomeExample example);

    int updateByPrimaryKeySelective(Collectionhome record);

    int updateByPrimaryKey(Collectionhome record);
}