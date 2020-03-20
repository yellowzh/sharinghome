package com.lnsf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 黄润志
 * @since 2020-03-13 01:20
 */
@Data
@Accessors(chain = true)
@TableName("order_list")
@ApiModel(value="OrderListEntity对象", description="")
public class OrderListEntity{


    @TableId(value = "order_id")
    private Long orderId;

    @ApiModelProperty(value = "旅客编号")
    @TableField("passenger_id")
    private Integer passengerId;

    @ApiModelProperty(value = "商家编号")
    @TableField("business_id")
    private Integer businessId;

    @ApiModelProperty(value = "房源编号")
    @TableField("houses_id")
    private Integer housesId;

    @ApiModelProperty(value = "入住人数")
    @TableField("pepole_num")
    private Integer pepoleNum;

    @ApiModelProperty(value = "房间数量")
    @TableField("houses_num")
    private Integer housesNum;

    @TableField("only_prices")
    private Double onlyPrices;

    @ApiModelProperty(value = "订单价格")
    @TableField("order_prices")
    private Double orderPrices;

    @ApiModelProperty(value = "入住状态:已经退租")
    @TableField("houses_in")
    private String housesIn;

    @ApiModelProperty(value = "支付状态")
    @TableField("order_pay")
    private String orderPay;

    @TableField("start_time")
    private Date startTime;

    @TableField("end_time")
    private Date endTime;

    @ApiModelProperty(value = "下单时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "标注位")
    @TableField("is_del")
    private Boolean isDel;

    @ApiModelProperty(value = "是否评价")
    @TableField("is_comment")
    private Boolean isComment;




}
