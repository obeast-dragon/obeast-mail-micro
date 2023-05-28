package com.obeast.ware.biz.mapper;

import com.obeast.common.mybatis.base.BaseDao;
import com.obeast.ware.api.entity.PurchaseEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 采购信息
 */
@Mapper
public interface PurchaseMapper extends BaseDao<PurchaseEntity> {

}
