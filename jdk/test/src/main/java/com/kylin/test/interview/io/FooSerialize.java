package com.kylin.test.interview.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FooSerialize {

	public static void main(String[] args) throws Exception {

		Foo myFoo = new Foo();
		myFoo.setWidth(37);
		myFoo.setHeight(70);
		
		FileOutputStream fs = new FileOutputStream("foo.ser");  
		ObjectOutputStream os = new ObjectOutputStream(fs);  
		os.writeObject(myFoo);  
		os.close();
		
		
	}

}
