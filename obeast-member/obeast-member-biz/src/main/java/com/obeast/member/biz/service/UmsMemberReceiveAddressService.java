package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.UmsMemberReceiveAddressEntity;


/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员收货地址
 */
public interface UmsMemberReceiveAddressService extends IService<UmsMemberReceiveAddressEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return UmsMemberReceiveAddressEntity
    */
    IPage<UmsMemberReceiveAddressEntity> pageUmsMemberReceiveAddresss (Page<UmsMemberReceiveAddressEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param umsMemberReceiveAddressEntity UmsMemberReceiveAddressEntity
     * @return java.lang.Boolean
     */
    Boolean saveUmsMemberReceiveAddress(UmsMemberReceiveAddressEntity umsMemberReceiveAddressEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeUmsMemberReceiveAddressById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param umsMemberReceiveAddressEntity UmsMemberReceiveAddressEntity
     * @return java.lang.Boolean
     */
    Boolean updateUmsMemberReceiveAddress(UmsMemberReceiveAddressEntity umsMemberReceiveAddressEntity);

}

