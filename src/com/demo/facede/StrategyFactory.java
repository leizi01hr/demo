package com.demo.facede;

/**
 * 
 * StrategyFactory.java Create on 2015-5-14 ����2:12:04 ���Թ���
 * 
 * @author leizi
 * 
 */
public class StrategyFactory {

	public static IDeduction getDeduction(StrategyManage strategy) {
		IDeduction deduction = null;
		try {
			deduction = (IDeduction) Class.forName(strategy.getValue()).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deduction;
	}

}
