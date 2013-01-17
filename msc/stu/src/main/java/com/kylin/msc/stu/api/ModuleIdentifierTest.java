package com.kylin.msc.stu.api;

import org.jboss.modules.ModuleIdentifier;

public class ModuleIdentifierTest {

	public static void main(String[] args) {

		ModuleIdentifier identifier = ModuleIdentifier.fromString("test.test");
		System.out.println(identifier);
	}

}
