package com.taocaicai.urlroles.handler;

import com.alibaba.fastjson.JSON;
import com.taocaicai.urlroles.common.ResponseEnum;
import com.taocaicai.urlroles.exception.InvalidTokenException;
import com.taocaicai.urlroles.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Oakley
 * @version 0.0.1
 * @Date 2020-06-07 06:21:6:21
 * @description: 自定义未授权 token无效 权限不足返回信息处理类
 */
@Component
@Slf4j
public class CustomAuthExceptionHandler implements AuthenticationEntryPoint, AccessDeniedHandler {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Throwable cause = authException.getCause();
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        // CORS "pre-flight" request
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Cache-Control", "no-cache");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.addHeader("Access-Control-Max-Age", "1800");
        if (cause instanceof InvalidTokenException) {
            if (cause instanceof Exception) {
                log.error("InvalidTokenException : {}", cause.getMessage());
                //Token无效
                response.getWriter().write(JSON.toJSONString(ResponseVO.error(ResponseEnum.ACCESS_TOKEN_INVALID)));
            } else {
                log.error("AuthenticationException : NoAuthentication");
                //资源未授权
                response.getWriter().write(JSON.toJSONString(ResponseVO.error(ResponseEnum.UNAUTHORIZED)));
            }
        }
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Cache-Control", "no-cache");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.addHeader("Access-Control-Max-Age", "1800");
        //访问资源的用户权限不足
        log.error("AccessDeniedException : {}", accessDeniedException.getMessage());
        response.getWriter().write(JSON.toJSONString(ResponseVO.error(ResponseEnum.INSUFFICIENT_PERMISSIONS)));
    }
}
