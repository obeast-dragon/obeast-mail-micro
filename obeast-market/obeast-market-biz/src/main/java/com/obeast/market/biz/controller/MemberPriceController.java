package com.obeast.market.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.market.api.entity.MemberPriceEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.biz.service.MemberPriceService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 商品会员价格
 */
@Tag(name = "商品会员价格接口")
@RestController
@RequestMapping("/memberPrice")
@RequiredArgsConstructor
public class MemberPriceController {

    private final MemberPriceService memberPriceService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<MemberPriceEntity>> page(
            Page<MemberPriceEntity> page
    ) {
        return CommonResult.success(memberPriceService.pageMemberPrices(page));
    }


    /**
     * 添加
     *
     * @param memberPriceEntity MemberPriceEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody MemberPriceEntity memberPriceEntity) {
        return CommonResult.success(memberPriceService.saveMemberPrice(memberPriceEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(memberPriceService.removeMemberPriceById(id));
    }

    /**
     * 编辑
     *
     * @param memberPriceEntity MemberPriceEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody MemberPriceEntity memberPriceEntity) {
        return CommonResult.success(memberPriceService.updateMemberPrice(memberPriceEntity));
    }
}
