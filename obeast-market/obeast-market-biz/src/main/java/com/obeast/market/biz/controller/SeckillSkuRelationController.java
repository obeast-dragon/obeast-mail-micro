package com.obeast.market.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.market.api.entity.SeckillSkuRelationEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.biz.service.SeckillSkuRelationService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 秒杀活动商品关联
 */
@Tag(name = "秒杀活动商品关联接口")
@RestController
@RequestMapping("/seckillSkuRelation")
@RequiredArgsConstructor
public class SeckillSkuRelationController {

    private final SeckillSkuRelationService seckillSkuRelationService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<SeckillSkuRelationEntity>> page(
            Page<SeckillSkuRelationEntity> page
    ) {
        return CommonResult.success(seckillSkuRelationService.pageSeckillSkuRelations(page));
    }


    /**
     * 添加
     *
     * @param seckillSkuRelationEntity SeckillSkuRelationEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody SeckillSkuRelationEntity seckillSkuRelationEntity) {
        return CommonResult.success(seckillSkuRelationService.saveSeckillSkuRelation(seckillSkuRelationEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(seckillSkuRelationService.removeSeckillSkuRelationById(id));
    }

    /**
     * 编辑
     *
     * @param seckillSkuRelationEntity SeckillSkuRelationEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody SeckillSkuRelationEntity seckillSkuRelationEntity) {
        return CommonResult.success(seckillSkuRelationService.updateSeckillSkuRelation(seckillSkuRelationEntity));
    }
}
