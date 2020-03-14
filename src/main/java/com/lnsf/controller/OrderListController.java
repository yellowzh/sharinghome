package com.lnsf.controller;

import cn.hutool.db.PageResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.entity.UserInfoEntity;
import com.lnsf.vo.MyOrderVO;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.OrderListEntity;
import com.lnsf.service.OrderListService;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lnsf.dto.OrderListDTO;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    private static Logger log = Logger.getLogger(LoginController.class);


//    @ApiOperation("查看")
//    @GetMapping("{orderId}")
//    public OrderListEntity view(@ApiParam("") @PathVariable(name = "orderId") Integer orderId){
//        return orderListService.getOrderList(orderId);
//    }

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

//    @ApiOperation("分页查询")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "passengerId", value = "旅客编号"),
//            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "businessId", value = "商家编号"),
//            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "housesId", value = "房源编号"),
//            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pepoleNum", value = "入住人数"),
//            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "housesNum", value = "房间数量"),
//            @ApiImplicitParam(paramType = "query", dataType = "Double", name = "onlyPrices", value = ""),
//            @ApiImplicitParam(paramType = "query", dataType = "Double", name = "orderPrices", value = "订单价格"),
//            @ApiImplicitParam(paramType = "query", dataType = "String", name = "housesIn", value = "入住状态:已经退租"),
//            @ApiImplicitParam(paramType = "query", dataType = "String", name = "orderPay", value = "支付状态"),
//            @ApiImplicitParam(paramType = "query", dataType = "Date", name = "startTime", value = ""),
//            @ApiImplicitParam(paramType = "query", dataType = "Date", name = "endTime", value = ""),
//            @ApiImplicitParam(paramType = "query", dataType = "Boolean", name = "isDel", value = "标注位"),
//            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "page", value = "分页页码"),
//            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "size", value = "每页数量"),
//            @ApiImplicitParam(paramType = "query", dataType = "String", name = "ascs", value = "升序字段，多个用逗号隔开"),
//            @ApiImplicitParam(paramType = "query", dataType = "String", name = "descs", value = "降序字段，多个用逗号隔开")
//    })
//    @GetMapping(path = "/page")
//    public PageResult page(OrderListDTO dto) {
////        IPage<OrderListEntity> page = PageFactory.convertPageByParameters();
//        List<OrderListEntity> list = orderListService.page(dto, page);
//        return PageFactory.buildPageResult(page, list);
//    }

}
