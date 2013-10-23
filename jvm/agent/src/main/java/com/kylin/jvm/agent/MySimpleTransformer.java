package com.kylin.jvm.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class MySimpleTransformer implements ClassFileTransformer {

	public byte[] transform(  ClassLoader loader
							, String className
							, Class<?> classBeingRedefined
							, ProtectionDomain protectionDomain
							, byte[] classfileBuffer) throws IllegalClassFormatException {
		
		if(!className.endsWith("Main")){
			return(null);  
		}
  
        String line = "";  
        for(int i=0; i < classfileBuffer.length;i++){          
            line += Byte.toString(classfileBuffer[i]) + " ";  
			if (line.length() > 60) {
//				System.out.println(line);
				line = "";
			} 
            if(classfileBuffer[i] == (byte)'6'){
            	classfileBuffer[i] = (byte)'7';  
            }
		}
//		System.out.println(line); 
//        System.out.println("The number of bytes in Main: " + classfileBuffer.length);  
        return(classfileBuffer);
	}

}
