package com.obeast.ware.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.ware.biz.mapper.WareOrderTaskMapper;
import com.obeast.ware.api.entity.WareOrderTaskEntity;
import com.obeast.ware.biz.service.WareOrderTaskService;



/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 库存工作单
 */
@Service("WareOrderTaskService")
public class WareOrderTaskServiceImpl extends ServiceImpl<WareOrderTaskMapper, WareOrderTaskEntity> implements WareOrderTaskService {

    @Override
    public IPage<WareOrderTaskEntity> pageWareOrderTasks(Page<WareOrderTaskEntity> page) {
        LambdaQueryWrapper<WareOrderTaskEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveWareOrderTask(WareOrderTaskEntity wareOrderTaskEntity) {
        return this.save(wareOrderTaskEntity);
    }

    @Override
    public Boolean removeWareOrderTaskById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateWareOrderTask(WareOrderTaskEntity wareOrderTaskEntity) {
        return this.updateById(wareOrderTaskEntity);
    }
}
