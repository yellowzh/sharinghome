package com.lnsf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 黄润志
 * @since 2020-03-06 19:58
 */
@Data
@Accessors(chain = true)
@TableName("photo_list")
@ApiModel(value="PhotoListEntity对象", description="")
public class PhotoListEntity{


    @TableId("photo_id")
    private String photoId;

    @TableField("photo_name")
    private String photoName;

    @ApiModelProperty(value = "路径")
    @TableField("photo_path")
    private String photoPath;

    @ApiModelProperty(value = "大小")
    @TableField("size")
    private Long size;

    @ApiModelProperty(value = "类型")
    @TableField("content_type")
    private String contentType;

    @TableField("housesId")
    private Integer housesId;


}
