package com.lnsf.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author 黄润志
 * @since 2020-03-10 10:26
 */
@Data
@ApiModel
public class ArticleDTO{

    @ApiModelProperty(value = "资讯编号")
    private String articleId;
    @ApiModelProperty(value = "资讯内容")
    private String articleInfo;
    @ApiModelProperty(value = "标题")
    private String articeTitle;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    @ApiModelProperty(value = "创建用户")
    private String createUser;
    @ApiModelProperty(value = "图片地址")
    private String articeUrl;
    @ApiModelProperty(value = "是否删除")
    private Boolean isDel;
    @ApiModelProperty(value = "是否发布")
    private Boolean isPublis;
    @ApiModelProperty(value = "点击预览量")
    private Integer seeNum;
}