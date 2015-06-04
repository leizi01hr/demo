package com.demo.facede;

/**
 * 
 * StrategyManage.java Create on 2015-5-14 обнГ2:09:52
 * 
 * @author leizi
 * 
 */
public enum StrategyManage {
	SteadyDeduction("com.demo.facede.SteadyDeduction"),
	FreeDeducation("com.demo.facede.FreeDeduction");
	
	String value = "";

	private StrategyManage(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
