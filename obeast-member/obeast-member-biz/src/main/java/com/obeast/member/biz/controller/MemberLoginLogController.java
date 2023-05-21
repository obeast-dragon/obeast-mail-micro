package com.obeast.member.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.member.api.entity.MemberLoginLogEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.biz.service.MemberLoginLogService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员登录记录
 */
@Tag(name = "会员登录记录接口")
@RestController
@RequestMapping("/memberLoginLog")
@RequiredArgsConstructor
public class MemberLoginLogController {

    private final MemberLoginLogService memberLoginLogService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<MemberLoginLogEntity>> page(
            Page<MemberLoginLogEntity> page
    ) {
        return CommonResult.success(memberLoginLogService.pageMemberLoginLogs(page));
    }


    /**
     * 添加
     *
     * @param memberLoginLogEntity MemberLoginLogEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody MemberLoginLogEntity memberLoginLogEntity) {
        return CommonResult.success(memberLoginLogService.saveMemberLoginLog(memberLoginLogEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(memberLoginLogService.removeMemberLoginLogById(id));
    }

    /**
     * 编辑
     *
     * @param memberLoginLogEntity MemberLoginLogEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody MemberLoginLogEntity memberLoginLogEntity) {
        return CommonResult.success(memberLoginLogService.updateMemberLoginLog(memberLoginLogEntity));
    }
}
