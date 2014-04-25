package com.kylin.test.interview.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ZooTest {

	public static void main(String[] args) throws Exception {
		
		Zoo zoo = new Zoo("Beijing Zoo", "Chao Yao");
		
		FileOutputStream fos = new FileOutputStream("zoo.ser");  
		ObjectOutputStream oos = new ObjectOutputStream(fos);  
		oos.writeObject(zoo);  
		oos.close();
		
		FileInputStream fin = new FileInputStream("zoo.ser"); 
		ObjectInputStream oin =  new ObjectInputStream(fin);
		Object obj = oin.readObject();
		oin.close();
		System.out.println(obj);
	}

}
