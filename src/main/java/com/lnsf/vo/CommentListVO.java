package com.lnsf.vo;

import com.lnsf.entity.CommentEntity;
import lombok.Data;

import java.util.List;
@Data
public class CommentListVO {
    /*数据*/
    private List<CommentVO> commentVO;
    /*平均评分*/
    private double count;
    /*是否有数据*/
    private Boolean isData;
}
