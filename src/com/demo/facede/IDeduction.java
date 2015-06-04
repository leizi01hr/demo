package com.demo.facede;

/**
 * 
 * IDeduction.java Create on 2015-5-14 下午2:03:09 扣款策略接口
 * 
 * @author leizi
 * 
 */
public interface IDeduction {

	public boolean exec(Card card, Trade trade);

}
