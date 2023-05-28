package com.obeast.ware.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.ware.api.entity.WareOrderTaskDetailEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.ware.biz.service.WareOrderTaskDetailService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 库存工作单
 */
@Tag(name = "库存工作单接口")
@RestController
@RequestMapping("/wareOrderTaskDetail")
@RequiredArgsConstructor
public class WareOrderTaskDetailController {

    private final WareOrderTaskDetailService wareOrderTaskDetailService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<WareOrderTaskDetailEntity>> page(
            Page<WareOrderTaskDetailEntity> page
    ) {
        return CommonResult.success(wareOrderTaskDetailService.pageWareOrderTaskDetails(page));
    }


    /**
     * 添加
     *
     * @param wareOrderTaskDetailEntity WareOrderTaskDetailEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody WareOrderTaskDetailEntity wareOrderTaskDetailEntity) {
        return CommonResult.success(wareOrderTaskDetailService.saveWareOrderTaskDetail(wareOrderTaskDetailEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(wareOrderTaskDetailService.removeWareOrderTaskDetailById(id));
    }

    /**
     * 编辑
     *
     * @param wareOrderTaskDetailEntity WareOrderTaskDetailEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody WareOrderTaskDetailEntity wareOrderTaskDetailEntity) {
        return CommonResult.success(wareOrderTaskDetailService.updateWareOrderTaskDetail(wareOrderTaskDetailEntity));
    }
}
