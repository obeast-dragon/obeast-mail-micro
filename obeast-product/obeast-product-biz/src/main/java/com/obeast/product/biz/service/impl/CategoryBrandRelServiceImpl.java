package com.obeast.product.biz.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.product.biz.mapper.CategoryBrandRelMapper;
import com.obeast.product.api.entity.CategoryBrandRelEntity;
import com.obeast.product.biz.service.CategoryBrandRelService;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 品牌分类关联
 */
@Service("categoryBrandRelService")
public class CategoryBrandRelServiceImpl extends ServiceImpl<CategoryBrandRelMapper, CategoryBrandRelEntity> implements CategoryBrandRelService {


}
