package com.lnsf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.OrderListDTO;
import com.lnsf.entity.OrderListEntity;

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

//    OrderListEntity getOrderList(Integer orderId);
//
//    List<OrderListEntity> list();
//

//
//    void delete(Integer orderId);
//
//    OrderListEntity update(Integer orderId, OrderListDTO dto);
//
//    List<OrderListEntity> page(OrderListDTO dto, IPage<OrderListEntity> page);
}
