package com.lnsf.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 黄润志
 * @since 2020-03-06 19:58
 */
@Data
@ApiModel
public class PhotoListDTO{

    @ApiModelProperty(value = "")
    private String photoName;
    @ApiModelProperty(value = "路径")
    private String photoPath;
    @ApiModelProperty(value = "大小")
    private Long size;
    @ApiModelProperty(value = "类型")
    private String contentType;
    @ApiModelProperty(value = "扩展字段1")
    private String backerup1;
    @ApiModelProperty(value = "扩展字段2")
    private String backerup2;
    @ApiModelProperty(value = "")
    private Integer housesId;
}