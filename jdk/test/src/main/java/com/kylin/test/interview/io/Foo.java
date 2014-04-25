package com.kylin.test.interview.io;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class Foo implements Serializable {

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {  
	    System.out.println("writeObject invoked");  
	    out.writeObject(this.width);
	    out.writeObject(this.height);
	}  
	  
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {  
	    System.out.println("readObject invoked");    
	    this.width = (Integer) in.readObject();
	    this.height = (Integer) in.readObject();
	}  
	  
	private Object writeReplace() throws ObjectStreamException {  
	    System.out.println("writeReplace invoked");  
	    return this;  
	}  
	  
	private Object readResolve() throws ObjectStreamException {  
	    System.out.println("readResolve invoked");  
	    return this;  
	}
	
	private static final long serialVersionUID = -6270986588630601882L;

	private int width, height;
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

//	private int size;
//	
//	public int getSize() {
//		return size;
//	}
//
//	public void setSize(int size) {
//		this.size = size;
//	}

//	@Override
//	public String toString() {
//		return "Foo [width=" + width + ", height=" + height + ", size=" + size
//				+ "]";
//	}

	@Override
	public String toString() {
		return "Foo [width=" + width + ", height=" + height + "]";
	}


}
