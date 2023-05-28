package com.obeast.order.biz.mapper;

import com.obeast.common.mybatis.base.BaseDao;
import com.obeast.order.api.entity.PaymentInfoEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 支付信息表
 */
@Mapper
public interface PaymentInfoMapper extends BaseDao<PaymentInfoEntity> {

}
