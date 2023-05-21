package com.obeast.member.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.member.api.entity.MemberStatisticsInfoEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.biz.service.MemberStatisticsInfoService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员统计信息
 */
@Tag(name = "会员统计信息接口")
@RestController
@RequestMapping("/memberStatisticsInfo")
@RequiredArgsConstructor
public class MemberStatisticsInfoController {

    private final MemberStatisticsInfoService memberStatisticsInfoService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<MemberStatisticsInfoEntity>> page(
            Page<MemberStatisticsInfoEntity> page
    ) {
        return CommonResult.success(memberStatisticsInfoService.pageMemberStatisticsInfos(page));
    }


    /**
     * 添加
     *
     * @param memberStatisticsInfoEntity MemberStatisticsInfoEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody MemberStatisticsInfoEntity memberStatisticsInfoEntity) {
        return CommonResult.success(memberStatisticsInfoService.saveMemberStatisticsInfo(memberStatisticsInfoEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(memberStatisticsInfoService.removeMemberStatisticsInfoById(id));
    }

    /**
     * 编辑
     *
     * @param memberStatisticsInfoEntity MemberStatisticsInfoEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody MemberStatisticsInfoEntity memberStatisticsInfoEntity) {
        return CommonResult.success(memberStatisticsInfoService.updateMemberStatisticsInfo(memberStatisticsInfoEntity));
    }
}
