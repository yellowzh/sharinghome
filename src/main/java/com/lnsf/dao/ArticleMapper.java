package com.lnsf.dao;

import com.lnsf.entity.ArticleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.lnsf.dto.ArticleDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 *  Mapper 接口
 *
 * @author 黄润志
 * @since 2020-03-10 10:26
 */
@Mapper
public interface ArticleMapper extends BaseMapper<ArticleEntity> {

    List<ArticleEntity> page(@Param("dto")ArticleDTO dto, IPage<ArticleEntity> page);

}
