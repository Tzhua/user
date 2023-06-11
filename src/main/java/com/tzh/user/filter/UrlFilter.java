package com.tzh.user.filter;

import com.alibaba.fastjson.JSONObject;
import com.tzh.user.JwtUtils;
import com.tzh.user.entity.Result;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: TZH
 * @Date: 2023-06-11 18:03
 * @Description: 接口过滤器
 */
@WebFilter(urlPatterns = "/*")
public class UrlFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setCharacterEncoding("UTF-8");
        //获取url
        String url = httpServletRequest.getRequestURI();
        //判断是否包含login请求,是就放行
        if (url.contains("login")) {
            filterChain.doFilter(request,response);
            return;
        }
        //获取token
        String token = httpServletRequest.getHeader("token");
        //判断token是否存在
        if (!StringUtils.hasLength(token)) {
            Result error = new Result().fail(null,"未登录",201);
            String noLogin = JSONObject.toJSONString(error);
            httpServletResponse.getWriter().write(noLogin);
            return;
        }
        //解析token是否存在
        try {
            JwtUtils.parseJwt(token);
        }catch (Exception e){
            e.printStackTrace();
            Result noLogin = new Result().fail(null,"未登录",201);
            String s = JSONObject.toJSONString(noLogin);
            httpServletResponse.getWriter().write(s);
            return;
        }
        filterChain.doFilter(request,response);
    }
}
