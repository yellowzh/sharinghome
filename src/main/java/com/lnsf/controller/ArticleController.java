package com.lnsf.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lnsf.dto.IndexSlideDTO;
import com.lnsf.entity.UserInfoEntity;
import com.lnsf.util.UploadImgUtil;
import com.lnsf.vo.ArticleListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.ArticleEntity;
import com.lnsf.service.ArticleService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lnsf.dto.ArticleDTO;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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

    /*点击动态跳转*/
    @ApiOperation(value = "动态页面跳转", notes = "查询动态",httpMethod = "GET")
    @RequestMapping("/select/userDynamic")
    public ModelAndView userDynamic(){
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("user/userDynamic");
        return model_html;
    }
    /*value：方法标注*/
    @ApiOperation(value = "查看所有资讯", notes = "记录",httpMethod = "GET")
    @RequestMapping("/select/allArticleList")
    public ArticleListVO getAllArticleList(Integer page){
        if (page==null)
        {page=1;}
        IPage<ArticleEntity> infoEntityIPage = articleService.getAllArticleListPage(page);
        /*如果为最后一页则返回最后一页数据*/
        if(infoEntityIPage.getCurrent()>infoEntityIPage.getPages()){
            page=Integer.parseInt(String.valueOf(infoEntityIPage.getPages()));
            infoEntityIPage = articleService.getAllArticleListPage(page);
        }
        return transformation(infoEntityIPage);
    }

    @ApiOperation(value = "查看所有资讯", notes = "记录",httpMethod = "POST")
    @RequestMapping("/select/allArticleListBytime")
    public ArticleListVO getAllArticleListBytime(Integer page,@RequestBody ArticleEntity articleEntity){
        IPage<ArticleEntity> infoEntityIPage = articleService.getAllArticleListBytime(articleEntity.getCreateTime(),page);
        /*如果为最后一页则返回最后一页数据*/
        if(infoEntityIPage.getCurrent()>infoEntityIPage.getPages()){
            page=Integer.parseInt(String.valueOf(infoEntityIPage.getPages()));
            infoEntityIPage = articleService.getAllArticleListBytime(articleEntity.getCreateTime(),page);
        }
        return transformation(infoEntityIPage);
    }
    @ApiOperation(value = "查看所有资讯", notes = "记录",httpMethod = "POST")
    @RequestMapping("/getMyArticleList")
    public ArticleListVO getMyArticleList(Integer page, HttpSession session){
        UserInfoEntity user = (UserInfoEntity) session.getAttribute("user");
        IPage<ArticleEntity> infoEntityIPage = articleService.getMyArticleList(user.getUsername(),page);
        /*如果为最后一页则返回最后一页数据*/
        if(infoEntityIPage.getCurrent()>infoEntityIPage.getPages()){
            page=Integer.parseInt(String.valueOf(infoEntityIPage.getPages()));
            infoEntityIPage = articleService.getMyArticleList(user.getUsername(),page);
        }
        return transformation(infoEntityIPage);
    }
    /*数据处理*/
    public ArticleListVO transformation(IPage<ArticleEntity> iPage){
        ArticleListVO articleListVO = new ArticleListVO();
        List<ArticleDTO> articleDTOS = new ArrayList<>();
        for (ArticleEntity a:iPage.getRecords()) {
            ArticleDTO articleDTO = new ArticleDTO();
            BeanUtils.copyProperties(a,articleDTO);
            articleDTO.setArticleId(a.getArticleId()+"");
            articleDTOS.add(articleDTO);
        }
        articleListVO.setArticleEntities(articleDTOS);
        articleListVO.setIndexPage(iPage.getCurrent());
        articleListVO.setTotalPage(iPage.getPages());
        return articleListVO;
    }
    @ApiOperation("新增动态")
    @PostMapping(path = "addArticleList")
    public ArticleEntity create(@RequestParam("file") MultipartFile file, @RequestParam("dto") String dto, Map<String,Object> map,HttpSession session){
        UserInfoEntity user = (UserInfoEntity) session.getAttribute("user");
        ObjectMapper objectMapper = new ObjectMapper();
        ArticleDTO articleDTO = null;
        System.out.println("获取图片："+file.getOriginalFilename());
        try {
            articleDTO = objectMapper.readValue(dto, ArticleDTO.class);
            map= UploadImgUtil.uplond(file,map);
            System.out.println("上传图片后需要获取的路径："+map.get("filename"));
            /*更新头像*/
            articleDTO.setArticeUrl(String.valueOf(map.get("filename")));
            articleDTO.setCreateUser(user.getUsername());
            articleDTO.setIsDel(false);
            articleDTO.setIsPublis(true);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return articleService.create(articleDTO);
    }
    @ApiOperation("删除")
    @GetMapping("/delArtice")
    public String delete(Long articleId) {
       return articleService.updateDelete(articleId);
    }
//    @ApiOperation("查看")
//    @GetMapping("{articleId}")
//    public ArticleEntity view(@ApiParam("资讯编号") @PathVariable(name = "articleId") Long articleId){
//        return articleService.getArticle(articleId);
//    }


//

//

//
//    @ApiOperation("更新")
//    @PutMapping("{articleId}")
//    public ArticleEntity update(@ApiParam("资讯编号") @PathVariable("articleId") Long articleId,
//                            @RequestBody @Valid ArticleDTO dto) {
//        return articleService.update(articleId, dto);
//    }

}
