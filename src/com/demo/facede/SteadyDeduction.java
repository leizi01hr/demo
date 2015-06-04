package com.demo.facede;

/**
 * 
 * SteadyDeduction.java Create on 2015-5-14 обнГ2:05:23
 * 
 * @author leizi
 * 
 */
public class SteadyDeduction implements IDeduction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demo.facede.IDeduction#exec(com.demo.facede.Card,
	 * com.demo.facede.Trade)
	 */
	@Override
	public boolean exec(Card card, Trade trade) {
		int halfMoney = (int) Math.rint(trade.getMount() / 2.0);
		card.setSteadyMoney(card.getSteadyMoney() - halfMoney);
		card.setFreeMoney(card.getFreeMoney() - halfMoney);
		return true;
	}

}
