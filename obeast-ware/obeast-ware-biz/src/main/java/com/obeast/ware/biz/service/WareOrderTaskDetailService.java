package com.obeast.ware.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.ware.api.entity.WareOrderTaskDetailEntity;


/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 库存工作单
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return WareOrderTaskDetailEntity
    */
    IPage<WareOrderTaskDetailEntity> pageWareOrderTaskDetails (Page<WareOrderTaskDetailEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param wareOrderTaskDetailEntity WareOrderTaskDetailEntity
     * @return java.lang.Boolean
     */
    Boolean saveWareOrderTaskDetail(WareOrderTaskDetailEntity wareOrderTaskDetailEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeWareOrderTaskDetailById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param wareOrderTaskDetailEntity WareOrderTaskDetailEntity
     * @return java.lang.Boolean
     */
    Boolean updateWareOrderTaskDetail(WareOrderTaskDetailEntity wareOrderTaskDetailEntity);

}

