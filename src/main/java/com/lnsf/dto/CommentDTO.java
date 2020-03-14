package com.lnsf.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 黄润志
 * @since 2020-03-10 19:32
 */
@Data
@ApiModel
public class CommentDTO{

    @ApiModelProperty(value = "")
    private Integer orderId;
    @ApiModelProperty(value = "房源编号")
    private Integer houseId;
    @ApiModelProperty(value = "用户编号")
    private Integer userId;
    @ApiModelProperty(value = "评价类型：商家评价还是用户评价")
    private String commentType;
    @ApiModelProperty(value = "评价内容")
    private String commentContent;
    @ApiModelProperty(value = "评价照片")
    private String commentPhoto;
    @ApiModelProperty(value = "评价等级5分制")
    private Integer commentPower;
    @ApiModelProperty(value = "回复id")
    private Integer replyId;
    @ApiModelProperty(value = "")
    private Boolean isDel;
}