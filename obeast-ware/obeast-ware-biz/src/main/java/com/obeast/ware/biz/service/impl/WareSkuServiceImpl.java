package com.obeast.ware.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.ware.biz.mapper.WareSkuMapper;
import com.obeast.ware.api.entity.WareSkuEntity;
import com.obeast.ware.biz.service.WareSkuService;



/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 商品库存
 */
@Service("WareSkuService")
public class WareSkuServiceImpl extends ServiceImpl<WareSkuMapper, WareSkuEntity> implements WareSkuService {

    @Override
    public IPage<WareSkuEntity> pageWareSkus(Page<WareSkuEntity> page) {
        LambdaQueryWrapper<WareSkuEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean saveWareSku(WareSkuEntity wareSkuEntity) {
        return this.save(wareSkuEntity);
    }

    @Override
    public Boolean removeWareSkuById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateWareSku(WareSkuEntity wareSkuEntity) {
        return this.updateById(wareSkuEntity);
    }
}
