package com.obeast.product.biz.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.common.core.constant.CommonConstants;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.product.biz.mapper.CategoryMapper;
import com.obeast.product.api.entity.CategoryEntity;
import com.obeast.product.biz.service.CategoryService;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 商品三级分类
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryEntity> implements CategoryService {
    @Override
    public Boolean removeCategoryById(Long id) {
        return this.removeById(id);
    }

    @Override
    public Boolean updateCategory(CategoryEntity categoryEntity) {
        return this.updateById(categoryEntity);
    }

    @Override
    public Boolean saveCategory(CategoryEntity categoryEntity) {
        return this.save(categoryEntity);
    }

    @Override
    public List<Tree<Long>> treeCategory(Long parentId, String name) {
        Long parent = parentId == null ? CommonConstants.MENU_TREE_ROOT_ID : parentId;
        LambdaQueryWrapper<CategoryEntity> queryWrapper = Wrappers.lambdaQuery();
        if (StrUtil.isNotBlank(name)){
            queryWrapper.eq(CategoryEntity::getName, name);
        }
        queryWrapper.orderByAsc(CategoryEntity::getSort);
        List<TreeNode<Long>> collect = baseMapper
                .selectList(queryWrapper)
                .stream()
                .map(getNodeFunction())
                .collect(Collectors.toList());
        return TreeUtil.build(collect, parent);
    }

    @NotNull
    private Function<CategoryEntity, TreeNode<Long>> getNodeFunction() {
        return menu -> {
            TreeNode<Long> node = new TreeNode<>();
            node.setId(menu.getCatId());
            node.setName(menu.getName());
            node.setParentId(menu.getParentId());
            node.setWeight(menu.getSort());
            // 扩展属性
            Map<String, Object> extra = new HashMap<>();
            extra.put("name", menu.getName());
            extra.put("catLevel", menu.getCatLevel());
            extra.put("showStatus", menu.getShowStatus());
            extra.put("icon", menu.getIcon());
            extra.put("sort", menu.getSort());
            extra.put("productUnit", menu.getProductUnit());
            extra.put("productCount", menu.getProductCount());
            node.setExtra(extra);
            return node;
        };
    }
}
