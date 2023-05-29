package com.obeast.ware.api.feign;

import com.obeast.common.core.base.CommonResult;
import com.obeast.common.core.constant.SysConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wxl
 * Date 2023/5/26 21:15
 * @version 1.0
 * Description: 商品spu积分设置feign
 */
@FeignClient(contextId = "remoteSkuInfoService", value = SysConstants.Server.PRODUCT_SERVICE)
public interface RemoteSkuInfoService {

    @GetMapping("/skuInfo/getById")
    CommonResult<?> getInfoById (@RequestParam(value = "skuId") Long skuId);
}
