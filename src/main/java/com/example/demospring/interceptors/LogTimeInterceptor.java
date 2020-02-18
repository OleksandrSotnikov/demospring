package com.example.demospring.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class LogTimeInterceptor implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(LogTimeInterceptor.class);
    public static final String LOG_START_TIME = "log_start_time";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.getServletContext().setAttribute(LOG_START_TIME, new Date());

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Date startedAt = (Date) request.getServletContext().getAttribute(LOG_START_TIME);
        LOG.info("request completed in {} ms", new Date().getTime() - startedAt.getTime());
    }
}
