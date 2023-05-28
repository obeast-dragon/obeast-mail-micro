package com.obeast.ware.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.ware.api.entity.WareOrderTaskEntity;


/**
 * @author wxl
 * Date 2023-05-28 20:40:51
 * @version 1.0
 * Description: 库存工作单
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return WareOrderTaskEntity
    */
    IPage<WareOrderTaskEntity> pageWareOrderTasks (Page<WareOrderTaskEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param wareOrderTaskEntity WareOrderTaskEntity
     * @return java.lang.Boolean
     */
    Boolean saveWareOrderTask(WareOrderTaskEntity wareOrderTaskEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeWareOrderTaskById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param wareOrderTaskEntity WareOrderTaskEntity
     * @return java.lang.Boolean
     */
    Boolean updateWareOrderTask(WareOrderTaskEntity wareOrderTaskEntity);

}

