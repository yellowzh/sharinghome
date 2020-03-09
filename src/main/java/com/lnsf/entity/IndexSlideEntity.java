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
 * @since 2020-03-07 09:32
 */
@Data
@Accessors(chain = true)
@TableName("index_slide")
@ApiModel(value="IndexSlideEntity对象", description="")
public class IndexSlideEntity{


    @TableId("slide_id")
    private Long slideId;

    @TableField("slide_url")
    private String slideUrl;

    @TableField("house_id")
    private Integer houseId;

    @TableField("house_tilte")
    private String houseTilte;

    @TableField("house_dista")
    private String houseDista;

    @TableField("slide_order")
    private Integer slideOrder;

    @TableField("is_del")
    private Boolean isDel;


}
