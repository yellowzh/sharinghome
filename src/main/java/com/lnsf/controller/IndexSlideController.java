package com.lnsf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.IndexSlideEntity;
import com.lnsf.service.IndexSlideService;
import java.util.List;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lnsf.dto.IndexSlideDTO;
import javax.validation.Valid;



/**
 *  前端控制器
 *
 * @author 黄润志
 * @since 2020-03-07 09:32
 */

@Api(tags = "")
@RestController
@RequestMapping("/api")
public class IndexSlideController {

    @Autowired
    private IndexSlideService indexSlideService;


//    @ApiOperation("查看")
//    @GetMapping("{slideId}")
//    public IndexSlideEntity view(@ApiParam("") @PathVariable(name = "slideId") Long slideId){
//        return indexSlideService.getIndexSlide(slideId);
//    }

    @ApiOperation("列表")
    @GetMapping
    public List<IndexSlideEntity> list(){
        return indexSlideService.list();
    }

    @ApiOperation("新增")
    @PostMapping
    public IndexSlideEntity create(@RequestBody @Valid IndexSlideDTO dto){
        return indexSlideService.create(dto);
    }

    @ApiOperation("删除")
    @DeleteMapping("{slideId}")
    public void delete(@ApiParam("") @PathVariable(name = "slideId") Long slideId) {
        indexSlideService.delete(slideId);
    }

    @ApiOperation("更新")
    @PutMapping("{slideId}")
    public IndexSlideEntity update(@ApiParam("") @PathVariable("slideId") Long slideId,
                            @RequestBody @Valid IndexSlideDTO dto) {
        return indexSlideService.update(slideId, dto);
    }

    @ApiOperation("原先推荐过的轮播图")
    @GetMapping(path = "/select/oldSlide")
    public List<IndexSlideEntity> selectOldSlide() {
        return indexSlideService.selectOldSlideList();
    }

}
