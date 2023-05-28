package com.obeast.order.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.order.api.entity.RefundInfoEntity;


/**
 * @author wxl
 * Date 2023-05-29 00:46:41
 * @version 1.0
 * Description: 退款信息
 */
public interface RefundInfoService extends IService<RefundInfoEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return RefundInfoEntity
    */
    IPage<RefundInfoEntity> pageRefundInfos (Page<RefundInfoEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param refundInfoEntity RefundInfoEntity
     * @return java.lang.Boolean
     */
    Boolean saveRefundInfo(RefundInfoEntity refundInfoEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeRefundInfoById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param refundInfoEntity RefundInfoEntity
     * @return java.lang.Boolean
     */
    Boolean updateRefundInfo(RefundInfoEntity refundInfoEntity);

}

