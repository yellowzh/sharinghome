package com.lnsf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.OrderListDTO;
import com.lnsf.entity.OrderListEntity;
import com.lnsf.vo.MyOrderVO;

import java.util.List;


/**
 *  服务类
 *
 * @author 黄润志
 * @since 2020-03-13 01:20
 */
public interface OrderListService {
    /*创建订单*/
    OrderListEntity create(OrderListDTO dto);
    /*查询订单*/
    OrderListEntity getOrderOne(OrderListEntity orderListEntity);
    /*更新订单状态*/
    OrderListEntity update(OrderListEntity orderListEntity);
    /*更新订单状态*/
    OrderListEntity updateById(OrderListEntity orderListEntity);
    /*根据用户编号查询用户订单*/
    MyOrderVO getMyOrderByUserId(Integer userId);
    /*根据订单编号删除订单*/
    OrderListEntity deleteOrder(Long orderId);
    /*根据订单编号查询订单*/
    OrderListEntity getOrderList(Long orderId);
//    /*订单管理*/
//    List<OrderListDTO> getHouserOrder(Integer housesId);
    /*订单分页*/
    IPage<OrderListEntity> getHouserOrderPage(Integer housesId,Integer page);
//    void delete(Integer orderId);
//
//    OrderListEntity update(Integer orderId, OrderListDTO dto);
//
//    List<OrderListEntity> page(OrderListDTO dto, IPage<OrderListEntity> page);
}
