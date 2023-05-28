package com.obeast.order.biz.mapper;

import com.obeast.common.mybatis.base.BaseDao;
import com.obeast.order.api.entity.MqMessageEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 
 */
@Mapper
public interface MqMessageMapper extends BaseDao<MqMessageEntity> {

}
