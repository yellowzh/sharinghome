package com.lnsf.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.CommentDTO;
import com.lnsf.dto.HousesDTO;
import com.lnsf.dto.OrderListDTO;
import com.lnsf.entity.OrderListEntity;
import com.lnsf.entity.UserInfoEntity;
import com.lnsf.vo.CommentListVO;
import com.lnsf.vo.OrderListPageVO;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.CommentEntity;
import com.lnsf.service.CommentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 *  前端控制器
 *
 * @author 黄润志
 * @since 2020-03-10 19:32
 */

@Api(tags = "")
@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    private static Logger log = Logger.getLogger(LoginController.class);

    @ApiOperation("列表")
    @GetMapping(path = "/select/commentList")
    public CommentListVO commentList(Integer housesId){
        log.info("房源编号："+housesId);
        return commentService.list(housesId);
    }

    @ApiOperation("新增")
    @PostMapping(path = "/addComment")
    public CommentEntity addComment(@RequestBody CommentDTO dto){
        return commentService.create(dto);
    }

    /*后台管理*/

    @ApiOperation(value = "评论管理以及查看房源评论", notes = "评论查询",httpMethod = "GET")
    @RequestMapping("/selectHousesComment")
    public ModelAndView selectHousesComment(Integer housesId, Map<String, Object> map){
        if (housesId==null){
            housesId=-1;
        }
        map.put("housesId",housesId);
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/housesComment");
        return model_html;
    }
//    @ApiOperation(value = "订单管理以及查看我的订单", notes = "我的订单查询",httpMethod = "GET")
//    @RequestMapping("/getHousesCommentPage")
//    public OrderListPageVO getHousesCommentPage(Integer housesId, Integer page){
//        if (page==null)
//        { page=1;}
//        IPage<OrderListEntity> infoEntityIPage = orderListService.getHouserOrderPage(housesId,page);
//        if(infoEntityIPage.getCurrent()>infoEntityIPage.getPages()){
//            page=Integer.parseInt(String.valueOf(infoEntityIPage.getPages()));
//            infoEntityIPage = orderListService.getHouserOrderPage(housesId,page);
//        }
//        List<OrderListDTO> orderListDTOList = new ArrayList<>();
//        for (OrderListEntity o:infoEntityIPage.getRecords()) {
//            OrderListDTO orderListDTO = new OrderListDTO();
//            BeanUtil.copyProperties(o, orderListDTO);
//            orderListDTO.setOrderId(o.getOrderId() + "");
//            /*查询对应用户*/
//            UserInfoEntity userInfoEntity = userInfoService.getUserById(o.getPassengerId());
//            orderListDTO.setUserInfo(userInfoEntity);
//            /*添加房源信息*/
//            HousesDTO housesDTO = housesService.getHomeShowById(o.getHousesId());
//            orderListDTO.setHousesDTO(housesDTO);
//            orderListDTOList.add(orderListDTO);
//        }
//        OrderListPageVO orderListPageVO = new OrderListPageVO();
//        orderListPageVO.setOrderListDTOS(orderListDTOList);
//        orderListPageVO.setIndexPage(infoEntityIPage.getCurrent());
//        orderListPageVO.setTotalPage(infoEntityIPage.getPages());
//        return orderListPageVO;
//    }
    //
//    @ApiOperation("删除")
//    @DeleteMapping("{commentId}")
//    public void delete(@ApiParam("评价编号") @PathVariable(name = "commentId") Long commentId) {
//        commentService.delete(commentId);
//    }
//
//    @ApiOperation("更新")
//    @PutMapping("{commentId}")
//    public CommentEntity update(@ApiParam("评价编号") @PathVariable("commentId") Long commentId,
//                            @RequestBody @Valid CommentDTO dto) {
//        return commentService.update(commentId, dto);
//    }
}
