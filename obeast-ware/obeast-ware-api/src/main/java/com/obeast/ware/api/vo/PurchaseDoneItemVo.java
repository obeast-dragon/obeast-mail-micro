package com.obeast.ware.api.vo;

import lombok.Data;

/**
 * @author wxl
 * Date 2023/5/29 13:03
 * @version 1.0
 * Description:
 */
@Data
public class PurchaseDoneItemVo {

    private Long itemId;
    private Integer status;
    private String reason;
}
