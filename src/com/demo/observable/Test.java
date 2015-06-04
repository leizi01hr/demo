package com.demo.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * 
 * A1.java Create on 2015-5-13 下午2:46:51 观察者涉设计模式简单例子
 * 
 * @author leizi
 * 
 */
public class Test extends Observable {

	private String name;
	private float price;

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public Test(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}

	public void setPrice(float price) {
		this.price = price;
		/**
		 * 设置菜价的状态已经被改变
		 */
		this.setChanged();
		/**
		 * 通知【所有】正在看菜(已经注册了)的顾客，然后回调Observer的update方法进行更新
		 * 
		 * 这里可以体现对象的一对多：一个小商贩一旦更新价格(即一个对象改变状态)，便会自动通知所有的顾客(依赖它的对象都会收到通知)
		 * 并自动update
		 */
		this.notifyObservers(price);
	}

	public static void main(String[] args) {
		Test food = new Test("土豆", 1.0f);
		A2 zhangsan = new A2("张三");
		A2 lisi = new A2("李四");
		/**
		 * 添加顾客
		 */
		food.addObserver(zhangsan);
		food.addObserver(lisi);
		/**
		 * 更新价格
		 */
		food.setPrice(2.0f);
	}
}

class A2 implements Observer {

	private String name;

	public A2(String name) {
		super();
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Test && arg instanceof Float) {
			Test food = (Test) o;
			float price = (Float) arg;
			System.out.println("您好：" + this.name + " ," + food.getName()
					+ "的价格已经发生改变，现在的价格为：" + price + "元/斤");
		}
	}
}
