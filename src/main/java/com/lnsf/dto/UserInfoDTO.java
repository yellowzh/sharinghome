package com.lnsf.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author 黄润志
 * @since 2020-03-05 13:13
 */
@Data
@ApiModel
public class UserInfoDTO {
    @ApiModelProperty(value = "用户昵称")
    private String username;
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    @ApiModelProperty(value = "用户电话")
    private String userTel;
    @ApiModelProperty(value = "用户邮箱")
    private String userEmil;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "权限：0普通用户、1管理员、2商家")
    private String userPower;
    @ApiModelProperty(value = "状态：1锁定、2冻结、0正常")
    private String userStatus;
    @ApiModelProperty(value = "登录时间")
    private Date userLogintime;
    @ApiModelProperty(value = "登出时间")
    private Date userLoginouttime;
    @ApiModelProperty(value = "密码错误次数")
    private Integer userNum;
    @ApiModelProperty(value = "扩展字段1--地址")
    private String userBackup1;
    @ApiModelProperty(value = "扩展字段2--头像")
    private String userBackup2;
}