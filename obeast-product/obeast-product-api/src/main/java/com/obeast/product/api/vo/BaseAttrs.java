package com.obeast.product.api.vo;

import lombok.Data;

/**
 * @author wxl
 * Date 2023/5/26 10:48
 * @version 1.0
 * Description:
 */
@Data
public class BaseAttrs {

    private Long attrId;
    private String attrValues;
    private int showDesc;

}