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
 * @since 2020-03-26 15:11
 */
@Data
@Accessors(chain = true)
@TableName("see_note")
@ApiModel(value="SeeNoteEntity对象", description="")
public class SeeNoteEntity{


    @TableId("see_id")
    private Long seeId;

    @TableField("houses_title")
    private String housesTitle;

    @TableField("see_num")
    private Integer seeNum;

    @TableField("houses_id")
    private Integer housesId;

    @TableField("create_time")
    private Date createTime;



}
