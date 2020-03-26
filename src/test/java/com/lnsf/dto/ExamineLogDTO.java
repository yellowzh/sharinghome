package com.lnsf.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 黄润志
 * @since 2020-03-24 20:41
 */
@Data
@ApiModel
public class ExamineLogDTO{

    @ApiModelProperty(value = "")
    private String housesUser;
    @ApiModelProperty(value = "")
    private String examineStatus;
    @ApiModelProperty(value = "")
    private String examineReson;
}