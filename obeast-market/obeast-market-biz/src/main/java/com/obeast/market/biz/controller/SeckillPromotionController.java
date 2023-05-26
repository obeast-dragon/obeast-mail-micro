package com.obeast.market.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.market.api.entity.SeckillPromotionEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.biz.service.SeckillPromotionService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 秒杀活动
 */
@Tag(name = "秒杀活动接口")
@RestController
@RequestMapping("/seckillPromotion")
@RequiredArgsConstructor
public class SeckillPromotionController {

    private final SeckillPromotionService seckillPromotionService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<SeckillPromotionEntity>> page(
            Page<SeckillPromotionEntity> page
    ) {
        return CommonResult.success(seckillPromotionService.pageSeckillPromotions(page));
    }


    /**
     * 添加
     *
     * @param seckillPromotionEntity SeckillPromotionEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody SeckillPromotionEntity seckillPromotionEntity) {
        return CommonResult.success(seckillPromotionService.saveSeckillPromotion(seckillPromotionEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(seckillPromotionService.removeSeckillPromotionById(id));
    }

    /**
     * 编辑
     *
     * @param seckillPromotionEntity SeckillPromotionEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody SeckillPromotionEntity seckillPromotionEntity) {
        return CommonResult.success(seckillPromotionService.updateSeckillPromotion(seckillPromotionEntity));
    }
}
