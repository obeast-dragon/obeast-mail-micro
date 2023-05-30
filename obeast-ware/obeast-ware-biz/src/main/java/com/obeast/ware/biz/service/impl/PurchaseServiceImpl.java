package com.obeast.ware.biz.service.impl;

import com.obeast.ware.api.constant.WareConstant;
import com.obeast.ware.api.entity.PurchaseDetailEntity;
import com.obeast.ware.api.vo.PurchaseDoneItemVo;
import com.obeast.ware.api.vo.PurchaseDoneVo;
import com.obeast.ware.api.vo.PurchaseMergeVo;
import com.obeast.ware.biz.service.PurchaseDetailService;
import com.obeast.ware.biz.service.WareSkuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.ware.biz.mapper.PurchaseMapper;
import com.obeast.ware.api.entity.PurchaseEntity;
import com.obeast.ware.biz.service.PurchaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 采购信息
 */
@Service("PurchaseService")
@RequiredArgsConstructor
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, PurchaseEntity> implements PurchaseService {


    private  final PurchaseDetailService purchaseDetailService;

    private final WareSkuService wareSkuService;


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

    @Override
    public List<PurchaseEntity> listUnclaimedPurchases() {
        LambdaQueryWrapper<PurchaseEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper
                .eq(PurchaseEntity::getStatus, WareConstant.PurchaseStatusEnum.CREATED.getCode())
                .or(item -> item.eq(PurchaseEntity::getStatus,
                        WareConstant.PurchaseStatusEnum.ASSIGNED.getCode()));
        return this.list(queryWrapper);
    }

    @Override
    public void donePurchase(PurchaseDoneVo purchaseDoneVo) {
        Long id = purchaseDoneVo.getPurchaseId();

        //采购项的状态
        boolean flag = true;
        List<PurchaseDoneItemVo> items = purchaseDoneVo.getItems();

        List<PurchaseDetailEntity> updates = new ArrayList<>();
        for (PurchaseDoneItemVo item : items) {
            PurchaseDetailEntity purchaseDetailEntity = new PurchaseDetailEntity();
            if (item.getStatus() == WareConstant.PurchaseDetailStatusEnum.PURCHASE_FAIL.getCode()){
                flag = false;
                purchaseDetailEntity.setStatus(item.getStatus());
            }else {

                purchaseDetailEntity.setStatus(WareConstant.PurchaseDetailStatusEnum.FINISH.getCode());
                //3、将成功采购的进行入库
                PurchaseDetailEntity entity = purchaseDetailService.getById(item.getItemId());
                wareSkuService.addOrUpdateStock(entity.getSkuId(), entity.getWareId(), entity.getSkuNum());
            }
            purchaseDetailEntity.setId(item.getItemId());
            updates.add(purchaseDetailEntity);
        }

        purchaseDetailService.updateBatchById(updates);

        //改变订单状态
        PurchaseEntity purchaseEntity = new PurchaseEntity();
        purchaseEntity.setId(id);
        purchaseEntity.setStatus(flag?WareConstant.PurchaseStatusEnum.FINISH.getCode():WareConstant.PurchaseStatusEnum.HAS_ERROR.getCode());
        this.updateById(purchaseEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void receivedPurchase(List<Long> purchaseIds) {
        //1、确定状态0，1新建或者以分配 的id
        List<PurchaseEntity> collect = purchaseIds
                .stream()
                .map(this::getById)
                .filter(it ->
                        it.getStatus() == WareConstant.PurchaseStatusEnum.CREATED.getCode() ||
                it.getStatus() == WareConstant.PurchaseStatusEnum.ASSIGNED.getCode())
                .peek(item -> item.setStatus(WareConstant.PurchaseStatusEnum.RECEIVED.getCode()))
                .toList();
        //2、改变采购单的状态
        this.updateBatchById(collect);

        //3、改变采购项的状态
        collect.forEach(item -> {
            List<PurchaseDetailEntity> entities = purchaseDetailService.listDetailByPurchaseId(item.getId());
            List<PurchaseDetailEntity> purchaseDetailCollect = entities.stream().map(entity -> {
                PurchaseDetailEntity purchaseDetailEntity = new PurchaseDetailEntity();
                purchaseDetailEntity.setId(entity.getId());
                purchaseDetailEntity.setStatus(WareConstant.PurchaseDetailStatusEnum.BUYING.getCode());
                return purchaseDetailEntity;
            }).collect(Collectors.toList());
            purchaseDetailService.updateBatchById(purchaseDetailCollect);
        });
    }

    @Override
    public IPage<PurchaseEntity> pageUnclaimedPurchases(Page<PurchaseEntity> page) {
        LambdaQueryWrapper<PurchaseEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper
                .eq(PurchaseEntity::getStatus, WareConstant.PurchaseStatusEnum.CREATED.getCode())
                .or()
                .eq(PurchaseEntity::getStatus, WareConstant.PurchaseStatusEnum.ASSIGNED.getCode());
        return this.page(page, queryWrapper);
    }

    @Override
    public void purchaseMerge(PurchaseMergeVo purchaseMergeVo) {
        Long purchaseId = purchaseMergeVo.getPurchaseId();
        if (purchaseId == null) {
            PurchaseEntity purchaseEntity = new PurchaseEntity();
            purchaseEntity.setStatus(WareConstant.PurchaseStatusEnum.CREATED.getCode());
            this.save(purchaseEntity);
            purchaseId = purchaseEntity.getId();
        }
        Long finalPurchaseId = purchaseId;
        List<Long> items = purchaseMergeVo.getItems();
        if (items != null && items.size() > 0) {
            List<PurchaseDetailEntity> collect = items.stream().map(id -> {
//            '状态[0新建，1已分配，2正在采购，3已完成，4采购失败]'
                PurchaseDetailEntity purchaseDetailEntity = new PurchaseDetailEntity();
                purchaseDetailEntity.setId(id);
                purchaseDetailEntity.setPurchaseId(finalPurchaseId);
                purchaseDetailEntity.setStatus(WareConstant.PurchaseDetailStatusEnum.ASSIGNED.getCode());
                return purchaseDetailEntity;
            }).filter(it -> it.getStatus() == WareConstant.PurchaseStatusEnum.CREATED.getCode() ||
                    it.getStatus() == WareConstant.PurchaseStatusEnum.ASSIGNED.getCode()).collect(Collectors.toList());
            //根据主键批量更新
            purchaseDetailService.updateBatchById(collect);
            PurchaseEntity purchaseEntity = new PurchaseEntity();
            purchaseEntity.setId(purchaseId);
            this.updateById(purchaseEntity);
        }
    }
}
