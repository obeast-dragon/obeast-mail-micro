package com.obeast.ware.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.ware.api.entity.PurchaseEntity;
import com.obeast.ware.api.vo.PurchaseDoneVo;
import com.obeast.ware.api.vo.PurchaseMergeVo;

import java.util.List;


/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 采购信息
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return PurchaseEntity
    */
    IPage<PurchaseEntity> pagePurchases (Page<PurchaseEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param purchaseEntity PurchaseEntity
     * @return java.lang.Boolean
     */
    Boolean savePurchase(PurchaseEntity purchaseEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removePurchaseById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param purchaseEntity PurchaseEntity
     * @return java.lang.Boolean
     */
    Boolean updatePurchase(PurchaseEntity purchaseEntity);

    /**
     * Description: 合并采购需求
     * @author wxl
     * Date: 2023/5/29 10:37
     * @param purchaseMergeVo  purchaseMergeVo
     */
    void purchaseMerge(PurchaseMergeVo purchaseMergeVo);

    /**
     * Description: 查询未领取的采购单
     * @author wxl
     * Date: 2023/5/29 12:50
     * @param page  page
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.obeast.ware.api.entity.PurchaseEntity>
     */
    IPage<PurchaseEntity> pageUnclaimedPurchases(Page<PurchaseEntity> page);


    /**
     * Description: 领取的采购单
     * @author wxl
     * Date: 2023/5/29 12:54
     * @param purchaseIds purchaseIds
     */
    void receivedPurchase(List<Long> purchaseIds);

    /**
     * Description: 完成的采购单
     * @author wxl
     * Date: 2023/5/29 13:03
     * @param purchaseDoneVo  purchaseDoneVo
     */
    void donePurchase(PurchaseDoneVo purchaseDoneVo);


    /**
     * Description: 查询所有未领取的采购单
     * @author wxl
     * Date: 2023/5/29 22:41
     * @return java.util.List<com.obeast.ware.api.entity.PurchaseEntity>
     */
    List<PurchaseEntity> listUnclaimedPurchases();
}

