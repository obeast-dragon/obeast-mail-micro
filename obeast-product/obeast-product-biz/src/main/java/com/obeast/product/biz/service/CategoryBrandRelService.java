package com.obeast.product.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.product.api.entity.CategoryBrandRelEntity;
import com.obeast.product.api.vo.CategoryBrandRelVo;

import java.util.List;

/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 品牌分类关联
 */
public interface CategoryBrandRelService extends IService<CategoryBrandRelEntity> {

    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param categoryBrandRelEntity categoryBrandRelEntity
     * @return java.lang.Boolean
     */
    Boolean saveCategoryBrandRel(CategoryBrandRelEntity categoryBrandRelEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeCategoryBrandRelById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param categoryBrandRelVo categoryBrandRelVo
     * @return java.lang.Boolean
     */
    Boolean updateCategoryBrandRel(CategoryBrandRelVo categoryBrandRelVo);

    /**
     * Description: 查询关系
     * @author wxl
     * Date: 2023/5/22 23:54
     * @param brandId brandId
     * @return java.util.List<com.obeast.product.api.entity.CategoryBrandRelEntity>
     */
    List<CategoryBrandRelEntity> listRelsByBrandId(Long brandId);
}

