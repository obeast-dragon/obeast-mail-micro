package com.obeast.order.biz.mapper;

import com.obeast.common.mybatis.base.BaseDao;
import com.obeast.order.api.entity.RefundInfoEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 退款信息
 */
@Mapper
public interface RefundInfoMapper extends BaseDao<RefundInfoEntity> {

}
