package com.obeast.order.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.order.api.entity.OrderItemEntity;


/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 订单项信息
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return OrderItemEntity
    */
    IPage<OrderItemEntity> pageOrderItems (Page<OrderItemEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param orderItemEntity OrderItemEntity
     * @return java.lang.Boolean
     */
    Boolean saveOrderItem(OrderItemEntity orderItemEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeOrderItemById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param orderItemEntity OrderItemEntity
     * @return java.lang.Boolean
     */
    Boolean updateOrderItem(OrderItemEntity orderItemEntity);

}

