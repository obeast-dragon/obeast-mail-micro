package com.obeast.product.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.product.api.entity.SpuImagesEntity;

import java.util.List;


/**
 * @author wxl
 * Date 2023-05-26 17:28:37
 * @version 1.0
 * Description: spu图片
 */
public interface SpuImagesService extends IService<SpuImagesEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return SpuImagesEntity
    */
    IPage<SpuImagesEntity> pageSpuImagess (Page<SpuImagesEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param spuImagesEntity SpuImagesEntity
     * @return java.lang.Boolean
     */
    Boolean saveSpuImages(SpuImagesEntity spuImagesEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeSpuImagesById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param spuImagesEntity SpuImagesEntity
     * @return java.lang.Boolean
     */
    Boolean updateSpuImages(SpuImagesEntity spuImagesEntity);

    void saveImages(Long id, List<String> goodsImgs);
}

