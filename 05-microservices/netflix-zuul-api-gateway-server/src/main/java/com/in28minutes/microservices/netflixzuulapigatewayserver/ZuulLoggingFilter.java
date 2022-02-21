package com.in28minutes.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulLoggingFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		// Always execute filter
		return true;
	}

	@Override
	public Object run() {
		// Defines what the filter should do on being applied to an intercepted request.
		HttpServletRequest request = 
				RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}", 
				request, request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		// pre-filter = apply filter before execution
		// post-filter = apply filter after execution
		return "pre";
	}

	@Override
	public int filterOrder() {
		// When multiple filters are present, this order determines which filter to apply first.
		// Lower ordered filters are applied first.
		return 1;
	}
}
