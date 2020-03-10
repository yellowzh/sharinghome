package com.lnsf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2020-03-10 10:26
 */
@Data
@Accessors(chain = true)
@TableName("article")
@ApiModel(value="ArticleEntity对象", description="")
public class ArticleEntity{


    @ApiModelProperty(value = "资讯编号")
    @TableId("article_id")
    private Long articleId;

    @ApiModelProperty(value = "资讯内容")
    @TableField("article_info")
    private String articleInfo;

    @ApiModelProperty(value = "标题")
    @TableField("artice_title")
    private String articeTitle;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty(value = "创建用户")
    @TableField("create_user")
    private String createUser;

    @ApiModelProperty(value = "图片地址")
    @TableField("artice_url")
    private String articeUrl;

    @ApiModelProperty(value = "是否删除")
    @TableField("is_del")
    private Boolean isDel;

    @ApiModelProperty(value = "是否发布")
    @TableField("is_publis")
    private Boolean isPublis;

    @ApiModelProperty(value = "点击预览量")
    @TableField("see_num")
    private Integer seeNum;


}
