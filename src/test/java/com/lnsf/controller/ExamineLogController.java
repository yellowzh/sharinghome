package com.lnsf.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bgy.cs.common.logger.OperationLog;
import com.bgy.cs.common.logger.OperationLogType;
import com.bgy.cs.common.db.page.PageFactory;
import com.bgy.cs.common.db.page.PageResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.ExamineLogEntity;
import com.lnsf.service.ExamineLogService;
import java.util.List;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lnsf.dto.ExamineLogDTO;
import javax.validation.Valid;



/**
 *  前端控制器
 *
 * @author 黄润志
 * @since 2020-03-24 20:41
 */

@Api(tags = "")
@RestController
@RequestMapping("/examine-log-entity")
public class ExamineLogController {

    @Autowired
    private ExamineLogService examineLogService;


    @ApiOperation("查看")
    @GetMapping("{examineId}")
    public ExamineLogEntity view(@ApiParam("") @PathVariable(name = "examineId") Long examineId){
        return examineLogService.getExamineLog(examineId);
    }

    @ApiOperation("列表")
    @GetMapping
    public List<ExamineLogEntity> list(){
        return examineLogService.list();
    }

    @ApiOperation("新增")
    @OperationLog(OperationLogType.INSERT)
    @PostMapping
    public ExamineLogEntity create(@RequestBody @Valid ExamineLogDTO dto){
        return examineLogService.create(dto);
    }

    @ApiOperation("删除")
    @OperationLog(OperationLogType.DELETE)
    @DeleteMapping("{examineId}")
    public void delete(@ApiParam("") @PathVariable(name = "examineId") Long examineId) {
        examineLogService.delete(examineId);
    }

    @ApiOperation("更新")
    @OperationLog(OperationLogType.UPDATE)
    @PutMapping("{examineId}")
    public ExamineLogEntity update(@ApiParam("") @PathVariable("examineId") Long examineId,
                            @RequestBody @Valid ExamineLogDTO dto) {
        return examineLogService.update(examineId, dto);
    }

    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "housesUser", value = ""),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "examineStatus", value = ""),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "examineReson", value = ""),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "page", value = "分页页码"),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "size", value = "每页数量"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "ascs", value = "升序字段，多个用逗号隔开"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "descs", value = "降序字段，多个用逗号隔开")
    })
    @GetMapping(path = "/page")
    public PageResult page(ExamineLogDTO dto) {
        IPage<ExamineLogEntity> page = PageFactory.convertPageByParameters();
        List<ExamineLogEntity> list = examineLogService.page(dto, page);
        return PageFactory.buildPageResult(page, list);
    }

}
