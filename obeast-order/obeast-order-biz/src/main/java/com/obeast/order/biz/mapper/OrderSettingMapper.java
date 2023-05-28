package com.obeast.order.biz.mapper;

import com.obeast.common.mybatis.base.BaseDao;
import com.obeast.order.api.entity.OrderSettingEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 订单配置信息
 */
@Mapper
public interface OrderSettingMapper extends BaseDao<OrderSettingEntity> {

}
