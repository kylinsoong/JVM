package test.java.lang.reflect.proxy.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Runner {

	public static void main(String[] args) {
		
		

		Object obj = Proxy.newProxyInstance(Runner.class.getClassLoader(), new Class[] {IVehicle.class}, new InvocationHandler(){

			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				System.out.println(proxy.getClass());
				System.out.println(method);
				System.out.println(args);
				return method.invoke(new Car("XXXX"), args);
			}});
		System.out.println(obj.getClass());
		
		System.out.println(obj.toString());
	}

}
