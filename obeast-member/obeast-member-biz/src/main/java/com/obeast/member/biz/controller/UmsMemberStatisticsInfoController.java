package com.obeast.member.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.member.api.entity.UmsMemberStatisticsInfoEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.biz.service.UmsMemberStatisticsInfoService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员统计信息
 */
@Tag(name = "会员统计信息接口")
@RestController
@RequestMapping("/umsMemberStatisticsInfo")
@RequiredArgsConstructor
public class UmsMemberStatisticsInfoController {

    private final UmsMemberStatisticsInfoService umsMemberStatisticsInfoService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<UmsMemberStatisticsInfoEntity>> page(
            Page<UmsMemberStatisticsInfoEntity> page
    ) {
        return CommonResult.success(umsMemberStatisticsInfoService.pageUmsMemberStatisticsInfos(page));
    }


    /**
     * 添加
     *
     * @param umsMemberStatisticsInfoEntity UmsMemberStatisticsInfoEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody UmsMemberStatisticsInfoEntity umsMemberStatisticsInfoEntity) {
        return CommonResult.success(umsMemberStatisticsInfoService.saveUmsMemberStatisticsInfo(umsMemberStatisticsInfoEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(umsMemberStatisticsInfoService.removeUmsMemberStatisticsInfoById(id));
    }

    /**
     * 编辑
     *
     * @param umsMemberStatisticsInfoEntity UmsMemberStatisticsInfoEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody UmsMemberStatisticsInfoEntity umsMemberStatisticsInfoEntity) {
        return CommonResult.success(umsMemberStatisticsInfoService.updateUmsMemberStatisticsInfo(umsMemberStatisticsInfoEntity));
    }
}
