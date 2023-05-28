package com.obeast.order.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.order.api.entity.OrderReturnReasonEntity;


/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 退货原因
 */
public interface OrderReturnReasonService extends IService<OrderReturnReasonEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return OrderReturnReasonEntity
    */
    IPage<OrderReturnReasonEntity> pageOrderReturnReasons (Page<OrderReturnReasonEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param orderReturnReasonEntity OrderReturnReasonEntity
     * @return java.lang.Boolean
     */
    Boolean saveOrderReturnReason(OrderReturnReasonEntity orderReturnReasonEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeOrderReturnReasonById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param orderReturnReasonEntity OrderReturnReasonEntity
     * @return java.lang.Boolean
     */
    Boolean updateOrderReturnReason(OrderReturnReasonEntity orderReturnReasonEntity);

}

