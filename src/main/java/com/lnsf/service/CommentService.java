package com.lnsf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.CommentDTO;
import com.lnsf.entity.CommentEntity;
import com.lnsf.vo.CommentListVO;

import java.util.List;


/**
 *  服务类
 *
 * @author 黄润志
 * @since 2020-03-10 19:32
 */
public interface CommentService {
    /*查询评论列表*/
    CommentListVO list(Integer houserId);

    CommentEntity getComment(Long commentId);

    CommentEntity create(CommentDTO dto);

    String deletUpdate(Long commentId);

    CommentEntity update(Long commentId, CommentDTO dto);
    /*评价管理分页*/
    IPage<CommentEntity> getHousesCommentPage(Integer housesId, Integer page);

    /*查看评论的回复*/
    List<CommentEntity> commentReplayList(Long commentId);
}
