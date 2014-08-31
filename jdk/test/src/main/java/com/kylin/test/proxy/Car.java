package com.kylin.test.proxy;

public class Car implements IVehicle {

	private String name;

	public Car(String name) {
		this.name = name;
	}

	public void start() {
		System.out.println("Car " + name + " started");
	}

	public void stop() {
		System.out.println("Car " + name + " stoped");
	}

	public void forward() {
		System.out.println("Car " + name + " forwarded");
	}

	public void reverse() {
		System.out.println("Car " + name + " reversed");
	}

	public String getName() {
		return name;
	}
}
