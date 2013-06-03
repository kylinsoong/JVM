package com.kylin.jvm.highcpu.tools;

public class HighCUPTools {

	public static String decimalToHexadecimal(int decimal) {
		return Integer.toHexString(decimal);
	} 
	
	public static String hexadecimalToDecimal(String hex) {
		return Integer.parseInt(hex, 16) + "";
	}
}
