package com.kylin.applepassing;

public class MarkedApple extends Apple {
	
	private long id;

	public MarkedApple(int time, String color, long id) {
		super(time, color);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String toString() {
		return "MarkedApple [id=" + id + ", toString()=" + super.toString() + "]";
	}

}
