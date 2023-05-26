package com.obeast.market.biz.mapper;

import com.obeast.common.mybatis.base.BaseDao;
import com.obeast.market.api.entity.SeckillSessionEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 秒杀活动场次
 */
@Mapper
public interface SeckillSessionMapper extends BaseDao<SeckillSessionEntity> {

}
