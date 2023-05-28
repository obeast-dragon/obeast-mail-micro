package com.obeast.ware.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.ware.biz.mapper.PurchaseDetailMapper;
import com.obeast.ware.api.entity.PurchaseDetailEntity;
import com.obeast.ware.biz.service.PurchaseDetailService;



/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 采购单
 */
@Service("PurchaseDetailService")
public class PurchaseDetailServiceImpl extends ServiceImpl<PurchaseDetailMapper, PurchaseDetailEntity> implements PurchaseDetailService {

    @Override
    public IPage<PurchaseDetailEntity> pagePurchaseDetails(Page<PurchaseDetailEntity> page) {
        LambdaQueryWrapper<PurchaseDetailEntity> queryWrapper = Wrappers.lambdaQuery();
        return this.page(page, queryWrapper);
    }

    @Override
    public Boolean savePurchaseDetail(PurchaseDetailEntity purchaseDetailEntity) {
        return this.save(purchaseDetailEntity);
    }

    @Override
    public Boolean removePurchaseDetailById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updatePurchaseDetail(PurchaseDetailEntity purchaseDetailEntity) {
        return this.updateById(purchaseDetailEntity);
    }
}
