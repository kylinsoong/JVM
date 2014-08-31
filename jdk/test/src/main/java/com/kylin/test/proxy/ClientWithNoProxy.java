package com.kylin.test.proxy;

public class ClientWithNoProxy {

	public static void main(String[] args) {
		IVehicle v = new Car("Botar");
		v.start();
		v.forward();
		v.stop();
	}
}
