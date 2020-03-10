package com.lnsf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.ArticleDTO;
import com.lnsf.entity.ArticleEntity;

import java.util.List;


/**
 *  服务类
 *
 * @author 黄润志
 * @since 2020-03-10 10:26
 */
public interface ArticleService {
    /*已经发布的最新动态*/
    List<ArticleEntity> articleList();

    ArticleEntity getArticle(Long articleId);

    ArticleEntity create(ArticleDTO dto);

    void delete(Long articleId);

    ArticleEntity update(Long articleId, ArticleDTO dto);

    List<ArticleEntity> page(ArticleDTO dto, IPage<ArticleEntity> page);
}
