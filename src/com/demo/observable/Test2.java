package com.demo.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * 示例：假设公司需要招几个Java软件工程�?
 * 
 * 职位--主题
 */
class Position extends Observable {
	/** 职位�?*/
	private String name;
	/** 职位薪水由公司固�?*/
	private float salary;

	public Position(String name, float salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
		this.setChanged();
		this.notifyObservers(salary);
	}

}

/**
 * 面试�?--观察�?
 */
class Interviewer implements Observer {
	/** 面试者名�?*/
	private String name;
	/** 是否被录�?*/
	private boolean isHired = false;

	public Interviewer(String name, boolean isHired) {
		this.name = name;
		this.isHired = isHired;
	}

	public String getName() {
		return name;
	}

	public boolean isHired() {
		return isHired;
	}

	public void setHired(boolean isHired) {
		this.isHired = isHired;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Position && arg instanceof Float) {
			Position position = (Position) o;
			if (isHired) {
				System.out
						.println(this.name + " 恭喜您，您成功应聘我们公司的 "
								+ position.getName() + "职位，薪水为"
								+ position.getSalary());
			} else {
				System.out.println(this.name + " 很抱歉，您不符合我们公司�?"
						+ position.getName() + "职位");
			}
		}
	}

}

public class Test2 {
	public static void main(String[] args) {
		/** 默认月薪5000元的Java软件工程师这个职位还没有人应聘上 */
		Position position = new Position("Java软件工程�?", 5000.0f);
		Interviewer zhangsan = new Interviewer("张三", true);
		Interviewer lisi = new Interviewer("李四", false);
		position.addObserver(zhangsan);
		position.addObserver(lisi);
		position.setSalary(6000.0f);
	}
}
