package com.lnsf.dao;

import com.lnsf.bean.Homeshow;
import com.lnsf.bean.HomeshowExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface HomeshowMapper {
    int countByExample(HomeshowExample example);

    int deleteByExample(HomeshowExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Homeshow record);

    int insertSelective(Homeshow record);

    List<Homeshow> selectByExample(HomeshowExample example);

    Homeshow selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Homeshow record, @Param("example") HomeshowExample example);

    int updateByExample(@Param("record") Homeshow record, @Param("example") HomeshowExample example);

    int updateByPrimaryKeySelective(Homeshow record);

    int updateByPrimaryKey(Homeshow record);
}