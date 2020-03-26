package com.lnsf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.bgy.cs.common.db.BaseEntity;
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
 * @since 2020-03-24 20:41
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("examine_log")
@ApiModel(value="ExamineLogEntity对象", description="")
public class ExamineLogEntity extends BaseEntity {


    @TableId("examine_id")
    private Long examineId;

    @TableField("houses_user")
    private String housesUser;

    @TableField("examine_status")
    private String examineStatus;

    @TableField("examine_reson")
    private String examineReson;


}
