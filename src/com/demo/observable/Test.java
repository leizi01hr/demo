package com.demo.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * 
 * A1.java Create on 2015-5-13 ����2:46:51 �۲��������ģʽ������
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
		 * ���ò˼۵�״̬�Ѿ����ı�
		 */
		this.setChanged();
		/**
		 * ֪ͨ�����С����ڿ���(�Ѿ�ע����)�Ĺ˿ͣ�Ȼ��ص�Observer��update�������и���
		 * 
		 * ����������ֶ����һ�Զࣺһ��С�̷�һ�����¼۸�(��һ������ı�״̬)������Զ�֪ͨ���еĹ˿�(�������Ķ��󶼻��յ�֪ͨ)
		 * ���Զ�update
		 */
		this.notifyObservers(price);
	}

	public static void main(String[] args) {
		Test food = new Test("����", 1.0f);
		A2 zhangsan = new A2("����");
		A2 lisi = new A2("����");
		/**
		 * ��ӹ˿�
		 */
		food.addObserver(zhangsan);
		food.addObserver(lisi);
		/**
		 * ���¼۸�
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
			System.out.println("���ã�" + this.name + " ," + food.getName()
					+ "�ļ۸��Ѿ������ı䣬���ڵļ۸�Ϊ��" + price + "Ԫ/��");
		}
	}
}
