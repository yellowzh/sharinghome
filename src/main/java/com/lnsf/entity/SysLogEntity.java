package com.lnsf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 日志表
 * </p>
 *
 * @author 黄润志
 * @since 2020-03-06 14:12
 */
@Data
@Accessors(chain = true)
@TableName("sys_log")
@ApiModel(value="SysLogEntity对象", description="日志表")
public class SysLogEntity{


    @TableId("LOG_ID")
    private String logId;

    @ApiModelProperty(value = "用户ID")
    @TableField("USER_ID")
    private String userId;

    @ApiModelProperty(value = "操作人名称")
    @TableField("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "操作时间(yyyy-MM-dd HH:mm:ss)")
    @TableField("START_TIME")
    private Date startTime;

    @ApiModelProperty(value = "消耗时间")
    @TableField("SPEND_TIME")
    private String spendTime;

    @ApiModelProperty(value = "登录IP")
    @TableField("CLIENT_IP")
    private String clientIp;

    @ApiModelProperty(value = "请求地址")
    @TableField("REQ_URL")
    private String reqUrl;

    @ApiModelProperty(value = "请求方法名称")
    @TableField("METHOD")
    private String method;

    @ApiModelProperty(value = "请求参数")
    @TableField("PARAMS")
    private String params;

    @ApiModelProperty(value = "操作事件")
    @TableField("DESCRIPTION")
    private String description;

    @ApiModelProperty(value = "状态(成功：1，失败：2)")
    @TableField("STATUS")
    private Integer status;


}
