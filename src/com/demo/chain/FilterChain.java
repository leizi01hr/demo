package com.demo.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * FilterChain.java Create on 2015-5-14 上午9:23:50 过滤链条
 * 
 * @author leizi
 * 
 */
public class FilterChain implements Filter {

	private List<Filter> filterList = new ArrayList<Filter>();

	public FilterChain addFilter(Filter filter){
		filterList.add(filter);
		return this;
	}

	int index = 0;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demo.chain.Filter#doFilter(com.demo.chain.Request,
	 * com.demo.chain.Response, com.demo.chain.FilterChain)
	 */
	@Override
	public void doFilter(Request req, Response res, FilterChain fc) {
		if(index == filterList.size()){
			return;
		}
		Filter f = filterList.get(index);
		index++;
		
		//依次执行下一个过滤器，直到整个过滤器链完
		f.doFilter(req, res, fc);
	}
}
