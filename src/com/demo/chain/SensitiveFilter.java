package com.demo.chain;

/**
 * 
 * SensitiveFilter.java Create on 2015-5-14 ÉÏÎç9:47:31 Ãô¸Ğ´Êfilter
 * 
 * @author leizi
 * 
 */
public class SensitiveFilter implements Filter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demo.chain.Filter#doFilter(com.demo.chain.Request,
	 * com.demo.chain.Response, com.demo.chain.FilterChain)
	 */
	@Override
	public void doFilter(Request req, Response res, FilterChain fc) {
		req.requestStr = req.requestStr.replace("Ãô¸Ğ", "mingan") + "-->sensitiveFilter";
		fc.doFilter(req, res, fc);
		res.responseStr += "-->sensitiveFilter";
	}
}
