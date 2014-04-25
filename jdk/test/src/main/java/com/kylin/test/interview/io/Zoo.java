package com.kylin.test.interview.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Zoo implements Externalizable {
	
	private String name;
	
	private String place;
	
	public Zoo () {
		
	}

	public Zoo(String name, String place) {
		super();
		this.name = name;
		this.place = place;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("writeExternal");
		out.writeObject(name);
		out.writeObject(place);
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("readExternal");
		this.name = (String) in.readObject();
		this.place = (String) in.readObject();
	}

	public String toString() {
		return "Zoo [name=" + name + ", place=" + place + "]";
	}

}
