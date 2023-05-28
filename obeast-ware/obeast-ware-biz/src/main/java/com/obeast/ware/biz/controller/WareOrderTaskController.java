package com.obeast.ware.biz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.obeast.ware.api.entity.WareOrderTaskEntity;


import com.obeast.common.core.base.CommonResult;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.ware.biz.service.WareOrderTaskService;

import javax.validation.Valid;



/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 库存工作单
 */
@Tag(name = "库存工作单接口")
@RestController
@RequestMapping("/wareOrderTask")
@RequiredArgsConstructor
public class WareOrderTaskController {

    private final WareOrderTaskService wareOrderTaskService;

    /**
      * 分页查询
      *
      * @param page   分页对象
      */
    @GetMapping("/page")
    public CommonResult<IPage<WareOrderTaskEntity>> page(
            Page<WareOrderTaskEntity> page
    ) {
        return CommonResult.success(wareOrderTaskService.pageWareOrderTasks(page));
    }


    /**
     * 添加
     *
     * @param wareOrderTaskEntity WareOrderTaskEntity
     * @return success/false
     */
    @PostMapping("/add")
    public CommonResult<Boolean> save(@Valid @RequestBody WareOrderTaskEntity wareOrderTaskEntity) {
        return CommonResult.success(wareOrderTaskService.saveWareOrderTask(wareOrderTaskEntity));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id:\\d+}")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(wareOrderTaskService.removeWareOrderTaskById(id));
    }

    /**
     * 编辑
     *
     * @param wareOrderTaskEntity WareOrderTaskEntity
     * @return success/false
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@Valid @RequestBody WareOrderTaskEntity wareOrderTaskEntity) {
        return CommonResult.success(wareOrderTaskService.updateWareOrderTask(wareOrderTaskEntity));
    }
}
