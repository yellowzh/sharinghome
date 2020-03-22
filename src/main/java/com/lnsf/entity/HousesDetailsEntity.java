package com.lnsf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2020-03-10 15:10
 */
@Data
@Accessors(chain = true)
@TableName("houses_details")
@ApiModel(value="HousesDetailsEntity对象", description="")
public class HousesDetailsEntity{


    @TableId(value = "houses_id")
    private Integer housesId;

    @ApiModelProperty(value = "类型编号")
    @TableField("dict_id")
    private Long dictId;

    @ApiModelProperty(value = "房间规格类：三室一厅")
    @TableField("houses_specs")
    private String housesSpecs;

    @ApiModelProperty(value = "可入住人数")
    @TableField("in_num")
    private Integer inNum;

//    @ApiModelProperty(value = "公共卫生间数量")
//    @TableField("pwc")
//    private Integer pwc;

    @ApiModelProperty(value = "独立卫生间数量")
    @TableField("iwc")
    private Integer iwc;

    @ApiModelProperty(value = "是否收取押金")
    @TableField("is_deposit")
    private Boolean isDeposit;

    @ApiModelProperty(value = "押金")
    @TableField("deposit")
    private Double deposit;

    @ApiModelProperty(value = "清洁费")
    @TableField("clean_prices")
    private Double cleanPrices;

    @ApiModelProperty(value = "是否有毛巾")
    @TableField("is_towel")
    private Boolean isTowel;

    @ApiModelProperty(value = "是否有拖鞋")
    @TableField("is_slipper")
    private Boolean isSlipper;

    @ApiModelProperty(value = "是否有空调")
    @TableField("is_air")
    private Boolean isAir;

    @ApiModelProperty(value = "是否有wifi")
    @TableField("is_wifi")
    private Boolean isWifi;

    @ApiModelProperty(value = "是否有洗衣机")
    @TableField("is_wash")
    private Boolean isWash;

    @ApiModelProperty(value = "是否有衣挂")
    @TableField("is_clothes_hanger")
    private Boolean isClothesHanger;

    @ApiModelProperty(value = "是否24小时热水")
    @TableField("is_hot_water")
    private Boolean isHotWater;


}
