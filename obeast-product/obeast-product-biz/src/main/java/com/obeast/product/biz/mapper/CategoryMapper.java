package com.obeast.product.biz.mapper;

import com.obeast.common.mybatis.base.BaseDao;
import com.obeast.product.api.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 商品三级分类
 */
@Mapper
public interface CategoryMapper extends BaseDao<CategoryEntity> {

}
