package com.lnsf.dao;


import java.util.List;

import com.lnsf.bean.Orderlist;
import com.lnsf.bean.OrderlistExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OrderlistMapper {
    int countByExample(OrderlistExample example);

    int deleteByExample(OrderlistExample example);

    int deleteByPrimaryKey(Integer oid);

    int insert(Orderlist record);

    int insertSelective(Orderlist record);

    List<Orderlist> selectByExample(OrderlistExample example);

    Orderlist selectByPrimaryKey(Integer oid);

    int updateByExampleSelective(@Param("record") Orderlist record, @Param("example") OrderlistExample example);

    int updateByExample(@Param("record") Orderlist record, @Param("example") OrderlistExample example);

    int updateByPrimaryKeySelective(Orderlist record);

    int updateByPrimaryKey(Orderlist record);
}