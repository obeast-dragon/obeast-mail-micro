package com.obeast.ware.biz.mapper;

import com.obeast.common.mybatis.base.BaseDao;
import com.obeast.ware.api.entity.WareSkuEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 商品库存
 */
@Mapper
public interface WareSkuMapper extends BaseDao<WareSkuEntity> {

}
