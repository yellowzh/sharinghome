package com.lnsf.dao;

import com.lnsf.bean.OrderList;
import com.lnsf.bean.OrderListExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OrderListMapper {
    int countByExample(OrderListExample example);

    int deleteByExample(OrderListExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderList record);

    int insertSelective(OrderList record);

    List<OrderList> selectByExample(OrderListExample example);

    OrderList selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") OrderList record, @Param("example") OrderListExample example);

    int updateByExample(@Param("record") OrderList record, @Param("example") OrderListExample example);

    int updateByPrimaryKeySelective(OrderList record);

    int updateByPrimaryKey(OrderList record);
}