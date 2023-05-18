package com.obeast.common.log.event;

import com.obeast.admin.api.entity.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 * @author wxl
 * Date 2023/4/9 23:44
 * @version 1.0
 * Description: 系统日志事件
 */
public class SysLogEvent extends ApplicationEvent {

	public SysLogEvent(SysLog source) {
		super(source);
	}

}
