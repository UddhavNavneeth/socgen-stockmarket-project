package com.ud.zuulserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.util.ReflectionUtils;

public class ZuulErrorFilter extends ZuulFilter {

    private static final Logger LOG = LoggerFactory.getLogger(ZuulErrorFilter.class);
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return -1; // Probably order doesn't matter because it runs on demand
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().getThrowable() != null;
    }

    @Override
    public Object run() {
        try {
            LOG.error("Custom error filter runing ");
            RequestContext ctx = RequestContext.getCurrentContext();

            Throwable throwable = ctx.getThrowable();
            if (throwable != null) {
                LOG.error("Zuul failure detected: " + throwable.getMessage(), throwable);
                ctx.setResponseBody("Zuul exception:" + throwable.getMessage() + " cause: " + throwable.getCause()); // just for development purposes
                ctx.getResponse().setContentType("application/json");
                ctx.setResponseStatusCode(500);
            }
        }
        catch (Exception ex) {
            LOG.error("Exception filtering in custom error filter", ex);
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }
}
