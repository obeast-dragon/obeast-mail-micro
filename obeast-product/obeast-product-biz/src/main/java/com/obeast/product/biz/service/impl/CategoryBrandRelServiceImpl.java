package com.obeast.product.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.product.api.entity.CategoryBrandRelEntity;
import com.obeast.product.api.vo.CategoryBrandRelVo;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.product.biz.mapper.CategoryBrandRelMapper;
import com.obeast.product.biz.service.CategoryBrandRelService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 品牌分类关联
 */
@Service("categoryBrandRelService")
public class CategoryBrandRelServiceImpl extends ServiceImpl<CategoryBrandRelMapper, CategoryBrandRelEntity> implements CategoryBrandRelService {

    @Override
    public Boolean saveCategoryBrandRel(CategoryBrandRelEntity categoryBrandRelEntity) {
        return this.save(categoryBrandRelEntity);
    }

    @Override
    public Boolean removeCategoryBrandRelById(Long id) {
        return this.removeById(id);
    }

    @Override
    public List<CategoryBrandRelEntity> listRelsByCategoryId(Long categoryId) {
        Assert.notNull(categoryId, "商品分类Id不能为空");
        LambdaQueryWrapper<CategoryBrandRelEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(CategoryBrandRelEntity::getCatelogId, categoryId);
        return this.list(queryWrapper);
    }

    @Override
    public List<CategoryBrandRelEntity> listRelsByBrandId(Long brandId) {
        Assert.notNull(brandId, "品牌Id不能为空");
        LambdaQueryWrapper<CategoryBrandRelEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(CategoryBrandRelEntity::getBrandId, brandId);
        return this.list(queryWrapper);
    }

    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean updateCategoryBrandRel(CategoryBrandRelVo categoryBrandRelVo) {
        LambdaQueryWrapper<CategoryBrandRelEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(CategoryBrandRelEntity::getBrandId, categoryBrandRelVo.getBrandId());
        this.remove(queryWrapper);
        if (categoryBrandRelVo.getCategoryBrandRels().isEmpty()) {
            return true;
        } else {
            return this.saveBatch(categoryBrandRelVo.getCategoryBrandRels());
        }

    }
}
