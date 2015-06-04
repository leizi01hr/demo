package com.demo.facede;

/**
 * 
 * Client.java Create on 2015-5-14 ����2:16:48 ������
 * ���ԣ�strategy)ģʽ�����ضԿۿ���Խ��з�װ����֤���������Կ������ɵ��л���
 * 
 * ������factory��ģʽ����������ģʽ������Ⱪ¶������Ե����⣬�ɹ���ģʽֱ�Ӳ���һ��������Զ�������ģ������Ҫ����������ԡ�
 * 
 * ����(facade)ģʽ������Ը��ӵĿۿ�ϵͳ���з�ת����ת�Ľ�����Ǳ���߲�ģ��������ϵͳ�ڲ���ͬʱ�ṩϵͳ���ھۡ�����ϵ����ԡ�
 * 
 * @author leizi
 * 
 */
public class Client {

	private static Card initCard() {
		Card card = new Card();
		card.setNo("abc");
		card.setFreeMoney(10);
		card.setSteadyMoney(0);
		return card;
	}

	private static Trade initTrade() {
		Trade trade = new Trade();
		trade.setMount(0);
		trade.setTradeNo("");
		return trade;
	}

	public static void main(String[] args) {
		Card card = initCard();
		boolean flag = true;
		while (flag) {
			Trade trade = initTrade();
			DeductionFacade.deduct(card, trade);
		}
	}
}
