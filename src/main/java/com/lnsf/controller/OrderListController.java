package com.lnsf.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.db.PageResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.HousesDTO;
import com.lnsf.entity.UserInfoEntity;
import com.lnsf.service.HousesService;
import com.lnsf.service.UserInfoService;
import com.lnsf.vo.MyOrderVO;
import com.lnsf.vo.OrderListPageVO;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.OrderListEntity;
import com.lnsf.service.OrderListService;

import java.util.ArrayList;
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

    private static Logger log = Logger.getLogger(LoginController.class);


    @ApiOperation("查看单条订单")
    @GetMapping("/selectOrderById")
    public OrderListEntity view(Long orderId){
        return orderListService.getOrderList(orderId);
    }

//    @ApiOperation("列表")
//    @GetMapping
//    public List<OrderListEntity> list(){
//        return orderListService.list();
//    }

//    @ApiOperation("新增")
//    @PostMapping
//    public OrderListEntity create(@RequestBody @Valid OrderListDTO dto){
//        return orderListService.create(dto);
//    }

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

    @ApiOperation(value = "订单管理以及查看我的订单", notes = "我的订单查询",httpMethod = "GET")
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
//    @ApiOperation(value = "订单管理以及查看我的订单", notes = "我的订单查询",httpMethod = "GET")
//    @RequestMapping("/getHouserOrder")
//    public List<OrderListDTO> getHouserOrder(Integer housesId,Map<String, Object> map){
//        return orderListService.getHouserOrder(housesId);
//    }
    @ApiOperation(value = "订单管理以及查看我的订单", notes = "我的订单查询",httpMethod = "GET")
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


//    @ApiOperation("删除")
//    @DeleteMapping("{orderId}")
//    public void delete(@ApiParam("") @PathVariable(name = "orderId") Integer orderId) {
//        orderListService.delete(orderId);
//    }

//    @ApiOperation("更新")
//    @PutMapping("{orderId}")
//    public OrderListEntity update(@ApiParam("") @PathVariable("orderId") Integer orderId,
//                            @RequestBody @Valid OrderListDTO dto) {
//        return orderListService.update(orderId, dto);
//    }



}
