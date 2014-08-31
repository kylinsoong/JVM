package com.kylin.test.proxy;

public class VehicleProxy implements IVehicle {

	private IVehicle v;

	public VehicleProxy(IVehicle v) {
		this.v = v;
	}

	public void start() {
		System.out.println("VehicleProxy: Begin of start()");
		v.start();
		System.out.println("VehicleProxy: End of start()");
	}

	public void stop() {
		System.out.println("VehicleProxy: Begin of stop()");
		v.stop();
		System.out.println("VehicleProxy: End of stop()");
	}

	public void forward() {
		System.out.println("VehicleProxy: Begin of forward()");
		v.forward();
		System.out.println("VehicleProxy: End of forward()");
	}

	public void reverse() {
		System.out.println("VehicleProxy: Begin of reverse()");
		v.reverse();
		System.out.println("VehicleProxy: End of reverse()");
	}

	public String getName() {
		return v.getName();
	}
}
