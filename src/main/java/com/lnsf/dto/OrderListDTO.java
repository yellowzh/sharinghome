package com.lnsf.dto;

import com.lnsf.entity.HousesEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author 黄润志
 * @since 2020-03-13 01:20
 */
@Data
@ApiModel
public class OrderListDTO{
    @ApiModelProperty(value = "订单编号")
    private Long orderId;
    @ApiModelProperty(value = "旅客编号")
    private Integer passengerId;
    @ApiModelProperty(value = "商家编号")
    private Integer businessId;
    @ApiModelProperty(value = "房源编号")
    private Integer housesId;
    @ApiModelProperty(value = "入住人数")
    private Integer pepoleNum;
    @ApiModelProperty(value = "房间数量")
    private Integer housesNum;
    @ApiModelProperty(value = "")
    private Double onlyPrices;
    @ApiModelProperty(value = "订单价格")
    private Double orderPrices;
    @ApiModelProperty(value = "入住状态:已经退租")
    private String housesIn;
    @ApiModelProperty(value = "支付状态")
    private String orderPay;
    @ApiModelProperty(value = "")
    private Date startTime;
    @ApiModelProperty(value = "")
    private Date endTime;
    @ApiModelProperty(value = "标注位")
    private Boolean isDel;
    @ApiModelProperty(value = "房源信息")
    private HousesDTO housesDTO;
}