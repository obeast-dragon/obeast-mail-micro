package com.obeast.admin.auth.support.handler;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.obeast.admin.api.entity.SysLog;
import com.obeast.common.core.base.CommonResult;
import com.obeast.common.core.constant.CommonConstants;
import com.obeast.common.core.constant.SecurityConstants;
import com.obeast.common.core.utils.SpringBeanUtil;
import com.obeast.common.log.event.SysLogEvent;
import com.obeast.common.log.util.SysLogUtils;
import com.obeast.common.security.service.ObeastUser;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.security.oauth2.core.http.converter.OAuth2AccessTokenResponseHttpMessageConverter;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AccessTokenAuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.Map;

/**
 * @author wxl
 * Date 2023/4/9 23:49
 * @version 1.0
 * Description:
 */
@Slf4j
public class ObeastAuthenticationSuccessEventHandler implements AuthenticationSuccessHandler {

	private final HttpMessageConverter<OAuth2AccessTokenResponse> accessTokenHttpResponseConverter = new OAuth2AccessTokenResponseHttpMessageConverter();

	/**
	 * Called when a user has been successfully authenticated.
	 * @param request the request which caused the successful authentication
	 * @param response the response
	 * @param authentication the <tt>Authentication</tt> object which was created during
	 * the authentication process.
	 */
	@SneakyThrows
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) {
		OAuth2AccessTokenAuthenticationToken accessTokenAuthentication =
				(OAuth2AccessTokenAuthenticationToken) authentication;
		Map<String, Object> map = accessTokenAuthentication.getAdditionalParameters();
		pushLog(map, accessTokenAuthentication, request);

		// 输出token
		handlerTokenResponse(request, response, authentication);
	}

	/**
	 * Description: 推送登录日志
	 * @author wxl
	 * Date: 2023/4/13 0:02
	 * @param map 参数
	 * @param accessTokenAuthentication accessTokenAuthentication
	 * @param request request
	 */
	private void pushLog (Map<String, Object> map, OAuth2AccessTokenAuthenticationToken accessTokenAuthentication, HttpServletRequest request) {
		if (MapUtil.isNotEmpty(map)) {
			// 发送异步日志事件
			ObeastUser userInfo = (ObeastUser) map.get(SecurityConstants.DETAILS_USER);
			log.info("用户：{} 登录成功", userInfo.getName());
			// 避免 race condition
			SecurityContext context = SecurityContextHolder.createEmptyContext();
			context.setAuthentication(accessTokenAuthentication);
			SecurityContextHolder.setContext(context);
			SysLog logVo = SysLogUtils.getSysLog();
			logVo.setTitle("登录成功");
			String startTimeStr = request.getHeader(CommonConstants.REQUEST_START_TIME);
			if (StrUtil.isNotBlank(startTimeStr)) {
				Long startTime = Long.parseLong(startTimeStr);
				Long endTime = System.currentTimeMillis();
				logVo.setTime(endTime - startTime);
			}

			logVo.setServiceId(accessTokenAuthentication.getRegisteredClient().getClientId());
			logVo.setCreateBy(userInfo.getName());
			logVo.setUpdateBy(userInfo.getName());
			SpringBeanUtil.publishEvent(new SysLogEvent(logVo));
		}

	}

	/**
	 * Description: 处理token
	 * @author wxl
	 * Date: 2022/12/13 22:44
	 * @param request  request
	 * @param response  response
	 * @param authentication  authentication
	 */
	private void handlerTokenResponse(HttpServletRequest request, HttpServletResponse response,
									  Authentication authentication) throws IOException {

		OAuth2AccessTokenAuthenticationToken accessTokenAuthentication =
				(OAuth2AccessTokenAuthenticationToken) authentication;

		OAuth2AccessToken accessToken = accessTokenAuthentication.getAccessToken();
		OAuth2RefreshToken refreshToken = accessTokenAuthentication.getRefreshToken();
		Map<String, Object> additionalParameters = accessTokenAuthentication.getAdditionalParameters();

		OAuth2AccessTokenResponse.Builder builder =
				OAuth2AccessTokenResponse.withToken(accessToken.getTokenValue())
			.tokenType(accessToken.getTokenType())
			.scopes(accessToken.getScopes());
		if (accessToken.getIssuedAt() != null && accessToken.getExpiresAt() != null) {
			builder.expiresIn(ChronoUnit.SECONDS.between(accessToken.getIssuedAt(), accessToken.getExpiresAt()));
		}
		if (refreshToken != null) {
			builder.refreshToken(refreshToken.getTokenValue());
		}
		if (!CollectionUtils.isEmpty(additionalParameters)) {
			builder.additionalParameters(additionalParameters);
		}
		OAuth2AccessTokenResponse accessTokenResponse = builder.build();
		ServletServerHttpResponse httpResponse = new ServletServerHttpResponse(response);

		// 无状态 注意删除 context 上下文的信息
		SecurityContextHolder.clearContext();
		this.accessTokenHttpResponseConverter.write(accessTokenResponse, null, httpResponse);
	}

}
