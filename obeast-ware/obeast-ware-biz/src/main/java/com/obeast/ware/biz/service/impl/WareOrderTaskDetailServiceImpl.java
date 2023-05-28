package com.obeast.ware.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.ware.biz.mapper.WareOrderTaskDetailMapper;
import com.obeast.ware.api.entity.WareOrderTaskDetailEntity;
import com.obeast.ware.biz.service.WareOrderTaskDetailService;



/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 库存工作单
 */
@Service("WareOrderTaskDetailService")
public class WareOrderTaskDetailServiceImpl extends ServiceImpl<WareOrderTaskDetailMapper, WareOrderTaskDetailEntity> implements WareOrderTaskDetailService {

    @Override
    public IPage<WareOrderTaskDetailEntity> pageWareOrderTaskDetails(Page<WareOrderTaskDetailEntity> page) {
        LambdaQueryWrapper<WareOrderTaskDetailEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveWareOrderTaskDetail(WareOrderTaskDetailEntity wareOrderTaskDetailEntity) {
        return this.save(wareOrderTaskDetailEntity);
    }

    @Override
    public Boolean removeWareOrderTaskDetailById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateWareOrderTaskDetail(WareOrderTaskDetailEntity wareOrderTaskDetailEntity) {
        return this.updateById(wareOrderTaskDetailEntity);
    }
}
