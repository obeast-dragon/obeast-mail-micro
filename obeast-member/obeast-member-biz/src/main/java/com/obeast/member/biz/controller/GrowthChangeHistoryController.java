package com.obeast.member.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.member.api.entity.GrowthChangeHistoryEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.biz.service.GrowthChangeHistoryService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 成长值变化历史记录
 */
@Tag(name = "成长值变化历史记录接口")
@RestController
@RequestMapping("/growthChangeHistory")
@RequiredArgsConstructor
public class GrowthChangeHistoryController {

    private final GrowthChangeHistoryService growthChangeHistoryService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<GrowthChangeHistoryEntity>> page(
            Page<GrowthChangeHistoryEntity> page
    ) {
        return CommonResult.success(growthChangeHistoryService.pageGrowthChangeHistorys(page));
    }


    /**
     * 添加
     *
     * @param growthChangeHistoryEntity GrowthChangeHistoryEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody GrowthChangeHistoryEntity growthChangeHistoryEntity) {
        return CommonResult.success(growthChangeHistoryService.saveGrowthChangeHistory(growthChangeHistoryEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(growthChangeHistoryService.removeGrowthChangeHistoryById(id));
    }

    /**
     * 编辑
     *
     * @param growthChangeHistoryEntity GrowthChangeHistoryEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody GrowthChangeHistoryEntity growthChangeHistoryEntity) {
        return CommonResult.success(growthChangeHistoryService.updateGrowthChangeHistory(growthChangeHistoryEntity));
    }
}
