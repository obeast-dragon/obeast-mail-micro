package com.obeast.admin.api.vo;

import com.obeast.admin.api.entity.SysLog;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wxl
 * Date 2023/5/14 13:35
 * @version 1.0
 * Description:
 */
@Data
public class LogVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private SysLog sysLog;

	private String username;

}
