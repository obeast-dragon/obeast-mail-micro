package com.obeast.order.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.order.api.entity.PaymentInfoEntity;


/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 支付信息表
 */
public interface PaymentInfoService extends IService<PaymentInfoEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return PaymentInfoEntity
    */
    IPage<PaymentInfoEntity> pagePaymentInfos (Page<PaymentInfoEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param paymentInfoEntity PaymentInfoEntity
     * @return java.lang.Boolean
     */
    Boolean savePaymentInfo(PaymentInfoEntity paymentInfoEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removePaymentInfoById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param paymentInfoEntity PaymentInfoEntity
     * @return java.lang.Boolean
     */
    Boolean updatePaymentInfo(PaymentInfoEntity paymentInfoEntity);

}

