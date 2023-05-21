package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.MemberCollectSpuEntity;


/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员收藏的商品
 */
public interface MemberCollectSpuService extends IService<MemberCollectSpuEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return MemberCollectSpuEntity
    */
    IPage<MemberCollectSpuEntity> pageMemberCollectSpus (Page<MemberCollectSpuEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param memberCollectSpuEntity MemberCollectSpuEntity
     * @return java.lang.Boolean
     */
    Boolean saveMemberCollectSpu(MemberCollectSpuEntity memberCollectSpuEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeMemberCollectSpuById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param memberCollectSpuEntity MemberCollectSpuEntity
     * @return java.lang.Boolean
     */
    Boolean updateMemberCollectSpu(MemberCollectSpuEntity memberCollectSpuEntity);

}

