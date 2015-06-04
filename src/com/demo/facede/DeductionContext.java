package com.demo.facede;

/**
 * 
 * DeductionContext.java Create on 2015-5-14 обнГ2:09:20
 * 
 * @author leizi
 * 
 */
public class DeductionContext {
	
	private IDeduction deduction;

	public DeductionContext(IDeduction deduction) {
		this.deduction = deduction;
	}

	public boolean exec(Card card, Trade trade) {
		return this.deduction.exec(card, trade);
	}
}
