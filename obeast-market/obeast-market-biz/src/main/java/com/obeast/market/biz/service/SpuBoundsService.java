package com.obeast.market.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.api.entity.SpuBoundsEntity;


/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 商品spu积分设置
 */
public interface SpuBoundsService extends IService<SpuBoundsEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return SpuBoundsEntity
    */
    IPage<SpuBoundsEntity> pageSpuBounds(Page<SpuBoundsEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param spuBoundsEntity SpuBoundsEntity
     * @return java.lang.Boolean
     */
    Boolean saveSpuBounds(SpuBoundsEntity spuBoundsEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeSpuBoundsById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param spuBoundsEntity SpuBoundsEntity
     * @return java.lang.Boolean
     */
    Boolean updateSpuBounds(SpuBoundsEntity spuBoundsEntity);

}

