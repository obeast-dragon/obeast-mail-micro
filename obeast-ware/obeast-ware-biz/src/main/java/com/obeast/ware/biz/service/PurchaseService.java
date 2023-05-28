package com.obeast.ware.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.ware.api.entity.PurchaseEntity;


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

}

