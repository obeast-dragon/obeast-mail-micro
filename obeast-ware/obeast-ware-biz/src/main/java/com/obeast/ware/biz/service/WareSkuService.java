package com.obeast.ware.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.ware.api.entity.WareSkuEntity;


/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 商品库存
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return WareSkuEntity
    */
    IPage<WareSkuEntity> pageWareSkus (Page<WareSkuEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param wareSkuEntity WareSkuEntity
     * @return java.lang.Boolean
     */
    Boolean saveWareSku(WareSkuEntity wareSkuEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeWareSkuById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param wareSkuEntity WareSkuEntity
     * @return java.lang.Boolean
     */
    Boolean updateWareSku(WareSkuEntity wareSkuEntity);

}

