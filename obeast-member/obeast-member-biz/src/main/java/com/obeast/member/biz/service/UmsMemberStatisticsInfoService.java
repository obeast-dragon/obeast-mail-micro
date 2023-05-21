package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.UmsMemberStatisticsInfoEntity;


/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员统计信息
 */
public interface UmsMemberStatisticsInfoService extends IService<UmsMemberStatisticsInfoEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return UmsMemberStatisticsInfoEntity
    */
    IPage<UmsMemberStatisticsInfoEntity> pageUmsMemberStatisticsInfos (Page<UmsMemberStatisticsInfoEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param umsMemberStatisticsInfoEntity UmsMemberStatisticsInfoEntity
     * @return java.lang.Boolean
     */
    Boolean saveUmsMemberStatisticsInfo(UmsMemberStatisticsInfoEntity umsMemberStatisticsInfoEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeUmsMemberStatisticsInfoById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param umsMemberStatisticsInfoEntity UmsMemberStatisticsInfoEntity
     * @return java.lang.Boolean
     */
    Boolean updateUmsMemberStatisticsInfo(UmsMemberStatisticsInfoEntity umsMemberStatisticsInfoEntity);

}

