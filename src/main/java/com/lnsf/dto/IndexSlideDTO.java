package com.lnsf.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 黄润志
 * @since 2020-03-07 09:32
 */
@Data
@ApiModel
public class IndexSlideDTO{

    private Integer slideId;
    @ApiModelProperty(value = "")
    private String slideUrl;
    @ApiModelProperty(value = "")
    private Integer houseId;
    /*房源标题*/
    private String housesTilte;
    @ApiModelProperty(value = "")
    private String houseTilte;
    @ApiModelProperty(value = "")
    private String houseDista;
    @ApiModelProperty(value = "")
    private Integer slideOrder;
    @ApiModelProperty(value = "")
    private Boolean isDel;
}