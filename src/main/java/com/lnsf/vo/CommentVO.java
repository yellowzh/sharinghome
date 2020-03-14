package com.lnsf.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CommentVO {

    @ApiModelProperty(value = "用户头像")
    private String userPhoto;

    @ApiModelProperty(value = "用户名称")
    private String username;

    @ApiModelProperty(value = "评价内容")
    private String commentContent;

    @ApiModelProperty(value = "是否有照片")
    private Boolean isPhoto;

    @ApiModelProperty(value = "评价照片")
    private String commentPhoto;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "评价等级5分制")
    private Integer commentPower;

//    @ApiModelProperty(value = "是否有回复")
//    private Boolean isReply;

}
