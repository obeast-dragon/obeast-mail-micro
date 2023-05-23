package com.obeast.product.api.vo;

import com.obeast.product.api.entity.AttrAttrGroupRelEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author wxl
 * Date 2023/5/23 14:41
 * @version 1.0
 * Description:
 */
@Data
public class AttrAttrGroupVo {

    @NotNull(message = "属性分组Id不能为空")
    private  Long attrGroupId;

    private Set<AttrAttrGroupRelEntity> attrAttrGroupRels;
}
