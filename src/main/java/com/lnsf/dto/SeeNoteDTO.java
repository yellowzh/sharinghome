package com.lnsf.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author 黄润志
 * @since 2020-03-26 15:11
 */
@Data
@ApiModel
public class SeeNoteDTO{

    @ApiModelProperty(value = "")
    private String housesTitle;
    @ApiModelProperty(value = "")
    private Integer seeNum;
    private Integer housesId;
    private Date createTime;
}