package com.lnsf.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author 黄润志
 * @since 2020-03-06 14:12
 */
@Data
@ApiModel
public class SysLogDTO{

    @ApiModelProperty(value = "用户ID")
    private String userId;
    @ApiModelProperty(value = "操作人名称")
    private String userName;
    @ApiModelProperty(value = "操作时间(yyyy-MM-dd HH:mm:ss)")
    private Date startTime;
    @ApiModelProperty(value = "消耗时间")
    private String spendTime;
    @ApiModelProperty(value = "登录IP")
    private String clientIp;
    @ApiModelProperty(value = "请求地址")
    private String reqUrl;
    @ApiModelProperty(value = "请求方法名称")
    private String method;
    @ApiModelProperty(value = "请求参数")
    private String params;
    @ApiModelProperty(value = "操作事件")
    private String description;
    @ApiModelProperty(value = "状态(成功：1，失败：2)")
    private Integer status;
}