package com.obeast.ware.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.ware.api.entity.PurchaseDetailEntity;


/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 采购单
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return PurchaseDetailEntity
    */
    IPage<PurchaseDetailEntity> pagePurchaseDetails (Page<PurchaseDetailEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param purchaseDetailEntity PurchaseDetailEntity
     * @return java.lang.Boolean
     */
    Boolean savePurchaseDetail(PurchaseDetailEntity purchaseDetailEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removePurchaseDetailById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param purchaseDetailEntity PurchaseDetailEntity
     * @return java.lang.Boolean
     */
    Boolean updatePurchaseDetail(PurchaseDetailEntity purchaseDetailEntity);

}

