package com.lnsf.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.db.PageResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.HousesDTO;
import com.lnsf.entity.UserInfoEntity;
import com.lnsf.service.*;
import com.lnsf.vo.CountListVO;
import com.lnsf.vo.MyOrderVO;
import com.lnsf.vo.OrderListPageVO;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.OrderListEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lnsf.dto.OrderListDTO;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;



/**
 *  前端控制器
 *
 * @author 黄润志
 * @since 2020-03-13 01:20
 */

@Api(tags = "")
@RestController
@RequestMapping("/api")
public class OrderListController {

    @Autowired
    private OrderListService orderListService;

    @Autowired
    private HousesService housesService;
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SysLogService sysLogService;

    @Autowired
    private ExamineLogService examineLogService;

    private static Logger log = Logger.getLogger(LoginController.class);


    @ApiOperation("查看单条订单")
    @GetMapping("/selectOrderById")
    public OrderListDTO view(Long orderId){
        OrderListEntity orderListEntity = orderListService.getOrderList(orderId);
        OrderListDTO orderListDTO = new OrderListDTO();
        BeanUtils.copyProperties(orderListEntity,orderListDTO);
        orderListDTO.setOrderId(orderListEntity.getOrderId()+"");
        return orderListDTO;
    }
    /**
     *@Description
     *@Author huangrunzhi
     *@Date 2020/3/12 0:37
     */
    @ApiOperation(value = "预定房源", notes = "预定房源",httpMethod = "POST")
    @RequestMapping("/reserveHouses")
    public OrderListEntity reserveHouses(@RequestBody @Valid OrderListDTO dto, HttpServletRequest httpServletRequest){
        UserInfoEntity userInfoEntity = (UserInfoEntity)httpServletRequest.getSession().getAttribute("user");
        log.info("预定房源:"+dto.getStartTime());
        dto.setPassengerId(userInfoEntity.getUserId());
        /*添加*/
        OrderListEntity orderListEntity = orderListService.create(dto);
        httpServletRequest.getSession().setAttribute("oneOrder",orderListEntity);
        return orderListEntity;
    }
    @ApiOperation(value = "预定房源", notes = "预定房源",httpMethod = "POST")
    @RequestMapping("/gotoPagePay")
    public ModelAndView gotoPagePay( Map<String, Object> map, HttpServletRequest httpServletRequest){
        OrderListEntity orderListEntity = (OrderListEntity) httpServletRequest.getSession().getAttribute("oneOrder");
        /*查询该订单编码*/
        log.info("orderListEntity:"+orderListEntity.getOrderId());
//        OrderListEntity orderListEntity2 = orderListService.getOrderOne(orderListEntity);
        map.put("oneOder",orderListEntity);
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("user/gotoPagePay");
        return model_html;
    }
    @ApiOperation(value = "我的订单页面跳转", notes = "我的订单页面跳转",httpMethod = "GET")
    @RequestMapping("/myorder")
    public ModelAndView myorder(){
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("user/myorder");
        return model_html;
    }

    @ApiOperation(value = "我的订单查询", notes = "我的订单查询",httpMethod = "GET")
    @RequestMapping("/myOrderByUserId")
    public MyOrderVO getMyOrderByUserId(Integer userId){
        return orderListService.getMyOrderByUserId(userId);
    }

    @ApiOperation(value = "我的订单点击去支付按钮", notes = "我的订单点击去支付按钮",httpMethod = "GET")
    @RequestMapping("/myOrderGoPay")
    public ModelAndView myOrderGoPay(Long orderId, HttpServletRequest httpServletRequest,Map<String, Object> map){
       OrderListEntity orderList = orderListService.getOrderList(orderId);
        httpServletRequest.getSession().setAttribute("oneOrder",orderList);
        map.put("oneOder",orderList);
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("user/gotoPagePay");
        return model_html;
    }

    @ApiOperation(value = "删除我的订单", notes = "我的订单点击去支付按钮",httpMethod = "GET")
    @RequestMapping("/delOrder")
    public String delOrder(Long orderId){
        OrderListEntity orderList = orderListService.getOrderList(orderId);
        if ("已支付".equals(orderList.getOrderPay())){
            if("未入住".equals(orderList.getHousesIn())){
                return "请注意查看是否需要进行取消订单！";
            }else {
                /*删除*/
                orderListService.deleteOrder(orderId);
                return "删除成功";
            }
        }else {
            /*删除*/
            orderListService.deleteOrder(orderId);
            return "删除成功";
        }

    }
    /*后台管理*/

