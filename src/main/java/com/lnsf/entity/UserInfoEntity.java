package com.lnsf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 黄润志
 * @since 2020-03-05 13:13
 */
@Data
@Accessors(chain = true)
@TableName("user_info")
public class UserInfoEntity implements Serializable {

    @ApiModelProperty(value = "用户编号")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "用户昵称")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "真实姓名")
    @TableField("real_name")
    private String realName;

    @ApiModelProperty(value = "用户电话")
    @TableField("user_tel")
    private String userTel;

    @ApiModelProperty(value = "用户邮箱")
    @TableField("user_emil")
    private String userEmil;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "权限：0普通用户、1管理员、2商家")
    @TableField("user_power")
    private String userPower;

    @ApiModelProperty(value = "状态：1锁定、2冻结、0正常")
    @TableField("user_status")
    private String userStatus;

    @ApiModelProperty(value = "登录时间")
    @TableField("user_logintime")
    private Date userLogintime;

    @ApiModelProperty(value = "登出时间")
    @TableField("user_loginouttime")
    private Date userLoginouttime;

    @ApiModelProperty(value = "密码错误次数")
    @TableField("user_num")
    private Integer userNum;

    @ApiModelProperty(value = "扩展字段1--地址")
    @TableField("user_backup1")
    private String userBackup1;

    @ApiModelProperty(value = "扩展字段2--头像")
    @TableField("user_backup2")
    private String userBackup2;

    @ApiModelProperty(value = "积分")
    @TableField("points")
    private Integer points;


}
