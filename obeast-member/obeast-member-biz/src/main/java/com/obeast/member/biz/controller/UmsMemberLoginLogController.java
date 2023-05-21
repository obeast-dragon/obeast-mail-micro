package com.obeast.member.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.member.api.entity.UmsMemberLoginLogEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.biz.service.UmsMemberLoginLogService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员登录记录
 */
@Tag(name = "会员登录记录接口")
@RestController
@RequestMapping("/umsMemberLoginLog")
@RequiredArgsConstructor
public class UmsMemberLoginLogController {

    private final UmsMemberLoginLogService umsMemberLoginLogService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<UmsMemberLoginLogEntity>> page(
            Page<UmsMemberLoginLogEntity> page
    ) {
        return CommonResult.success(umsMemberLoginLogService.pageUmsMemberLoginLogs(page));
    }


    /**
     * 添加
     *
     * @param umsMemberLoginLogEntity UmsMemberLoginLogEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody UmsMemberLoginLogEntity umsMemberLoginLogEntity) {
        return CommonResult.success(umsMemberLoginLogService.saveUmsMemberLoginLog(umsMemberLoginLogEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(umsMemberLoginLogService.removeUmsMemberLoginLogById(id));
    }

    /**
     * 编辑
     *
     * @param umsMemberLoginLogEntity UmsMemberLoginLogEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody UmsMemberLoginLogEntity umsMemberLoginLogEntity) {
        return CommonResult.success(umsMemberLoginLogService.updateUmsMemberLoginLog(umsMemberLoginLogEntity));
    }
}
