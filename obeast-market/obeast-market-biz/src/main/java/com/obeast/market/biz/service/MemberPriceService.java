package com.obeast.market.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.market.api.entity.MemberPriceEntity;


/**
 * @author wxl
 * Date 2023-05-26 20:31:35
 * @version 1.0
 * Description: 商品会员价格
 */
public interface MemberPriceService extends IService<MemberPriceEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return MemberPriceEntity
    */
    IPage<MemberPriceEntity> pageMemberPrices (Page<MemberPriceEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param memberPriceEntity MemberPriceEntity
     * @return java.lang.Boolean
     */
    Boolean saveMemberPrice(MemberPriceEntity memberPriceEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeMemberPriceById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param memberPriceEntity MemberPriceEntity
     * @return java.lang.Boolean
     */
    Boolean updateMemberPrice(MemberPriceEntity memberPriceEntity);

}

