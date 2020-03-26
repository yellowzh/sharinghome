package com.lnsf.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.dto.SeeNoteDTO;
import com.lnsf.entity.SeeNoteEntity;
import com.lnsf.service.SeeNoteService;
import com.lnsf.vo.SeeListVO;
import com.lnsf.vo.SeeVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 *  前端控制器
 *
 * @author 黄润志
 * @since 2020-03-26 15:30
 */

@Api(tags = "")
@RestController
@RequestMapping("/api")
public class SeeNoteController {

    @Autowired
    private SeeNoteService seeNoteService;


//    @ApiOperation("查看")
//    @GetMapping("{seeId}")
//    public SeeNoteEntity view(@ApiParam("") @PathVariable(name = "seeId") Long seeId){
//        return seeNoteService.getSeeNote(seeId);
//    }

    @ApiOperation("列表")
    @GetMapping("/SeeVo")
    public SeeListVO SeeVo(){
        return seeNoteService.SeeVo();
    }

}
