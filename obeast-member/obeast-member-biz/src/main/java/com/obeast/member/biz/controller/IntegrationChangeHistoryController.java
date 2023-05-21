package com.obeast.member.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.member.api.entity.IntegrationChangeHistoryEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.biz.service.IntegrationChangeHistoryService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 积分变化历史记录
 */
@Tag(name = "积分变化历史记录接口")
@RestController
@RequestMapping("/integrationChangeHistory")
@RequiredArgsConstructor
public class IntegrationChangeHistoryController {

    private final IntegrationChangeHistoryService integrationChangeHistoryService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<IntegrationChangeHistoryEntity>> page(
            Page<IntegrationChangeHistoryEntity> page
    ) {
        return CommonResult.success(integrationChangeHistoryService.pageIntegrationChangeHistorys(page));
    }


    /**
     * 添加
     *
     * @param integrationChangeHistoryEntity IntegrationChangeHistoryEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody IntegrationChangeHistoryEntity integrationChangeHistoryEntity) {
        return CommonResult.success(integrationChangeHistoryService.saveIntegrationChangeHistory(integrationChangeHistoryEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(integrationChangeHistoryService.removeIntegrationChangeHistoryById(id));
    }

    /**
     * 编辑
     *
     * @param integrationChangeHistoryEntity IntegrationChangeHistoryEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody IntegrationChangeHistoryEntity integrationChangeHistoryEntity) {
        return CommonResult.success(integrationChangeHistoryService.updateIntegrationChangeHistory(integrationChangeHistoryEntity));
    }
}
