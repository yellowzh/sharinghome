package com.lnsf.dto;

import com.lnsf.entity.UserInfoEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 黄润志
 * @since 2020-03-05 15:32
 */
@Data
@ApiModel
public class HousesDTO{
    @ApiModelProperty(value = "房源编号")
    private Integer housesId;
    @ApiModelProperty(value = "商家编号")
    private Integer businessId;
    @ApiModelProperty(value = "房源照片,主照片")
    private String housesPhoto;
    @ApiModelProperty(value = "房屋标题")
    private String housesTitle;
    @ApiModelProperty(value = "房屋描述")
    private String housesDescribe;
    @ApiModelProperty(value = "剩余房间数量")
    private Integer housesCount;
    @ApiModelProperty(value = "收藏量")
    private Integer housesFocus;
    @ApiModelProperty(value = "预览量")
    private Integer housesView;
    @ApiModelProperty(value = "出租价格")
    private Integer housesPrices;
    @ApiModelProperty(value = "房源地址")
    private String housesAddress;
    @ApiModelProperty(value = "房源评分")
    private Double housesFarction;
    @ApiModelProperty(value = "标志位--0为在线·出租，1为下架修整，2为删除")
    private String housesFalgs;
    @ApiModelProperty(value = "对应的房主")
    private UserInfoEntity userInfo;
}