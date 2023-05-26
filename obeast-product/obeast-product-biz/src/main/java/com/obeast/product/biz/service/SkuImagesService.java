package com.obeast.product.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.product.api.entity.SkuImagesEntity;

import java.util.List;


/**
 * @author wxl
 * Date 2023-05-26 17:28:37
 * @version 1.0
 * Description: sku图片
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return SkuImagesEntity
    */
    IPage<SkuImagesEntity> pageSkuImages(Page<SkuImagesEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param skuImagesEntity SkuImagesEntity
     * @return java.lang.Boolean
     */
    Boolean saveSkuImages(SkuImagesEntity skuImagesEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeSkuImagesById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param skuImagesEntity SkuImagesEntity
     * @return java.lang.Boolean
     */
    Boolean updateSkuImages(SkuImagesEntity skuImagesEntity);


    /**
     * Description: 批处理保存
     * @author wxl
     * Date: 2023/5/27 0:33
     * @param skuImages skuImages
     */
    void saveBatchSkuImages(List<SkuImagesEntity> skuImages);
}

