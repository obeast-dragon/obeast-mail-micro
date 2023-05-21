package com.obeast.member.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.member.api.entity.MemberLevelEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.biz.service.MemberLevelService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员等级
 */
@Tag(name = "会员等级接口")
@RestController
@RequestMapping("/memberLevel")
@RequiredArgsConstructor
public class MemberLevelController {

    private final MemberLevelService memberLevelService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<MemberLevelEntity>> page(
            Page<MemberLevelEntity> page
    ) {
        return CommonResult.success(memberLevelService.pageMemberLevels(page));
    }


    /**
     * 添加
     *
     * @param memberLevelEntity MemberLevelEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody MemberLevelEntity memberLevelEntity) {
        return CommonResult.success(memberLevelService.saveMemberLevel(memberLevelEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(memberLevelService.removeMemberLevelById(id));
    }

    /**
     * 编辑
     *
     * @param memberLevelEntity MemberLevelEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody MemberLevelEntity memberLevelEntity) {
        return CommonResult.success(memberLevelService.updateMemberLevel(memberLevelEntity));
    }
}
