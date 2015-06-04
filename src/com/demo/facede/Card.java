package com.demo.facede;

/**
 * 
 * Card.java Create on 2015-5-14 下午1:59:19
 * 
 * @author leizi
 * 
 */
public class Card {

	private String no;
	private int steadyMoney; // 卡内固定交易金额
	private int freeMoney; // 卡内自由交易金额

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public int getSteadyMoney() {
		return steadyMoney;
	}

	public void setSteadyMoney(int steadyMoney) {
		this.steadyMoney = steadyMoney;
	}

	public int getFreeMoney() {
		return freeMoney;
	}

	public void setFreeMoney(int freeMoney) {
		this.freeMoney = freeMoney;
	}

}
