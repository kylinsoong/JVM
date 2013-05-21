package com.kylin.jvm.highcpu;

import com.kylin.jvm.highcpu.tools.HighCUPTools;

public class Runner {

	public static void main(String[] args) {
		
		if(args.length != 2) {
			usage();
		}
		
		try {
			if(args[0].compareTo("D2H") == 0) {
				System.out.println(HighCUPTools.decimalToHexadecimal(Integer.parseInt(args[1])));
			}
		} catch (Exception e) {
			usage();
		}
	}

	private static void usage() {
		System.out.println("Run application like <Option> <parameter>");
		System.out.println("	java -jar jvm-highcpu-tools.jar D2H 1000  - this convert Decimal 1000 to Hexadecimal");
		Runtime.getRuntime().exit(0);
	}

}
