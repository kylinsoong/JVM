package com.kylin.test.lang.string;

public class StringBytesLengthTest extends StringTestBase{

	public void test() {
				
		String msgLen;
		for (msgLen = String.valueOf(testStr1.getBytes().length); msgLen.length() < 4; msgLen = "0" + msgLen);
		
		println(msgLen + testStr1);
	}

	public static void main(String[] args) {
		StringBytesLengthTest test = new StringBytesLengthTest();
		test.test();
	}

}
