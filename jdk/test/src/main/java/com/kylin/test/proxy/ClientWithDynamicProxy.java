package com.kylin.test.proxy;

import java.lang.reflect.Proxy;

public class ClientWithDynamicProxy {

	public static void main(String[] args) {
		IVehicle c = new Car("Botar");
		IVehicle v = (IVehicle) Proxy.newProxyInstance(c.getClass().getClassLoader(), new Class[]{IVehicle.class}, new VehicleHandler(c));
		v.start();
		v.forward();
		v.stop();
	}
}
