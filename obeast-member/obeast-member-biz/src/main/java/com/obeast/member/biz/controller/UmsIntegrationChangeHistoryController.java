package com.obeast.member.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.member.api.entity.UmsIntegrationChangeHistoryEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.biz.service.UmsIntegrationChangeHistoryService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 积分变化历史记录
 */
@Tag(name = "积分变化历史记录接口")
@RestController
@RequestMapping("/umsIntegrationChangeHistory")
@RequiredArgsConstructor
public class UmsIntegrationChangeHistoryController {

    private final UmsIntegrationChangeHistoryService umsIntegrationChangeHistoryService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<UmsIntegrationChangeHistoryEntity>> page(
            Page<UmsIntegrationChangeHistoryEntity> page
    ) {
        return CommonResult.success(umsIntegrationChangeHistoryService.pageUmsIntegrationChangeHistorys(page));
    }


    /**
     * 添加
     *
     * @param umsIntegrationChangeHistoryEntity UmsIntegrationChangeHistoryEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody UmsIntegrationChangeHistoryEntity umsIntegrationChangeHistoryEntity) {
        return CommonResult.success(umsIntegrationChangeHistoryService.saveUmsIntegrationChangeHistory(umsIntegrationChangeHistoryEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(umsIntegrationChangeHistoryService.removeUmsIntegrationChangeHistoryById(id));
    }

    /**
     * 编辑
     *
     * @param umsIntegrationChangeHistoryEntity UmsIntegrationChangeHistoryEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody UmsIntegrationChangeHistoryEntity umsIntegrationChangeHistoryEntity) {
        return CommonResult.success(umsIntegrationChangeHistoryService.updateUmsIntegrationChangeHistory(umsIntegrationChangeHistoryEntity));
    }
}
