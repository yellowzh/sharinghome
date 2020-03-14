package com.lnsf.controller;


import com.lnsf.vo.CommentListVO;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.CommentEntity;
import com.lnsf.service.CommentService;
import java.util.List;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



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

    private static Logger log = Logger.getLogger(LoginController.class);

//    @ApiOperation("查看")
//    @GetMapping("{commentId}")
//    public CommentEntity view(@ApiParam("评价编号") @PathVariable(name = "commentId") Long commentId){
//        return commentService.getComment(commentId);
//    }

    @ApiOperation("列表")
    @GetMapping(path = "/select/commentList")
    public CommentListVO commentList(Integer housesId){
        log.info("房源编号："+housesId);
        return commentService.list(housesId);
    }
//
//    @ApiOperation("新增")
//    @PostMapping
//    public CommentEntity create(@RequestBody @Valid CommentDTO dto){
//        return commentService.create(dto);
//    }
//
//    @ApiOperation("删除")
//    @DeleteMapping("{commentId}")
//    public void delete(@ApiParam("评价编号") @PathVariable(name = "commentId") Long commentId) {
//        commentService.delete(commentId);
//    }
//
//    @ApiOperation("更新")
//    @PutMapping("{commentId}")
//    public CommentEntity update(@ApiParam("评价编号") @PathVariable("commentId") Long commentId,
//                            @RequestBody @Valid CommentDTO dto) {
//        return commentService.update(commentId, dto);
//    }
}
