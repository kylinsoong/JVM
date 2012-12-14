package com.kylin.applepassing;

public class Apple {

	private int time;
	
	private String color;

	public Apple(int time, String color) {
		super();
		this.time = time;
		this.color = color;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {
		return "Apple [time=" + time + ", color=" + color + "]";
	}
}
