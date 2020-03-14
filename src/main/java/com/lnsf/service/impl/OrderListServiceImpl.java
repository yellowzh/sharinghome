package com.lnsf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lnsf.dto.HousesDTO;
import com.lnsf.entity.HousesEntity;
import com.lnsf.entity.OrderListEntity;
import com.lnsf.dto.OrderListDTO;
import com.lnsf.dao.OrderListMapper;
import com.lnsf.service.HousesDetailsService;
import com.lnsf.service.HousesService;
import com.lnsf.service.OrderListService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.hutool.core.bean.BeanUtil;
import com.lnsf.vo.MyOrderVO;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 *  服务实现类
 *
 * @author 黄润志
 * @since 2020-03-13 01:20
 */
@Service
public class OrderListServiceImpl implements OrderListService {

    @Autowired
    private OrderListMapper orderListMapper;
    @Autowired
    private HousesService housesService;

    /*创建订单*/
    @Override
    public OrderListEntity create(OrderListDTO dto) {
        System.out.println(dto.getHousesId());
        HousesDTO housesDTO = housesService.getIndexHomeShowById(dto.getHousesId());
        dto.setBusinessId(housesDTO.getBusinessId());
        dto.setOnlyPrices(housesDTO.getHousesPrices());
        if (null == dto) {
            throw new ServiceException("参数为空!");
        }
        OrderListEntity entity = new OrderListEntity();
        BeanUtil.copyProperties(dto, entity);
        orderListMapper.insert(entity);

        return entity;
    }

    /*查询订单*/
    @Override
   public OrderListEntity getOrderOne(OrderListEntity orderListEntity){
       if (null == orderListEntity) {
           throw new ServiceException("参数为空!");
       }
       QueryWrapper<OrderListEntity> wrapper = new QueryWrapper<>(orderListEntity);
       return orderListMapper.selectOne(wrapper);
   }
   /*更新订单*/
   @Override
   public OrderListEntity update(OrderListEntity orderListEntity) {
        if (null == orderListEntity) {
            return null;
        }
       orderListEntity.setOrderPay("已支付");
        orderListMapper.updateById(orderListEntity);
        return orderListEntity;
    }
    /*根据用户id查询我的订单*/
    @Override
    public MyOrderVO getMyOrderByUserId(Integer userId){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("passenger_id",userId);
        wrapper.eq("is_del",false);
        MyOrderVO myOrderVO = new MyOrderVO();
        /*列表*/
        List<OrderListDTO> orderAll=new ArrayList<>();
        List<OrderListDTO> orderNotPay=new ArrayList<>();
        List<OrderListDTO> orderNotIn=new ArrayList<>();
        List<OrderListDTO> orderComment=new ArrayList<>();
        /*计数*/
        int orderNotPayNum=0;
        int orderNotInNum=0;
        int orderCommentNum=0;
        List<OrderListEntity> orderListEntities=orderListMapper.selectList(wrapper);
        for (OrderListEntity o:orderListEntities) {
            OrderListDTO orderListDTO = new OrderListDTO();
            BeanUtil.copyProperties(o, orderListDTO);
           HousesDTO housesDTO = housesService.getHomeShowById(o.getHousesId());
           orderListDTO.setHousesDTO(housesDTO);
           if ("未支付".equals(o.getOrderPay())){
               orderNotPay.add(orderListDTO);
               orderAll.add(orderListDTO);
               orderNotPayNum++;
           }else if ("未入住".equals(o.getHousesIn())){
               orderNotIn.add(orderListDTO);
               orderAll.add(orderListDTO);
               orderNotInNum++;
           }else {
               orderComment.add(orderListDTO);
               orderAll.add(orderListDTO);
               orderCommentNum++;
           }
        }
        myOrderVO.setOrderAll(orderAll);
        myOrderVO.setOrderNotPay(orderNotPay);
        myOrderVO.setOrderNotIn(orderNotIn);
        myOrderVO.setOrderComment(orderComment);
        myOrderVO.setOrderNotPayNum(orderNotPayNum);
        myOrderVO.setOrderNotInNum(orderNotInNum);
        myOrderVO.setOrderCommentNum(orderCommentNum);
        myOrderVO.setOrderAllNum(orderNotPayNum+orderNotInNum+orderCommentNum);
        return myOrderVO;
    }
    @Override
    public OrderListEntity deleteOrder(Integer orderId) {
        if (null == orderId) {
            return null;
        }
        OrderListEntity existEntity = orderListMapper.selectById(orderId);
        if (null == existEntity) {
            return null;
        }
        existEntity.setIsDel(true);
        orderListMapper.updateById(existEntity);
        return existEntity;
    }
//    @Override
//    public OrderListEntity getOrderList(Integer orderId){
//        return orderListMapper.selectById(orderId);
//    }
//
//    @Override

//    @Override
//    public void delete(Integer orderId) {
//        if (null == orderId) {
//            return;
//        }
//        orderListMapper.deleteById(orderId);
//    }
//
//    @Override
//    public OrderListEntity update(Integer orderId, OrderListDTO dto) {
//        if (null == orderId) {
//            return null;
//        }
//        OrderListEntity existEntity = orderListMapper.selectById(orderId);
//        if (null == existEntity) {
//            return null;
//        }
//        BeanUtil.copyProperties(dto, existEntity);
//        orderListMapper.updateById(existEntity);
//        return existEntity;
//    }
//
//    @Override
//    public List<OrderListEntity> page(OrderListDTO dto, IPage<OrderListEntity> page) {
//        return orderListMapper.page(dto, page);
//    }

}
