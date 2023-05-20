package com.obeast.product.biz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.product.api.entity.BrandEntity;

/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 品牌
 */
public interface BrandService extends IService<BrandEntity> {

    /**
     * Description: 分页查询品牌
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param page page
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.obeast.product.api.entity.BrandEntity>
     */
    IPage<BrandEntity> pageBrands(Page<BrandEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param brandEntity brandEntity
     * @return java.lang.Boolean
     */
    Boolean saveBrand(BrandEntity brandEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeBrandById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param brandEntity brandEntity
     * @return java.lang.Boolean
     */
    Boolean updateBrand(BrandEntity brandEntity);
}

