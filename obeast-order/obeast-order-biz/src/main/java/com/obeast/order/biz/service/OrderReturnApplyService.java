package com.obeast.order.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.order.api.entity.OrderReturnApplyEntity;


/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 订单退货申请
 */
public interface OrderReturnApplyService extends IService<OrderReturnApplyEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return OrderReturnApplyEntity
    */
    IPage<OrderReturnApplyEntity> pageOrderReturnApplys (Page<OrderReturnApplyEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param orderReturnApplyEntity OrderReturnApplyEntity
     * @return java.lang.Boolean
     */
    Boolean saveOrderReturnApply(OrderReturnApplyEntity orderReturnApplyEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeOrderReturnApplyById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param orderReturnApplyEntity OrderReturnApplyEntity
     * @return java.lang.Boolean
     */
    Boolean updateOrderReturnApply(OrderReturnApplyEntity orderReturnApplyEntity);

}

