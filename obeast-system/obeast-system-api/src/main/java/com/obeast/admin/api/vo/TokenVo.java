package com.obeast.admin.api.vo;

import lombok.Data;

/**
 * @author wxl
 * Date 2023/5/14 13:34
 * @version 1.0
 * Description: 前端展示令牌管理
 */
@Data
public class TokenVo {

	private String id;

	private Long userId;

	private String clientId;

	private String username;

	private String accessToken;

	private String issuedAt;

	private String expiresAt;

}
