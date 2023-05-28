package com.obeast.order.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.order.api.entity.MqMessageEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.order.biz.service.MqMessageService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 
 */
@Tag(name = "接口")
@RestController
@RequestMapping("/mqMessage")
@RequiredArgsConstructor
public class MqMessageController {

    private final MqMessageService mqMessageService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<MqMessageEntity>> page(
            Page<MqMessageEntity> page
    ) {
        return CommonResult.success(mqMessageService.pageMqMessages(page));
    }


    /**
     * 添加
     *
     * @param mqMessageEntity MqMessageEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody MqMessageEntity mqMessageEntity) {
        return CommonResult.success(mqMessageService.saveMqMessage(mqMessageEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(mqMessageService.removeMqMessageById(id));
    }

    /**
     * 编辑
     *
     * @param mqMessageEntity MqMessageEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody MqMessageEntity mqMessageEntity) {
        return CommonResult.success(mqMessageService.updateMqMessage(mqMessageEntity));
    }
}
