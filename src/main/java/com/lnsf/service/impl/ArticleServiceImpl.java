package com.lnsf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lnsf.entity.ArticleEntity;
import com.lnsf.dto.ArticleDTO;
import com.lnsf.dao.ArticleMapper;
import com.lnsf.service.ArticleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.hutool.core.bean.BeanUtil;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        wrapper.orderByDesc("create_time");
        wrapper.last("LIMIT 2");
        return articleMapper.selectList(wrapper);
    }
    /*分页查询动态*/
    public IPage<ArticleEntity> getAllArticleListPage(Integer page){
        IPage<ArticleEntity> ipage = new Page<>(page, 6);
        ArticleEntity articleEntity = new ArticleEntity();
        QueryWrapper<ArticleEntity> wrapper = new QueryWrapper<>(articleEntity);
        wrapper.eq("is_del",false);
        wrapper.orderByDesc("create_time");
        IPage<ArticleEntity> pages=articleMapper.selectPage(ipage,wrapper);
        return pages;
    }
    /*根据时间搜索*/
    public IPage<ArticleEntity> getAllArticleListBytime(Date time, Integer page){
        IPage<ArticleEntity> ipage = new Page<>(page, 6);
        ArticleEntity articleEntity = new ArticleEntity();
        QueryWrapper<ArticleEntity> wrapper = new QueryWrapper<>(articleEntity);
        System.out.println(time);
        wrapper.eq("is_del",false);
        wrapper.ge("create_time",time);//大于等于
        wrapper.orderByDesc("create_time");
        IPage<ArticleEntity> pages=articleMapper.selectPage(ipage,wrapper);
        return pages;
    }
    /*查看我的动态*/
    public IPage<ArticleEntity> getMyArticleList(String username,Integer page){
        IPage<ArticleEntity> ipage = new Page<>(page, 6);
        ArticleEntity articleEntity = new ArticleEntity();
        QueryWrapper<ArticleEntity> wrapper = new QueryWrapper<>(articleEntity);
        wrapper.eq("create_user",username);
        wrapper.eq("is_del",false);
        wrapper.orderByDesc("create_time");
        IPage<ArticleEntity> pages=articleMapper.selectPage(ipage,wrapper);
        return pages;
    }
    /*删除我的动态*/
    public String updateDelete(Long articleId){
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setArticleId(articleId);
        articleEntity.setIsDel(true);
        int num = articleMapper.updateById(articleEntity);
        if (num<=0){
            return "删除失败";
        }else {
            return "删除成功";
        }
    }
    /*取消发布我的动态*/
//    public String updatePublic(Long articleId){
//        ArticleEntity articleEntity = new ArticleEntity();
//        articleEntity.setArticleId(articleId);
//        articleEntity.setIsPublis(false);
//        int num = articleMapper.updateById(articleEntity);
//        if (num<=0){
//            return "取消发布";
//        }else {
//            return "取消发布";
//        }
//    }




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


}
