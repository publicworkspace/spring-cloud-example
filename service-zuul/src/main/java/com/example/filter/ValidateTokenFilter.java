package com.example.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wecan on 2019/12/4.
 */
public class ValidateTokenFilter extends ZuulFilter{
    //四种类型：pre,routing,error,post
    //pre：主要用在路由映射的阶段是寻找路由映射表的
    //routing:具体的路由转发过滤器是在routing路由器，具体的请求转发的时候会调用
    //error:一旦前面的过滤器出错了，会调用error过滤器。
    //post:当routing，error运行完后才会调用该过滤器，是在最后阶段的
    @Override
    public String filterType() {
        return "pre";
    }

    //自定义过滤器执行的顺序，数值越大越靠后执行，越小就越先执行
    @Override
    public int filterOrder() {
        return 0;
    }

    //控制过滤器生效不生效，可以在里面写一串逻辑来控制
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

//    try{
//        业务逻辑......
//    }catch(Exception e){
//        RequestContext context = RequestContext.getCurrentContext();
//        context.set("error.status_code",401);
//        context.set("error.exception",e);
//        context.set("error.message","sfdfsdf");
//    }
}
