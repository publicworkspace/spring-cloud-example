package com.example.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wecan on 2019/12/4.
 */
public class ValidateTokenFilter extends ZuulFilter{
    @Override
    public String filterType() {
        // 可以在请求被路由之前调用,四种状态pre、routing、POST、error
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 执行顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 是否执行此过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 处理过程
        RequestContext context = RequestContext.getCurrentContext() ;
        HttpServletRequest request = context.getRequest() ;

        Boolean bool = Boolean.valueOf(request.getParameter("token")) ;
        if(bool) {
            context.setSendZuulResponse(true) ; //是否路由
            context.setResponseStatusCode(200);
            context.set("isSuccess", true);

        }else {
            context.setSendZuulResponse(false) ; //是否路由
            context.setResponseStatusCode(400);
            context.set("isSuccess", false);
        }
        return null;
    }
}
