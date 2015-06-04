package com.demo.chain;

/**
 * 
 * Test.java Create on 2015-5-14 …œŒÁ9:53:17
 * 
 * @author leizi
 * 
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Request req = new Request();
		Response res = new Response();
		req.requestStr = "<a href=''>√Ù∏–¡¥Ω”</a>";
		res.responseStr = "response";
		FilterChain fc = new FilterChain();
		fc.addFilter(new HtmlFilter());
		
		FilterChain fc1 = new FilterChain();
		fc1.addFilter(new SensitiveFilter());
		
		fc.addFilter(fc1);
		
		fc.doFilter(req, res, fc);
		
		System.out.println(req.requestStr);
		System.out.println(res.responseStr);
	}

}
