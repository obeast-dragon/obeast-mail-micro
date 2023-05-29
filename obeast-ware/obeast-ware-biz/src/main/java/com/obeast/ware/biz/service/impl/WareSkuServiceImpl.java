package com.obeast.ware.biz.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.obeast.common.core.base.CommonResult;
import com.obeast.ware.api.feign.RemoteSkuInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.ware.biz.mapper.WareSkuMapper;
import com.obeast.ware.api.entity.WareSkuEntity;
import com.obeast.ware.biz.service.WareSkuService;
import org.springframework.util.Assert;

import java.util.List;


/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 商品库存
 */
@Service("WareSkuService")
@RequiredArgsConstructor
public class WareSkuServiceImpl extends ServiceImpl<WareSkuMapper, WareSkuEntity> implements WareSkuService {

    private final RemoteSkuInfoService remoteSkuInfoService;

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
    public List<WareSkuEntity> listBySkuIdAndWareId(Long skuId, Long wareId) {
        LambdaQueryWrapper<WareSkuEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(WareSkuEntity::getSkuId, skuId);
        queryWrapper.eq(WareSkuEntity::getWareId, wareId);
        return this.list(queryWrapper);
    }

    @Override
    public void updateStock(Long skuId, Long wareId, Integer skuNum) {
        Assert.notNull(skuId, "商品Id不能为空");
        Assert.notNull(wareId, "仓库Id不能为空");
        Assert.notNull(skuNum, "库存数量不能为空");
        LambdaUpdateWrapper<WareSkuEntity> updateWrapper = Wrappers.lambdaUpdate();
        updateWrapper.eq(WareSkuEntity::getSkuId, skuId);
        updateWrapper.eq(WareSkuEntity::getWareId, wareId);
        updateWrapper.set(WareSkuEntity::getStock, skuNum);
        this.update(updateWrapper);
    }

    @Override
    public void addOrUpdateStock(Long skuId, Long wareId, Integer skuNum) {

        //如果没有库存就是新增操作
        List<WareSkuEntity> wareSkus = this.listBySkuIdAndWareId(skuId, wareId);
        if (wareSkus == null || wareSkus.size() == 0){
            WareSkuEntity wareSkuEntity = new WareSkuEntity();
            wareSkuEntity.setSkuId(skuId);
            wareSkuEntity.setWareId(wareId);
            wareSkuEntity.setStock(skuNum);
            wareSkuEntity.setStockLocked(0);
            //1、自己catch异常
            //TODO 还可以用什么办法让异常出现以后不回滚？高级
            try {
                CommonResult<?> skuInfoRes = remoteSkuInfoService.getInfoById(skuId);
                if (skuInfoRes.getSuccess()){
                    Object skuInfoObj = skuInfoRes.getData();
                    JSONObject skuInfo = JSONObject.parseObject(skuInfoObj.toString());
                    wareSkuEntity.setSkuName(skuInfo.getString("skuName"));
                }

            }catch (Exception e){
                System.err.println("还可以用什么办法让异常出现以后不回滚？高级");
            }
            this.save(wareSkuEntity);
        }else {
            this.updateStock(skuId, wareId, skuNum);
        }
    }

    @Override
    public Boolean updateWareSku(WareSkuEntity wareSkuEntity) {
        return this.updateById(wareSkuEntity);
    }
}
