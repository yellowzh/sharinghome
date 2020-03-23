package com.lnsf.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 黄润志
 * @since 2020-03-10 15:10
 */
@Data
@ApiModel
public class HousesDetailsDTO{
    @TableId(value = "houses_id")
    private Integer housesId;
    @ApiModelProperty(value = "类型编号")
    private Long dictId;
    @ApiModelProperty(value = "房间规格类：三室一厅")
    private String housesSpecs;
    @ApiModelProperty(value = "可入住人数")
    private Integer inNum;
//    @ApiModelProperty(value = "公共卫生间数量")
//    private Integer pwc;
    @ApiModelProperty(value = "独立卫生间数量")
    private Integer iwc;
    @ApiModelProperty(value = "是否收取押金")
    private Boolean isDeposit;
    @ApiModelProperty(value = "押金")
    private Double deposit;
    @ApiModelProperty(value = "清洁费")
    private Double cleanPrices;
    @ApiModelProperty(value = "是否有毛巾")
    private Boolean isTowel;
    @ApiModelProperty(value = "是否有拖鞋")
    private Boolean isSlipper;
    @ApiModelProperty(value = "是否有空调")
    private Boolean isAir;
    @ApiModelProperty(value = "是否有wifi")
    private Boolean isWifi;
    @ApiModelProperty(value = "是否有洗衣机")
    private Boolean isWash;
    @ApiModelProperty(value = "是否有衣挂")
    private Boolean isClothesHanger;
    @ApiModelProperty(value = "是否24小时热水")
    private Boolean isHotWater;
}