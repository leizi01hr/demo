package com.demo.facede;

/**
 * 
 * DeductionFacade.java Create on 2015-5-14 下午2:14:14 扣款模块封装
 * 
 * @author leizi
 * 
 */
public class DeductionFacade {

	public static Card deduct(Card card, Trade trade) {
		StrategyManage reg = getDeducationType(trade); // 获得消费策略
		IDeduction deduction = StrategyFactory.getDeduction(reg); // 初始化一个消费策略
		DeductionContext context = new DeductionContext(deduction); // 执行封装
		context.exec(card, trade); // 执行扣款
		return card;
	}

	private static StrategyManage getDeducationType(Trade trade) {
		if (trade.getTradeNo().contains("abc")) {
			return StrategyManage.FreeDeducation;
		} else {
			return StrategyManage.SteadyDeduction;
		}
	}
}
