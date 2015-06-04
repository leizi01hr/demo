package com.demo.chain;
/** 
 *
 * Filter.java Create on 2015-5-14 ÉÏÎç9:22:55
 * 
 * @author  leizi
 * 
 */
public interface Filter {

	public void doFilter(Request request, Response response, FilterChain fc);
}
