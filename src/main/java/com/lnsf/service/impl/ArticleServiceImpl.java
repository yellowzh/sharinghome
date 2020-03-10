package com.lnsf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lnsf.entity.ArticleEntity;
import com.lnsf.dto.ArticleDTO;
import com.lnsf.dao.ArticleMapper;
import com.lnsf.service.ArticleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.hutool.core.bean.BeanUtil;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 *  服务实现类
 *
 * @author 黄润志
 * @since 2020-03-10 10:26
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /*已发布的最新动态*/
    @Override
    public List<ArticleEntity> articleList(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("is_del",false);
        wrapper.eq("is_publis",true);
        return articleMapper.selectList(null);
    }





    @Override
    public ArticleEntity getArticle(Long articleId){
        return articleMapper.selectById(articleId);
    }

    @Override
    public ArticleEntity create(ArticleDTO dto) {
        if (null == dto) {
            throw new ServiceException("参数为空!");
        }
        ArticleEntity entity = new ArticleEntity();
        BeanUtil.copyProperties(dto, entity);
        articleMapper.insert(entity);
        return entity;
    }

    @Override
    public void delete(Long articleId) {
        if (null == articleId) {
            return;
        }
        articleMapper.deleteById(articleId);
    }

    @Override
    public ArticleEntity update(Long articleId, ArticleDTO dto) {
        if (null == articleId) {
            return null;
        }
        ArticleEntity existEntity = articleMapper.selectById(articleId);
        if (null == existEntity) {
            return null;
        }
        BeanUtil.copyProperties(dto, existEntity);
        articleMapper.updateById(existEntity);
        return existEntity;
    }

    @Override
    public List<ArticleEntity> page(ArticleDTO dto, IPage<ArticleEntity> page) {
        return articleMapper.page(dto, page);
    }

}