    @ApiOperation(value = "页面跳转", notes = "订单查询",httpMethod = "GET")
    @RequestMapping("/selectHousesOrder")
    public ModelAndView selectHousesOrder(Integer housesId,Map<String, Object> map){
        if (housesId==null){
            housesId=-1;
        }
        map.put("housesId",housesId);
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/housesOrder");
        return model_html;
    }
    @ApiOperation(value = "后台管理订单分页", notes = "订单查询",httpMethod = "GET")
    @RequestMapping("/getHouserOrderPage")
    public OrderListPageVO getHouserOrderPage(Integer housesId,Integer page){
        if (page==null)
        { page=1;}
        IPage<OrderListEntity> infoEntityIPage = orderListService.getHouserOrderPage(housesId,page);
        if(infoEntityIPage.getCurrent()>infoEntityIPage.getPages()){
            page=Integer.parseInt(String.valueOf(infoEntityIPage.getPages()));
            infoEntityIPage = orderListService.getHouserOrderPage(housesId,page);
        }
        List<OrderListDTO> orderListDTOList = new ArrayList<>();
        for (OrderListEntity o:infoEntityIPage.getRecords()) {
            OrderListDTO orderListDTO = new OrderListDTO();
            BeanUtil.copyProperties(o, orderListDTO);
            orderListDTO.setOrderId(o.getOrderId() + "");
            /*查询对应用户*/
            UserInfoEntity userInfoEntity = userInfoService.getUserById(o.getPassengerId());
            orderListDTO.setUserInfo(userInfoEntity);
            /*添加房源信息*/
            HousesDTO housesDTO = housesService.getHomeShowById(o.getHousesId());
            orderListDTO.setHousesDTO(housesDTO);
            orderListDTOList.add(orderListDTO);
        }
        OrderListPageVO orderListPageVO = new OrderListPageVO();
        orderListPageVO.setOrderListDTOS(orderListDTOList);
        orderListPageVO.setIndexPage(infoEntityIPage.getCurrent());
        orderListPageVO.setTotalPage(infoEntityIPage.getPages());
        return orderListPageVO;
    }
    /*根据时间判断是否有订单*/
    @ApiOperation(value = "根据时间判断是否有订单", notes = "查询是否包含",httpMethod = "GET")
    @RequestMapping("/getOrderIfIn")
    public Boolean getOrderIfIn(String starTime,String endTime,Integer housesId){
        return orderListService.getOrderIfIn(starTime,endTime,housesId);
    }
    @ApiOperation(value = "根据时间判断是否有订单", notes = "查询是否被包含",httpMethod = "GET")
    @RequestMapping("/getOrderIfInByTime")
    public Boolean getOrderIfInByTime(String time,Integer housesId){
        return orderListService.getOrderIfInByOneTime(time,housesId);
    }
    /*商家查询自己的全部订单*/
    @ApiOperation(value = "商家查询自己的全部订单", notes = "订单查询",httpMethod = "GET")
    @RequestMapping("/getSinAllOrder")
    public MyOrderVO getSinAllOrder(Integer housesId,HttpServletRequest httpServletRequest){
        UserInfoEntity userInfoEntity = (UserInfoEntity)httpServletRequest.getSession().getAttribute("user");
        return orderListService.getSinAllOrderById(userInfoEntity.getUserId(),housesId);
    }

    @ApiOperation(value = "入宿、退宿", notes = "订单查询",httpMethod = "POST")
    @RequestMapping("/updateOrderIn")
    public OrderListEntity updateOrderIn(@RequestBody OrderListEntity orderListEntity){
        return orderListService.updateById(orderListEntity);
    }

    /*后台管理首页统计模块*/
    @ApiOperation(value = "商家查询自己的全部订单", notes = "订单查询",httpMethod = "GET")
    @RequestMapping("/getSystemCount")
    public CountListVO getSystemCount(){
        /*查询本月出租金额*/
        Integer wOrder=0;
        wOrder= orderListService.wOrder();
        double payNum=0;
        payNum= orderListService.payNum();
        /*查询今日登录系统人数*/
        Integer loginNum=0;
        loginNum= sysLogService.loginNum();
        /*查询待审核人数*/
        Integer notRental=0;
        notRental=   housesService.notRental();
        /*查询已经审核数*/
        Integer rental=0;
        rental= examineLogService.list();
        System.out.println(payNum+"-"+"-"+notRental+"-"+wOrder+"-"+rental);
        CountListVO countListVO = new CountListVO();
        countListVO.setRental(rental);
        countListVO.setLoginNum(loginNum);
        countListVO.setNotRental(notRental);
        countListVO.setPayNum(payNum);
        countListVO.setWOrder(wOrder);
        return countListVO;
    }


}
