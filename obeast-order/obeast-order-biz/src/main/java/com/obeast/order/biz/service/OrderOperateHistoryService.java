package com.obeast.order.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.order.api.entity.OrderOperateHistoryEntity;


/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 订单操作历史记录
 */
public interface OrderOperateHistoryService extends IService<OrderOperateHistoryEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return OrderOperateHistoryEntity
    */
    IPage<OrderOperateHistoryEntity> pageOrderOperateHistorys (Page<OrderOperateHistoryEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param orderOperateHistoryEntity OrderOperateHistoryEntity
     * @return java.lang.Boolean
     */
    Boolean saveOrderOperateHistory(OrderOperateHistoryEntity orderOperateHistoryEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeOrderOperateHistoryById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param orderOperateHistoryEntity OrderOperateHistoryEntity
     * @return java.lang.Boolean
     */
    Boolean updateOrderOperateHistory(OrderOperateHistoryEntity orderOperateHistoryEntity);

}

