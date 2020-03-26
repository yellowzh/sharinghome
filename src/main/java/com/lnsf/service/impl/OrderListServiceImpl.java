package com.lnsf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lnsf.dto.HousesDTO;
import com.lnsf.entity.HousesEntity;
import com.lnsf.entity.OrderListEntity;
import com.lnsf.dto.OrderListDTO;
import com.lnsf.dao.OrderListMapper;
import com.lnsf.entity.UserInfoEntity;
import com.lnsf.service.HousesDetailsService;
import com.lnsf.service.HousesService;
import com.lnsf.service.OrderListService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.hutool.core.bean.BeanUtil;
import com.lnsf.service.UserInfoService;
import com.lnsf.vo.MyOrderVO;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private UserInfoService userInfoService;

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
    @Override
    public OrderListEntity updateById(OrderListEntity orderListEntity) {
        if (null == orderListEntity) {
            return null;
        }
        orderListMapper.updateById(orderListEntity);
        return orderListEntity;
    }
    /*根据用户id查询我的订单*/
    @Override
    public MyOrderVO getMyOrderByUserId(Integer userId){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("passenger_id",userId);
        wrapper.eq("is_del",false);
        wrapper.orderByDesc("create_time");
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
        int orderAllNum=0;
        List<OrderListEntity> orderListEntities=orderListMapper.selectList(wrapper);
        for (OrderListEntity o:orderListEntities) {
            OrderListDTO orderListDTO = new OrderListDTO();
            BeanUtil.copyProperties(o, orderListDTO);
            orderListDTO.setOrderId(o.getOrderId()+"");
           HousesDTO housesDTO = housesService.getHomeShowById(o.getHousesId());
           orderListDTO.setHousesDTO(housesDTO);
            if ("未支付".equals(o.getOrderPay())){
                orderNotPay.add(orderListDTO);
                orderAll.add(orderListDTO);
                orderNotPayNum++;
                orderAllNum++;
            }else if ("已退宿".equals(o.getHousesIn())){
                if (o.getIsComment()==false){
                    orderComment.add(orderListDTO);
                    orderAll.add(orderListDTO);
                    orderCommentNum++;
                    orderAllNum++;
                }else {
                    orderAll.add(orderListDTO);
                    orderAllNum++;
                }
            }else {
                if ("已退款".equals(o.getOrderPay())){
                    orderAll.add(orderListDTO);
                    orderAllNum++;
                }else {
                    orderNotIn.add(orderListDTO);
                    orderAll.add(orderListDTO);
                    orderNotInNum++;
                    orderAllNum++;
                }
            }
        }
        myOrderVO.setOrderAll(orderAll);
        myOrderVO.setOrderNotPay(orderNotPay);
        myOrderVO.setOrderNotIn(orderNotIn);
        myOrderVO.setOrderComment(orderComment);
        myOrderVO.setOrderNotPayNum(orderNotPayNum);
        myOrderVO.setOrderNotInNum(orderNotInNum);
        myOrderVO.setOrderCommentNum(orderCommentNum);
        myOrderVO.setOrderAllNum(orderAllNum);
        return myOrderVO;
    }
   public MyOrderVO getSinAllOrderById(Integer userId,Integer housesId){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("business_id",userId);
        wrapper.eq("is_del",false);
        if (housesId!=null){
            wrapper.eq("houses_id",housesId);
        }
        wrapper.orderByDesc("create_time");
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
        int orderAllNum=0;
        List<OrderListEntity> orderListEntities=orderListMapper.selectList(wrapper);
        for (OrderListEntity o:orderListEntities) {
            OrderListDTO orderListDTO = new OrderListDTO();
            BeanUtil.copyProperties(o, orderListDTO);
            orderListDTO.setOrderId(o.getOrderId()+"");
            HousesDTO housesDTO = housesService.getHomeShowById(o.getHousesId());
            orderListDTO.setHousesDTO(housesDTO);
            if ("未支付".equals(o.getOrderPay())){
                orderNotPay.add(orderListDTO);
                orderAll.add(orderListDTO);
                orderNotPayNum++;
                orderAllNum++;
            }else if ("已退宿".equals(o.getHousesIn())){
                if (o.getIsComment()==false){
                    orderComment.add(orderListDTO);
                    orderAll.add(orderListDTO);
                    orderCommentNum++;
                    orderAllNum++;
                }else {
                    orderAll.add(orderListDTO);
                    orderAllNum++;
                }
            }else {
                if ("已退款".equals(o.getOrderPay())){
                    orderAll.add(orderListDTO);
                    orderAllNum++;
                }else {
                    orderNotIn.add(orderListDTO);
                    orderAll.add(orderListDTO);
                    orderNotInNum++;
                    orderAllNum++;
                }
            }
        }
        myOrderVO.setOrderAll(orderAll);
        myOrderVO.setOrderNotPay(orderNotPay);
        myOrderVO.setOrderNotIn(orderNotIn);
        myOrderVO.setOrderComment(orderComment);
        myOrderVO.setOrderNotPayNum(orderNotPayNum);
        myOrderVO.setOrderNotInNum(orderNotInNum);
        myOrderVO.setOrderCommentNum(orderCommentNum);
        myOrderVO.setOrderAllNum(orderAllNum);
        return myOrderVO;
    }
    @Override
    public OrderListEntity deleteOrder(Long orderId) {
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
    @Override
    public OrderListEntity getOrderList(Long orderId){
        return orderListMapper.selectById(orderId);
    }


    public IPage<OrderListEntity> getHouserOrderPage(Integer housesId,Integer page){
        IPage<OrderListEntity> ipage = new Page<>(page, 8);
        OrderListEntity orderListEntity = new OrderListEntity();
        QueryWrapper<OrderListEntity> wrapper = new QueryWrapper<>(orderListEntity);
        IPage<OrderListEntity> pages=null;
        if (housesId==-1){
            wrapper.eq("is_del",false);
            wrapper.orderByDesc("create_time");
            pages= orderListMapper.selectPage(ipage,wrapper);
        }else {

            wrapper.eq("houses_id",housesId);
            wrapper.eq("is_del",false);
            wrapper.orderByDesc("create_time");
            pages=orderListMapper.selectPage(ipage,wrapper);;
        }
        return pages;
    }
    @Override
    /*根据时间判断该时间是否已经被预定*/
    public Boolean getOrderIfIn(String starTime,String endTime,Integer housesId){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("is_del",false);
        wrapper.eq("houses_id",housesId);
        wrapper.ne("order_pay","已退款");
        wrapper.ne("houses_in","已退宿");
        wrapper.ge("start_time",starTime);
        wrapper.le("end_time",endTime);
        List<OrderListEntity> orderListEntities= orderListMapper.selectList(wrapper);
        if (orderListEntities.size()>0){
            return true;
        }else {
            System.out.println("进入");
            return false;
        }
    }
    @Override
    public Boolean getOrderIfInByOneTime(String time,Integer housesId){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("is_del",false);
        wrapper.eq("houses_id",housesId);
        wrapper.ne("order_pay","已退款");
        wrapper.ne("houses_in","已退宿");
        List<OrderListEntity> orderListEntities=new ArrayList<>();
        wrapper.le("start_time",time);
        wrapper.ge("end_time",time);
        orderListEntities = orderListMapper.selectList(wrapper);
        if (orderListEntities.size()>0){
            return true;
        }else {
            System.out.println("进入");
            return false;
        }
    }
    /*查询未支付的订单*/
    public List<OrderListEntity> scheduleGetNotPayList(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("order_pay","未支付");
        wrapper.eq("is_del",false);
        return orderListMapper.selectList(wrapper);
    }
    /*查询已退宿但未评价的订单*/
    public List<OrderListEntity> scheduleGetNotCommentList(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("houses_in","已退宿");
        wrapper.eq("is_comment",false);
        wrapper.eq("is_del",false);
        return orderListMapper.selectList(wrapper);
    }

}
