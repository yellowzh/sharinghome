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
 * 
 * </p>
 *
 * @author 黄润志
 * @since 2020-03-15 22:11
 */
@Data
@Accessors(chain = true)
@TableName("menu")
@ApiModel(value="MenuEntity对象", description="")
public class MenuEntity{


    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;

    @ApiModelProperty(value = "菜单名称")
    @TableField("menu_procince")
    private String menuProcince;

    @ApiModelProperty(value = "url地址")
    @TableField("menu_request")
    private String menuRequest;

    @ApiModelProperty(value = "菜单父编号")
    @TableField("menu_pcode")
    private Integer menuPcode;

    @ApiModelProperty(value = "权限")
    @TableField("user_power")
    private String userPower;

    @ApiModelProperty(value = "标志位")
    @TableField("is_del")
    private Boolean isDel;


}
