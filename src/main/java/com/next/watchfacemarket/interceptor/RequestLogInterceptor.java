package com.next.watchfacemarket.interceptor;

import com.next.watchfacemarket.log.KayleLog;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 打印接口请求参数拦截器.
 *
 * @Author: Jie.He, Leisurehejie@sina.com
 * @Date: 2019/11/10 1:30 下午
 */
public class RequestLogInterceptor extends HandlerInterceptorAdapter {

    private static KayleLog logger  = new KayleLog(RequestLogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) {
        String path = httpServletRequest.getServletPath();
        Map<String, String[]> params = httpServletRequest.getParameterMap();
        StringBuilder stringBuilder = new StringBuilder("?");
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (String value : values) {
                stringBuilder.append(key).append("=").append(value).append("&");
            }
        }
        logger.info("Path=%s, params=%s", path, stringBuilder.toString());
        return true;
    }

}
