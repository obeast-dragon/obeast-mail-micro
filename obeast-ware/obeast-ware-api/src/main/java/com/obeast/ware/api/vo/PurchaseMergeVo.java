package com.obeast.ware.api.vo;

import lombok.Data;

import java.util.List;

/**
 * @author wxl
 * Date 2023/5/29 10:36
 * @version 1.0
 * Description:
 */
@Data
public class PurchaseMergeVo {

    private Long purchaseId;

    private List<Long> items;
}
