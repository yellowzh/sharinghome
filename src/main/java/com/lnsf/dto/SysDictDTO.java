package com.lnsf.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 黄润志
 * @since 2020-03-09 12:36
 */
@Data
@ApiModel
public class SysDictDTO{
    @ApiModelProperty(value = "父级字典id")
    private Integer pid;
    @ApiModelProperty(value = "字典名称")
    private String name;
    @ApiModelProperty(value = "字典的编码")
    private String code;
    @ApiModelProperty(value = "字典描述")
    private String description;
    @ApiModelProperty(value = "排序")
    private Integer sort;
    @ApiModelProperty(value = "是否删除")
    private Boolean isDel;
}