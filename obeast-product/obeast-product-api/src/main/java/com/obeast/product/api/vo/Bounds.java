package com.obeast.product.api.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wxl
 * Date 2023/5/26 10:48
 * @version 1.0
 * Description:
 */
@Data
public class Bounds {

    private BigDecimal buyBounds;
    private BigDecimal growBounds;

}