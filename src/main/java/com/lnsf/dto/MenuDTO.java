package com.lnsf.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 黄润志
 * @since 2020-03-15 22:11
 */
@Data
@ApiModel
public class MenuDTO{

    @ApiModelProperty(value = "菜单名称")
    private String menuProcince;
    @ApiModelProperty(value = "url地址")
    private String menuRequest;
    @ApiModelProperty(value = "菜单父编号")
    private Integer menuPcode;
    @ApiModelProperty(value = "权限")
    private String userPower;
    @ApiModelProperty(value = "标志位")
    private Boolean isDel;
}