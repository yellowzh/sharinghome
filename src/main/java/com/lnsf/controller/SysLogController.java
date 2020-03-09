package com.lnsf.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.SysLogEntity;
import com.lnsf.service.SysLogService;
import java.util.List;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lnsf.dto.SysLogDTO;
import javax.validation.Valid;



/**
 * 日志表 前端控制器
 *
 * @author 黄润志
 * @since 2020-03-06 14:12
 */

@Api(tags = "日志表")
@RestController
@RequestMapping("/api")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;


//    @ApiOperation("查看日志表")
//    @GetMapping("{logId}")
//    public SysLogEntity view(@ApiParam("") @PathVariable(name = "logId") String logId){
//        return sysLogService.getSysLog(logId);
//    }
//
//    @ApiOperation("日志表列表")
//    @GetMapping
//    public List<SysLogEntity> list(){
//        return sysLogService.list();
//    }
//
//    @ApiOperation("新增日志表")
//    @PostMapping
//    public SysLogEntity create(@RequestBody @Valid SysLogDTO dto){
//        return sysLogService.create(dto);
//    }
//
//    @ApiOperation("删除日志表")
//    @DeleteMapping("{logId}")
//    public void delete(@ApiParam("") @PathVariable(name = "logId") String logId) {
//        sysLogService.delete(logId);
//    }
//
//    @ApiOperation("更新日志表")
//    @PutMapping("{logId}")
//    public SysLogEntity update(@ApiParam("") @PathVariable("logId") String logId,
//                            @RequestBody @Valid SysLogDTO dto) {
//        return sysLogService.update(logId, dto);
//    }


}
