package com.demo.facede;

/**
 * 
 * FreeDeduction.java Create on 2015-5-14 обнГ2:07:45
 * 
 * @author leizi
 * 
 */
public class FreeDeduction implements IDeduction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demo.facede.IDeduction#exec(com.demo.facede.Card,
	 * com.demo.facede.Trade)
	 */
	@Override
	public boolean exec(Card card, Trade trade) {
		card.setFreeMoney(card.getFreeMoney() - trade.getMount());
		return true;
	}
}
