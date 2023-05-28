package com.obeast.ware.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.ware.api.entity.WareInfoEntity;

import java.util.List;


/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 仓库信息
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @param name name
    * @return WareInfoEntity
    */
    IPage<WareInfoEntity> pageWareInfos (Page<WareInfoEntity> page, String name);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param wareInfoEntity WareInfoEntity
     * @return java.lang.Boolean
     */
    Boolean saveWareInfo(WareInfoEntity wareInfoEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeWareInfoById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param wareInfoEntity WareInfoEntity
     * @return java.lang.Boolean
     */
    Boolean updateWareInfo(WareInfoEntity wareInfoEntity);

    List<WareInfoEntity> listWareInfos();
}

