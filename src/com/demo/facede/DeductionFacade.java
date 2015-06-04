package com.demo.facede;

/**
 * 
 * DeductionFacade.java Create on 2015-5-14 ����2:14:14 �ۿ�ģ���װ
 * 
 * @author leizi
 * 
 */
public class DeductionFacade {

	public static Card deduct(Card card, Trade trade) {
		StrategyManage reg = getDeducationType(trade); // ������Ѳ���
		IDeduction deduction = StrategyFactory.getDeduction(reg); // ��ʼ��һ�����Ѳ���
		DeductionContext context = new DeductionContext(deduction); // ִ�з�װ
		context.exec(card, trade); // ִ�пۿ�
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
