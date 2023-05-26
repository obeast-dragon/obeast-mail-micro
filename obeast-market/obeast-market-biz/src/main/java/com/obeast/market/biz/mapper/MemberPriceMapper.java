package com.obeast.market.biz.mapper;

import com.obeast.common.mybatis.base.BaseDao;
import com.obeast.market.api.entity.MemberPriceEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 商品会员价格
 */
@Mapper
public interface MemberPriceMapper extends BaseDao<MemberPriceEntity> {

}
