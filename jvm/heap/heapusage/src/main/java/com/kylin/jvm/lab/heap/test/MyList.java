package com.kylin.jvm.lab.heap.test;

import java.util.ArrayList;

public class MyList extends ArrayList<Object> {

	private static final long serialVersionUID = 5494376355382907918L;

	public boolean add(Object e) {
		return super.add(e);
	}

}
