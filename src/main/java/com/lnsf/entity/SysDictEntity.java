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

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author 黄润志
 * @since 2020-03-09 12:36
 */
@Data
@Accessors(chain = true)
@TableName("sys_dict")
@ApiModel(value="SysDictEntity对象", description="字典表")
public class SysDictEntity{

    @ApiModelProperty(value = "主键id")
    @TableId(value = "dict_id", type = IdType.AUTO)
    private Long dictId;

    @ApiModelProperty(value = "父级字典id")
    @TableField("pid")
    private Integer pid;

    @ApiModelProperty(value = "字典名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "字典的编码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "字典描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "是否删除")
    @TableField("is_del")
    private Boolean isDel;


}
