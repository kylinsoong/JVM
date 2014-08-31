package com.kylin.test.proxy.foo;

public class Client {

	public static void main(String[] args) throws BazException {
		Foo foo = (Foo) DebugProxy.newInstance(new FooImpl());
		foo.bar("Test");
	}

}
