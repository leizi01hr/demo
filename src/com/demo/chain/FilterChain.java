package com.demo.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * FilterChain.java Create on 2015-5-14 ����9:23:50 ��������
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
		
		//����ִ����һ����������ֱ����������������
		f.doFilter(req, res, fc);
	}
}
