package com.obeast.product.api.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wxl
 * Date 2023/5/26 19:38
 * @version 1.0
 * Description:
 */
@Data
public class SpuBoundTo {
    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;

}

