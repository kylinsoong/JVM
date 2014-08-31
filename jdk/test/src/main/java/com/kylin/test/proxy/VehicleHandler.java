package com.kylin.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class VehicleHandler implements InvocationHandler {
	
	private IVehicle v;

	public VehicleHandler(IVehicle v) {
		this.v = v;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Vehicle Handler: Invoking " + method.getName());
		return method.invoke(v, args);
	}
}
