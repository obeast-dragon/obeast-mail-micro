package com.obeast.product.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.product.api.dto.AttrAttrGroupDTO;
import com.obeast.product.api.entity.AttrAttrGroupRelEntity;
import com.obeast.product.api.entity.AttrEntity;
import com.obeast.product.api.vo.AttrAttrGroupVo;

import java.util.List;

/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 属性&属性分组关联
 */
public interface AttrAttrGroupRelService extends IService<AttrAttrGroupRelEntity> {


    /**
     * Description: 获取属性分组的关联的所有属性
     * @author wxl
     * Date: 2023/5/23 14:20
     * @param attrGroupId  attrGroupId
     * @return AttrAttrGroupDTO
     */
    List<AttrAttrGroupDTO> listAttrByAttrGroupId(Long attrGroupId);


    /**
     * Description: 获取属性分组的关联的所有属性Id
     * @author wxl
     * Date: 2023/5/23 14:19
     * @param attrGroupId  attrGroupId
     * @return AttrAttrGroupRelEntity
     */
    List<AttrAttrGroupRelEntity> listAttrIdByAttrGroupId(Long attrGroupId);

    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param attrAttrGroupVo attrAttrGroupVo
     * @return java.lang.Boolean
     */
    Boolean updateCategoryBrandRel(AttrAttrGroupVo attrAttrGroupVo);


}

