package com.lnsf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 黄润志
 * @since 2020-03-10 19:32
 */
@Data
@Accessors(chain = true)
@TableName("comment")
@ApiModel(value="CommentEntity对象", description="")
public class CommentEntity{


    @ApiModelProperty(value = "评价编号")
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;

    @TableField("order_id")
    private Long orderId;

    @ApiModelProperty(value = "房源编号")
    @TableField("house_id")
    private Integer houseId;

    @ApiModelProperty(value = "用户编号")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty(value = "评价类型：商家评价还是用户评价")
    @TableField("comment_type")
    private String commentType;

    @ApiModelProperty(value = "评价内容")
    @TableField("comment_content")
    private String commentContent;

    @ApiModelProperty(value = "评价照片")
    @TableField("comment_photo")
    private String commentPhoto;

    @ApiModelProperty(value = "评价等级5分制")
    @TableField("comment_power")
    private Integer commentPower;

    @ApiModelProperty(value = "回复id")
    @TableField("reply_id")
    private Integer replyId;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @TableField("is_del")
    private Boolean isDel;


}
