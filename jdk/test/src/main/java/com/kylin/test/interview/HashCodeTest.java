package com.kylin.test.interview;

import java.util.HashMap;
import java.util.Map;

public class HashCodeTest {

	public static void main(String[] args) {
		 
		Map map = new HashMap();
		map.put(new Integer(5), "Value1?");
		String value = (String) map.get(new Integer(5));
		System.out.println(value);
	}

}
