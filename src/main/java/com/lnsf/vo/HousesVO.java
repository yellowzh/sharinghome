package com.lnsf.vo;

import com.lnsf.entity.UserInfoEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class HousesVO {
    @ApiModelProperty(value = "入住房客")
    private Integer peopleNum;
    @ApiModelProperty(value = "房源类型")
    private Long typeId;
    @ApiModelProperty(value = "出租最低价格")
    private Integer housesPricesMin;
    @ApiModelProperty(value = "出租最高价格")
    private Integer housesPricesMax;
    @ApiModelProperty(value = "房源地址")
    private String housesAddress;
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
}
