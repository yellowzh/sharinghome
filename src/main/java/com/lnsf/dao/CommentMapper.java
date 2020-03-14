package com.lnsf.dao;

import com.lnsf.entity.CommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import com.lnsf.dto.CommentDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 *  Mapper 接口
 *
 * @author 黄润志
 * @since 2020-03-10 19:32
 */
@Repository
public interface CommentMapper extends BaseMapper<CommentEntity> {

    List<CommentEntity> page(@Param("dto")CommentDTO dto, IPage<CommentEntity> page);

}
