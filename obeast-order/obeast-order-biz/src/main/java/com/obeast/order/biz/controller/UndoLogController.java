package com.obeast.order.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.order.api.entity.UndoLogEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.order.biz.service.UndoLogService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 
 */
@Tag(name = "接口")
@RestController
@RequestMapping("/undoLog")
@RequiredArgsConstructor
public class UndoLogController {

    private final UndoLogService undoLogService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<UndoLogEntity>> page(
            Page<UndoLogEntity> page
    ) {
        return CommonResult.success(undoLogService.pageUndoLogs(page));
    }


    /**
     * 添加
     *
     * @param undoLogEntity UndoLogEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody UndoLogEntity undoLogEntity) {
        return CommonResult.success(undoLogService.saveUndoLog(undoLogEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(undoLogService.removeUndoLogById(id));
    }

    /**
     * 编辑
     *
     * @param undoLogEntity UndoLogEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody UndoLogEntity undoLogEntity) {
        return CommonResult.success(undoLogService.updateUndoLog(undoLogEntity));
    }
}
