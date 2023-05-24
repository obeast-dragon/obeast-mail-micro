package com.obeast.product.api.dto;

import com.obeast.product.api.entity.AttrEntity;
import com.obeast.product.api.entity.AttrGroupEntity;
import lombok.Data;

import java.util.List;

/**
 * @author wxl
 * Date 2023/5/24 11:00
 * @version 1.0
 * Description:
 */
@Data
public class AttrGroupDTO {

    private AttrGroupEntity attrGroup;

    private List<AttrEntity> attrs;

}
