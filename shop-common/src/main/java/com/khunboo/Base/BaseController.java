package com.khunboo.Base;


import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class BaseController {

    /**
     * 重定向前头
     */
    protected String REDIRECT = "redirect:";

    /**
     * 转发前头
     */
    protected String FORWARD = "forward:";

    protected HttpServletRequest getHttpServletRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    protected HttpServletResponse getHttpServletResponse() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }

    /**
     * 获取参数
     *
     * @param name
     * @return 参数值
     */
    protected String getPara(String name) {
        return getHttpServletRequest().getParameter(name);
    }

    /**
     * 获取header值
     *
     * @param name
     * @return header值
     */
    protected String getHeader(String name) {
        return getHttpServletRequest().getHeader(name);
    }


    /**
     * 获取Ip地址
     * Create by gutongwei
     * 2018/6/1
     *
     * @return IP 地址
     */
    protected String getIpAddress() {
        HttpServletRequest request = getHttpServletRequest();
        String xIp = request.getHeader("X-Real-IP");
        String xFor = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(xFor) && !"unKnown".equalsIgnoreCase(xFor)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = xFor.indexOf(",");
            if (index != -1) {
                return xFor.substring(0, index);
            } else {
                return xFor;
            }
        }
        xFor = xIp;
        if (StringUtils.isNotEmpty(xFor) && !"unKnown".equalsIgnoreCase(xFor)) {
            return xFor;
        }
        if (StringUtils.isBlank(xFor) || "unknown".equalsIgnoreCase(xFor)) {
            xFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(xFor) || "unknown".equalsIgnoreCase(xFor)) {
            xFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(xFor) || "unknown".equalsIgnoreCase(xFor)) {
            xFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(xFor) || "unknown".equalsIgnoreCase(xFor)) {
            xFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(xFor) || "unknown".equalsIgnoreCase(xFor)) {
            xFor = request.getRemoteAddr();
        }
        return xFor;
    }


    /**
     * 添加cookie
     *
     * @param name
     * @param value
     */
    protected void addCookie(String name, String value) {
        addCookie(name, value, -1);
    }


    /**
     * 添加cookie
     *
     * @param name
     * @param value
     */
    protected void addCookie(String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        getHttpServletResponse().addCookie(cookie);
    }

    /**
     * 获取cookie值
     *
     * @param name
     * @return
     */
    protected String getCookieValue(String name) {
        AtomicReference<String> value = new AtomicReference<>();
        HttpServletRequest request = getHttpServletRequest();
        value.set("");
        if (request.getCookies() != null && request.getCookies().length > 0) {
            Arrays.asList(request.getCookies()).forEach(c -> {
                if (name.equals(c.getName())) {
                    value.set(c.getValue());
                }
            });
        }
        return value.get();
    }

    /**
     * 删除cookie
     *
     * @param name
     */
    protected void removeCookie(String name) {
        HttpServletRequest request = getHttpServletRequest();
        if (request.getCookies() != null && request.getCookies().length > 0) {
            Arrays.asList(request.getCookies()).forEach(c -> {
                if (name.equals(c.getName())) {
                    c.setMaxAge(0);
                    getHttpServletResponse().addCookie(c);
                }
            });
        }
    }


    /**
     * 获取设备是什么类型
     * 0：安卓
     * 1：ios
     *
     * @return
     */
    protected Integer getPlatform() {
        String userAgent = getHeader("User-Agent");
        if (StringUtils.isNotEmpty(userAgent)) {
            userAgent = userAgent.toLowerCase();
            if (userAgent.contains("android")) {
                return 0;
            }
            if (userAgent.contains("iphone")) {
                return 1;
            }
        }
        return null;
    }


    /**
     * 获取session
     *
     * @return
     */
    protected HttpSession getSession() {
        return getHttpServletRequest().getSession();
    }

    /**
     * 添加session
     *
     * @param key
     * @param value
     */
    protected void addSessionAttribute(String key, Object value) {
        getSession().setAttribute(key, value);
    }


    /**
     * 获取session值
     *
     * @param key
     * @return
     */
    protected Object getSessionAttribute(String key) {
        return getSession().getAttribute(key);
    }
}
