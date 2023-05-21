package com.obeast.member.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.member.api.entity.UmsGrowthChangeHistoryEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.biz.service.UmsGrowthChangeHistoryService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 成长值变化历史记录
 */
@Tag(name = "成长值变化历史记录接口")
@RestController
@RequestMapping("/umsGrowthChangeHistory")
@RequiredArgsConstructor
public class UmsGrowthChangeHistoryController {

    private final UmsGrowthChangeHistoryService umsGrowthChangeHistoryService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<UmsGrowthChangeHistoryEntity>> page(
            Page<UmsGrowthChangeHistoryEntity> page
    ) {
        return CommonResult.success(umsGrowthChangeHistoryService.pageUmsGrowthChangeHistorys(page));
    }


    /**
     * 添加
     *
     * @param umsGrowthChangeHistoryEntity UmsGrowthChangeHistoryEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody UmsGrowthChangeHistoryEntity umsGrowthChangeHistoryEntity) {
        return CommonResult.success(umsGrowthChangeHistoryService.saveUmsGrowthChangeHistory(umsGrowthChangeHistoryEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(umsGrowthChangeHistoryService.removeUmsGrowthChangeHistoryById(id));
    }

    /**
     * 编辑
     *
     * @param umsGrowthChangeHistoryEntity UmsGrowthChangeHistoryEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody UmsGrowthChangeHistoryEntity umsGrowthChangeHistoryEntity) {
        return CommonResult.success(umsGrowthChangeHistoryService.updateUmsGrowthChangeHistory(umsGrowthChangeHistoryEntity));
    }
}
