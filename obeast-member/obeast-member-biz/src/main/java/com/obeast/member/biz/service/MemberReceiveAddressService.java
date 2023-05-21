package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.MemberReceiveAddressEntity;


/**
 * @author wxl
 * Date 2023-05-21 21:44:04
 * @version 1.0
 * Description: 会员收货地址
 */
public interface MemberReceiveAddressService extends IService<MemberReceiveAddressEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return MemberReceiveAddressEntity
    */
    IPage<MemberReceiveAddressEntity> pageMemberReceiveAddresss (Page<MemberReceiveAddressEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param memberReceiveAddressEntity MemberReceiveAddressEntity
     * @return java.lang.Boolean
     */
    Boolean saveMemberReceiveAddress(MemberReceiveAddressEntity memberReceiveAddressEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeMemberReceiveAddressById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param memberReceiveAddressEntity MemberReceiveAddressEntity
     * @return java.lang.Boolean
     */
    Boolean updateMemberReceiveAddress(MemberReceiveAddressEntity memberReceiveAddressEntity);

}

