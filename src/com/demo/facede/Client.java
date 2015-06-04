package com.demo.facede;

/**
 * 
 * Client.java Create on 2015-5-14 下午2:16:48 场景类
 * 策略（strategy)模式：负载对扣款策略进行封装，保证了两个策略可以自由的切换。
 * 
 * 工厂（factory）模式：修正策略模式必须对外暴露具体策略的问题，由工厂模式直接产生一个具体策略对象，其他模块则不需要依赖具体策略。
 * 
 * 门面(facade)模式：负责对复杂的扣款系统进行封转，封转的结果就是避免高层模块深入子系统内部，同时提供系统高内聚、低耦合的特性。
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
