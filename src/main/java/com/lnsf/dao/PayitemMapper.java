package com.lnsf.dao;


import java.util.List;

import com.lnsf.bean.Payitem;
import com.lnsf.bean.PayitemExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PayitemMapper {
    int countByExample(PayitemExample example);

    int deleteByExample(PayitemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Payitem record);

    int insertSelective(Payitem record);

    List<Payitem> selectByExample(PayitemExample example);

    Payitem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Payitem record, @Param("example") PayitemExample example);

    int updateByExample(@Param("record") Payitem record, @Param("example") PayitemExample example);

    int updateByPrimaryKeySelective(Payitem record);

    int updateByPrimaryKey(Payitem record);
}