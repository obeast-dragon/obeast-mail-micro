package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.UmsMemberLevelEntity;


/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 会员等级
 */
public interface UmsMemberLevelService extends IService<UmsMemberLevelEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return UmsMemberLevelEntity
    */
    IPage<UmsMemberLevelEntity> pageUmsMemberLevels (Page<UmsMemberLevelEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param umsMemberLevelEntity UmsMemberLevelEntity
     * @return java.lang.Boolean
     */
    Boolean saveUmsMemberLevel(UmsMemberLevelEntity umsMemberLevelEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeUmsMemberLevelById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param umsMemberLevelEntity UmsMemberLevelEntity
     * @return java.lang.Boolean
     */
    Boolean updateUmsMemberLevel(UmsMemberLevelEntity umsMemberLevelEntity);

}

