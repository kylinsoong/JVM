package com.kylin.test.proxy;

public class ClientWithProxy {

	public static void main(String[] args) {
		IVehicle c = new Car("Botar");
		IVehicle v = new VehicleProxy(c);
		v.start();
		v.forward();
		v.stop();
	}
}
