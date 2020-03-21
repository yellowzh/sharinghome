package com.lnsf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.ArticleDTO;
import com.lnsf.entity.ArticleEntity;

import java.util.Date;
import java.util.List;


/**
 *  服务类
 *
 * @author 黄润志
 * @since 2020-03-10 10:26
 */
public interface ArticleService {
    /*已经发布的最新两条动态*/
    List<ArticleEntity> articleList();
    /*分页查看动态*/
    IPage<ArticleEntity> getAllArticleListPage(Integer page);
    /*根据时间搜索*/
    IPage<ArticleEntity> getAllArticleListBytime(Date time,Integer page);
    /*查看我的动态*/
    IPage<ArticleEntity> getMyArticleList(String username,Integer page);
    /*删除我的动态*/
    String updateDelete(Long articleId);

    ArticleEntity getArticle(Long articleId);

    ArticleEntity create(ArticleDTO dto);

    void delete(Long articleId);

    ArticleEntity update(Long articleId, ArticleDTO dto);
}
