package com.lnsf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.ArticleEntity;
import com.lnsf.service.ArticleService;
import java.util.List;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lnsf.dto.ArticleDTO;
import javax.validation.Valid;



/**
 *  前端控制器
 *
 * @author 黄润志
 * @since 2020-03-10 10:26
 */

@Api(tags = "")
@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation("发布的最新动态")
    @GetMapping(path = "/select/articleList")
    public List<ArticleEntity> articleList(){
        return articleService.articleList();
    }


    @ApiOperation("查看")
    @GetMapping("{articleId}")
    public ArticleEntity view(@ApiParam("资讯编号") @PathVariable(name = "articleId") Long articleId){
        return articleService.getArticle(articleId);
    }



    @ApiOperation("新增")
    @PostMapping(path = "create111")
    public ArticleEntity create(@RequestBody @Valid ArticleDTO dto){
        return articleService.create(dto);
    }

    @ApiOperation("删除")
    @DeleteMapping("{articleId}")
    public void delete(@ApiParam("资讯编号") @PathVariable(name = "articleId") Long articleId) {
        articleService.delete(articleId);
    }

    @ApiOperation("更新")
    @PutMapping("{articleId}")
    public ArticleEntity update(@ApiParam("资讯编号") @PathVariable("articleId") Long articleId,
                            @RequestBody @Valid ArticleDTO dto) {
        return articleService.update(articleId, dto);
    }

}
