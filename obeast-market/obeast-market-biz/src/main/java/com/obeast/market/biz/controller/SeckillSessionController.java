package com.obeast.market.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.market.api.entity.SeckillSessionEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.biz.service.SeckillSessionService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 秒杀活动场次
 */
@Tag(name = "秒杀活动场次接口")
@RestController
@RequestMapping("/seckillSession")
@RequiredArgsConstructor
public class SeckillSessionController {

    private final SeckillSessionService seckillSessionService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<SeckillSessionEntity>> page(
            Page<SeckillSessionEntity> page
    ) {
        return CommonResult.success(seckillSessionService.pageSeckillSessions(page));
    }


    /**
     * 添加
     *
     * @param seckillSessionEntity SeckillSessionEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody SeckillSessionEntity seckillSessionEntity) {
        return CommonResult.success(seckillSessionService.saveSeckillSession(seckillSessionEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(seckillSessionService.removeSeckillSessionById(id));
    }

    /**
     * 编辑
     *
     * @param seckillSessionEntity SeckillSessionEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody SeckillSessionEntity seckillSessionEntity) {
        return CommonResult.success(seckillSessionService.updateSeckillSession(seckillSessionEntity));
    }
}
