package com.lnsf.vo;

import cn.hutool.system.UserInfo;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lnsf.entity.UserInfoEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/*查看审核房源的详细信息*/
@Data
public class HousesDetailsVO {
    @TableId(value = "houses_id")
    private Integer housesId;
    @ApiModelProperty(value = "类型编号")
    private String dictType;
    @ApiModelProperty(value = "房间规格类：三室一厅")
    private String housesSpecs;
    @ApiModelProperty(value = "可入住人数")
    private Integer inNum;
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
