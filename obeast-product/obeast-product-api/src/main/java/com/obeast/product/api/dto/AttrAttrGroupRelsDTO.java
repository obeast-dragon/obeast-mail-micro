package com.obeast.product.api.dto;


import lombok.Data;

/**
 * @author wxl
 * Date 2023/5/24 0:16
 * @version 1.0
 * Description:
 */
@Data
public class AttrAttrGroupRelsDTO {

    private Long id;

    /**
     * 属性id
     */
    private Long attrId;

    /**
     * 属性分组id
     */
    private Long attrGroupId;

    /**
     * 属性组内排序
     */
    private Integer attrSort;

    /**
     * 属性名
     */
    private String attrName;


    /**
     * 可选值列表[用逗号分隔]
     */
    private String valueSelect;
}
