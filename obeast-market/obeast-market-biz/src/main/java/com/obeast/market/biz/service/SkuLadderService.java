package com.obeast.market.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.api.entity.SkuLadderEntity;


/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 商品阶梯价格
 */
public interface SkuLadderService extends IService<SkuLadderEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return SkuLadderEntity
    */
    IPage<SkuLadderEntity> pageSkuLadders (Page<SkuLadderEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param skuLadderEntity SkuLadderEntity
     * @return java.lang.Boolean
     */
    Boolean saveSkuLadder(SkuLadderEntity skuLadderEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeSkuLadderById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param skuLadderEntity SkuLadderEntity
     * @return java.lang.Boolean
     */
    Boolean updateSkuLadder(SkuLadderEntity skuLadderEntity);

}

