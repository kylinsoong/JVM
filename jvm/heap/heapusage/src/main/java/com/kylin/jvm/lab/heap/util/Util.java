package com.kylin.jvm.lab.heap.util;

public class Util {
	
	public static final int KB_SIZE = 1024 * 1 ;
	
	public static final int MB_SIZE = 1024 * KB_SIZE ;
	
	public static final int GB_SIZE = 1024 * MB_SIZE ;
	
	public static byte[] getMBbyte(int size) {
		return new byte[MB_SIZE * size] ;
	}
	
	public static byte[] getKBbyte(int size) {
		return new byte[KB_SIZE * size] ;
	}
	
	public static byte[] getGBbyte(int size) {
		return new byte[GB_SIZE * size] ;
	}
	
	public static String getMBString(int size) {
		String data = "kylinsoong";
		while (data.length() < (size * MB_SIZE) -6) {
	        data += "kylinsoong";
	    }
		return data ;
	}
	
	public static String getKBString(int size) {
		String data = "kylinsoong";
		while (data.length() < (size * KB_SIZE) - 6) {
	        data += "kylinsoong";
	    }
		return data ;
	}
	
	public static String getGBString(int size) {
		String data = "kylinsoong";
		while (data.length() < (size * GB_SIZE) - 6) {
	        data += "kylinsoong";
	    }
		return data ;
	}

}
