package com.obeast.product.api.vo;

import com.obeast.product.api.entity.CategoryBrandRelEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author wxl
 * Date 2023-05-19 01:37:23
 * @version 1.0
 * Description: 品牌分类关联Vo
 */
@Data
public class CategoryBrandRelVo {

	@NotNull(message = "品牌Id不能为空")
	private Long brandId;

	private List<CategoryBrandRelEntity> categoryBrandRels;
}
