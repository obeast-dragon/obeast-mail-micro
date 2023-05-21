package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.UmsMemberCollectSpuEntity;


/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员收藏的商品
 */
public interface UmsMemberCollectSpuService extends IService<UmsMemberCollectSpuEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return UmsMemberCollectSpuEntity
    */
    IPage<UmsMemberCollectSpuEntity> pageUmsMemberCollectSpus (Page<UmsMemberCollectSpuEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param umsMemberCollectSpuEntity UmsMemberCollectSpuEntity
     * @return java.lang.Boolean
     */
    Boolean saveUmsMemberCollectSpu(UmsMemberCollectSpuEntity umsMemberCollectSpuEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeUmsMemberCollectSpuById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param umsMemberCollectSpuEntity UmsMemberCollectSpuEntity
     * @return java.lang.Boolean
     */
    Boolean updateUmsMemberCollectSpu(UmsMemberCollectSpuEntity umsMemberCollectSpuEntity);

}

