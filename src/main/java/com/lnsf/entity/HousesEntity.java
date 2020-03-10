package com.lnsf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 黄润志
 * @since 2020-03-05 15:32
 */
@Data
@Accessors(chain = true)
@TableName("houses")
public class HousesEntity{

    @ApiModelProperty(value = "房源编号")
    @TableId(value = "houses_id", type = IdType.AUTO)
    private Integer housesId;

    @ApiModelProperty(value = "商家编号")
    @TableField("business_id")
    private Integer businessId;

    @ApiModelProperty(value = "房源照片,主照片")
    @TableField("houses_photo")
    private String housesPhoto;

    @ApiModelProperty(value = "房屋标题")
    @TableField("houses_title")
    private String housesTitle;

    @ApiModelProperty(value = "房屋描述")
    @TableField("houses_describe")
    private String housesDescribe;

    @ApiModelProperty(value = "剩余房间数量")
    @TableField("houses_count")
    private Integer housesCount;

    @ApiModelProperty(value = "收藏量")
    @TableField("houses_focus")
    private Integer housesFocus;

    @ApiModelProperty(value = "预览量")
    @TableField("houses_view")
    private Integer housesView;

    @ApiModelProperty(value = "出租价格")
    @TableField("houses_prices")
    private Integer housesPrices;

    @ApiModelProperty(value = "房源地址")
    @TableField("houses_address")
    private String housesAddress;

    @ApiModelProperty(value = "房源评分")
    @TableField("houses_farction")
    private Double housesFarction;

    @ApiModelProperty(value = "标志位--0为在线·出租，1为下架修整，2为删除")
    @TableField("houses_falgs")
    private String housesFalgs;



}
