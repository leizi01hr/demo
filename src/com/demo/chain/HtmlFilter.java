package com.demo.chain;
/** 
 *
 * HtmlFilter.java Create on 2015-5-14 上午9:28:48
 * 
 * @author  leizi
 * 
 */
public class HtmlFilter implements Filter{

	/* (non-Javadoc)
	 * @see com.demo.chain.Filter#doFilter(com.demo.chain.Request, com.demo.chain.Response, com.demo.chain.FilterChain)
	 */
	@Override
	public void doFilter(Request req, Response res, FilterChain fc) {
		req.requestStr = req.requestStr.replace("<","[");
		req.requestStr = req.requestStr.replace(">","]") + "-->htmlFilter";
		fc.doFilter(req, res, fc); //在这里调用下一个filter
		res.responseStr += "-->htmlFilter";
	}

}
