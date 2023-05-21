package com.obeast.member.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.obeast.member.api.entity.UndoLogEntity;


/**
 * @author wxl
 * Date 2023-05-21 20:50:14
 * @version 1.0
 * Description: 
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    /**
    * Description: 分页查询品牌
    * @author wxl
    * Date: 2023/5/20 22:57
    * @param page page
    * @return UndoLogEntity
    */
    IPage<UndoLogEntity> pageUndoLogs (Page<UndoLogEntity> page);


    /**
     * Description: 新增
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param undoLogEntity UndoLogEntity
     * @return java.lang.Boolean
     */
    Boolean saveUndoLog(UndoLogEntity undoLogEntity);

    /**
     * Description: 删除
     * @author wxl
     * Date: 2023/5/20 22:57
     * @param id id
     * @return java.lang.Boolean
     */
    Boolean removeUndoLogById(Long id);

    /**
     * Description: 更新
     * @author wxl
     * Date: 2023/5/20 22:58
     * @param undoLogEntity UndoLogEntity
     * @return java.lang.Boolean
     */
    Boolean updateUndoLog(UndoLogEntity undoLogEntity);

}

