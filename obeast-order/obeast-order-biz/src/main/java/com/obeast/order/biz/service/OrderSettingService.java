package com.obeast.order.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.order.api.entity.OrderSettingEntity;


/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 订单配置信息
 */
public interface OrderSettingService extends IService<OrderSettingEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return OrderSettingEntity
    */
    IPage<OrderSettingEntity> pageOrderSettings (Page<OrderSettingEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param orderSettingEntity OrderSettingEntity
     * @return java.lang.Boolean
     */
    Boolean saveOrderSetting(OrderSettingEntity orderSettingEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeOrderSettingById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param orderSettingEntity OrderSettingEntity
     * @return java.lang.Boolean
     */
    Boolean updateOrderSetting(OrderSettingEntity orderSettingEntity);

}

