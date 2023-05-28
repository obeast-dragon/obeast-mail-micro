package com.obeast.ware.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.ware.biz.mapper.PurchaseMapper;
import com.obeast.ware.api.entity.PurchaseEntity;
import com.obeast.ware.biz.service.PurchaseService;



/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 采购信息
 */
@Service("PurchaseService")
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, PurchaseEntity> implements PurchaseService {

    @Override
    public IPage<PurchaseEntity> pagePurchases(Page<PurchaseEntity> page) {
        LambdaQueryWrapper<PurchaseEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean savePurchase(PurchaseEntity purchaseEntity) {
        return this.save(purchaseEntity);
    }

    @Override
    public Boolean removePurchaseById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updatePurchase(PurchaseEntity purchaseEntity) {
        return this.updateById(purchaseEntity);
    }
}
