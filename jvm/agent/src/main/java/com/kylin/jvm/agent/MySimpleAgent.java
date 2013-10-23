package com.kylin.jvm.agent;

import java.lang.instrument.Instrumentation;


public class MySimpleAgent {
	

	public static void premain(String arg, Instrumentation inst) throws Exception {
		inst.addTransformer(new MySimpleTransformer());
	}

}
