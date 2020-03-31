package com.lnsf.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lnsf.entity.UserInfoEntity;
import com.lnsf.util.UploadImgUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.IndexSlideEntity;
import com.lnsf.service.IndexSlideService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lnsf.dto.IndexSlideDTO;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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

//    @ApiOperation("列表")
//    @GetMapping
//    public List<IndexSlideEntity> list(){
//        return indexSlideService.list();
//    }
//
//
//    @ApiOperation("删除")
//    @DeleteMapping("{slideId}")
//    public void delete(@ApiParam("") @PathVariable(name = "slideId") Long slideId) {
//        indexSlideService.delete(slideId);
//    }



    @ApiOperation("原先推荐过的轮播图")
    @GetMapping(path = "/select/oldSlide")
    @Cacheable(value = "selectOldSlide")
    public List<IndexSlideDTO> selectOldSlide() {
        return indexSlideService.selectOldSlideList();
    }

    /*后台管理*/
    @ApiOperation("原先推荐过的轮播图")
    @GetMapping(path = "/getOldSlide")
    public List<IndexSlideDTO> getOldSlide() {
        return indexSlideService.selectOldSlideList();
    }

    @ApiOperation("装修管理页面跳转")
    @GetMapping(path = "/recommend")
    public ModelAndView recommend() {
        ModelAndView model_html = new ModelAndView();
        model_html.setViewName("admin/recommend");
        return model_html;
    }
    @CacheEvict(value = "selectOldSlide",allEntries = true)
    @ApiOperation("删除轮播图")
    @GetMapping("/delSlideUpdate")
    public String delSlideUpdate(Integer slideId) {
        return indexSlideService.delSlideUpdate(slideId);
    }
    @CacheEvict(value = "selectOldSlide",allEntries = true)
    @ApiOperation("新增")
    @PostMapping(path = "/createSlide")
    public IndexSlideEntity create(@RequestParam("file") MultipartFile file, @RequestParam("dto") String dto, Map<String,Object> map){

        ObjectMapper objectMapper = new ObjectMapper();
        IndexSlideDTO indexSlideDTO = null;
        System.out.println("获取图片："+file.getOriginalFilename());
        try {
            indexSlideDTO = objectMapper.readValue(dto, IndexSlideDTO.class);
            map= UploadImgUtil.uplond(file,map);
            System.out.println("上传图片后需要获取的路径："+map.get("filename"));
            /*更新头像*/
            indexSlideDTO.setSlideUrl(String.valueOf(map.get("filename")));
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("数据传输："+indexSlideDTO.getHouseTilte());
        return indexSlideService.create(indexSlideDTO);
    }

    @ApiOperation("查看单条轮播")
    @GetMapping("/getSlideById")
    public IndexSlideDTO view(Integer slideId){
        return indexSlideService.getIndexSlide(slideId);
    }
    @ApiOperation("更新")
    @PostMapping("/updateSlide")
    @CacheEvict(value = "selectOldSlide",allEntries = true)
    public IndexSlideEntity updateSlide(@RequestParam("file") MultipartFile file, @RequestParam("dto") String dto, Map<String,Object> map) {
        ObjectMapper objectMapper = new ObjectMapper();
        IndexSlideDTO indexSlideDTO = null;
        System.out.println("获取图片："+file.getOriginalFilename());
        try {
            indexSlideDTO = objectMapper.readValue(dto, IndexSlideDTO.class);
            if (file.getOriginalFilename()==indexSlideDTO.getSlideUrl()){
                System.out.println("获取失败图片：");
            }else {
                map= UploadImgUtil.uplond(file,map);
                System.out.println("上传图片后需要获取的路径："+map.get("filename"));
                /*更新头像*/
                indexSlideDTO.setSlideUrl(String.valueOf(map.get("filename")));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return indexSlideService.update(indexSlideDTO.getSlideId(), indexSlideDTO);
    }
    @ApiOperation("更新")
    @PostMapping("/updateSlide2")
    @CacheEvict(value = "selectOldSlide",allEntries = true)
    public IndexSlideEntity updateSlide2(@RequestParam("dto") String dto) {
        ObjectMapper objectMapper = new ObjectMapper();
        IndexSlideDTO indexSlideDTO = null;
        try {
            indexSlideDTO = objectMapper.readValue(dto, IndexSlideDTO.class);
            System.out.println("没有更新图片：");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return indexSlideService.update(indexSlideDTO.getSlideId(), indexSlideDTO);
    }

}
