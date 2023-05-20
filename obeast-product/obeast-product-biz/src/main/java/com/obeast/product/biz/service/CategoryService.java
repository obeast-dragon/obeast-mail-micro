package com.obeast.product.biz.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.product.api.entity.CategoryEntity;

import java.util.List;

/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 商品三级分类
 */
public interface CategoryService extends IService<CategoryEntity> {

    /**
     * Description: 查询商品分类树
     * @author wxl
     * Date: 2023/5/20 20:03
     * @param parentId parentId
     * @param name name
     * @return java.util.List<cn.hutool.core.lang.tree.Tree<java.lang.Long>>
     */
    List<Tree<Long>> treeCategory(Long parentId, String name);

    /**
     * Description: 删除 Category by Id
     * @author wxl
     * Date: 2023/5/20 21:17
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeCategoryById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 21:18
     * @param categoryEntity categoryEntity
     * @return java.lang.Boolean
     */
    Boolean updateCategory(CategoryEntity categoryEntity);

    /**
     * Description: 保存
     * @author wxl
     * Date: 2023/5/20 21:19
     * @param categoryEntity  categoryEntity
     * @return java.lang.Boolean
     */
    Boolean saveCategory(CategoryEntity categoryEntity);
}

