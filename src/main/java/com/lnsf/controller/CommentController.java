package com.lnsf.controller;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.CommentDTO;
import com.lnsf.entity.UserInfoEntity;
import com.lnsf.service.UserInfoService;
import com.lnsf.util.UploadImgUtil;
import com.lnsf.vo.CommentListVO;
import com.lnsf.vo.CommentVO;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.CommentEntity;
import com.lnsf.service.CommentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


/**
 *  前端控制器
 *
 * @author 黄润志
 * @since 2020-03-10 19:32
 */

@Api(tags = "")
@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserInfoService userInfoService;

    private static Logger log = Logger.getLogger(LoginController.class);

    @ApiOperation("列表")
    @GetMapping(path = "/select/commentList")
    public CommentListVO commentList(Integer housesId){
        log.info("房源编号："+housesId);
        return commentService.list(housesId);
    }
    @ApiOperation("添加图片")
    @PostMapping(path = "/addPhoto")
    public String addPhoto(@RequestParam("file") MultipartFile file,Map<String,Object> map){
        try {
            map= UploadImgUtil.uplond(file,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("上传图片后需要获取的路径："+map.get("filename"));
        return String.valueOf(map.get("filename"));
    }

    @ApiOperation("新增")
    @PostMapping(path = "/addComment")
    public CommentEntity addComment(@RequestBody CommentDTO dto){
        return commentService.create(dto);
    }

    /*后台管理*/
    @ApiOperation(value = "评论管理以及查看房源评论", notes = "评论查询",httpMethod = "GET")
    @RequestMapping("/selectHousesComment")
    public ModelAndView selectHousesComment(Integer housesId, Map<String, Object> map){
        if (housesId==null){
            housesId=-1;
        }
        map.put("housesId",housesId);
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/housesComment");
        return model_html;
    }

    @ApiOperation(value = "订单管理以及查看我的订单", notes = "我的订单查询",httpMethod = "GET")
    @RequestMapping("/getHousesCommentPage")
    public CommentListVO getHousesCommentPage(Integer housesId, Integer page){
        if (page==null)
        { page=1;}
        IPage<CommentEntity> infoEntityIPage = commentService.getHousesCommentPage(housesId,page);
        /*判断最后一页*/
        if(infoEntityIPage.getCurrent()>infoEntityIPage.getPages()){
            page=Integer.parseInt(String.valueOf(infoEntityIPage.getPages()));
            infoEntityIPage =commentService.getHousesCommentPage(housesId,page);
        }
        List<CommentVO> commentVOS = new ArrayList<>();//评价
//        List<CommentVO> replayVOs = new ArrayList<>();//回复
        float num=0;
        double fenshu=0;
        double nums=0;
        for (CommentEntity c:infoEntityIPage.getRecords()) {
            CommentVO commentVO = new CommentVO();
            BeanUtils.copyProperties(c, commentVO);
            commentVO.setCommentId(c.getCommentId()+"");
            /*查询对应用户*/
            UserInfoEntity userInfoEntity = userInfoService.getUserById(c.getUserId());
            commentVO.setUserPhoto(userInfoEntity.getUserBackup2());
            commentVO.setUsername(userInfoEntity.getUsername());
            /*添加是否有照片判断*/
            if (c.getCommentPhoto()!=null){
                commentVO.setIsPhoto(true);
            }else {
                commentVO.setIsPhoto(false);
            }
            commentVOS.add(commentVO);
            fenshu+=c.getCommentPower();
            num++;
        }
        if (num!=0) {
            nums = fenshu / num;
        }
        CommentListVO commentListVO = new CommentListVO();
        commentListVO.setCommentVO(commentVOS);//评论
//        commentListVO.setReplayVO(replayVOs);//回复
//        commentListVO.setIsData();//是否有数据
        commentListVO.setCount(nums);//平均分
        commentListVO.setIndexPage(infoEntityIPage.getCurrent());
        commentListVO.setTotalPage(infoEntityIPage.getPages());
        return commentListVO;
    }

    @ApiOperation(value = "查看订单回复", notes = "查看评论回复",httpMethod = "GET")
    @RequestMapping("/getCommentReplay")
    public List<CommentVO> getCommentReplay(Long commentId){
        List<CommentEntity> commentEntityList = commentService.commentReplayList(commentId);
        List<CommentVO> commentVOS = new ArrayList<>();//回复
        for (CommentEntity c:commentEntityList) {
            CommentVO commentVO = new CommentVO();
            BeanUtils.copyProperties(c, commentVO);
            commentVO.setCommentId(c.getCommentId()+"");
            /*查询对应用户*/
            UserInfoEntity userInfoEntity = userInfoService.getUserById(c.getUserId());
            commentVO.setUserPhoto(userInfoEntity.getUserBackup2());
            commentVO.setUsername(userInfoEntity.getUsername());
            /*添加是否有照片判断*/
            if (c.getCommentPhoto()!=null){
                commentVO.setIsPhoto(true);
            }else {
                commentVO.setIsPhoto(false);
            }
            commentVOS.add(commentVO);
        }
        return commentVOS;
    }
    //
    @ApiOperation("删除")
    @GetMapping("/delComent")
    public String delComent(Long commentId) {
        return commentService.deletUpdate(commentId);
    }
}
