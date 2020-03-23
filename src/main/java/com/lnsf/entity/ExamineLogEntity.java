package com.lnsf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 黄润志
 * @since 2020-03-23 11:55
 */
@Data
@Accessors(chain = true)
@TableName("examine_log")
@ApiModel(value="ExamineLogEntity对象", description="")
public class ExamineLogEntity{


    @TableId("examine_id")
    private Long examineId;

    @TableField("houses_user")
    private String housesUser;

    @TableField("examine_status")
    private String examineStatus;

    @TableField("examine_reson")
    private String examineReson;


}
