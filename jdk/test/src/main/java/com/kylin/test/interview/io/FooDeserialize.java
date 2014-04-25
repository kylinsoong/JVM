package com.kylin.test.interview.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FooDeserialize {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream("foo.ser"); 
		ObjectInputStream oin =  new ObjectInputStream(fin);
		Object obj = oin.readObject();
		oin.close();
		System.out.println(obj);
	}

}
