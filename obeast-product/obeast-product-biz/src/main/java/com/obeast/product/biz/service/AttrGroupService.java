package com.obeast.product.biz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.product.api.entity.AttrGroupEntity;
import com.obeast.product.api.entity.AttrGroupEntity;

import java.util.List;

/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 属性分组
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {
    /**
     * Description: 分页查询品牌
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param page page
     * @return AttrGroupEntity
     */
    IPage<AttrGroupEntity> pageAttrGroups(Page<AttrGroupEntity> page, Long attrGroupId, String attrGroupName);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param attrGroupEntity attrGroupEntity
     * @return java.lang.Boolean
     */
    Boolean saveAttrGroup(AttrGroupEntity attrGroupEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeAttrGroupById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param attrGroupEntity attrGroupEntity
     * @return java.lang.Boolean
     */
    Boolean updateAttrGroup(AttrGroupEntity attrGroupEntity);

    
}

