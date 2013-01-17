package com.kylin.msc.stu.test;

import java.io.File;

import org.jboss.modules.Resource;
import org.jboss.modules.ResourceLoader;
import org.jboss.modules.filter.PathFilter;
import org.jboss.modules.filter.PathFilters;

public class FileResourceLoaderTest extends AbstractResourceLoaderTest {
	
	private File resourceRoot;

	protected ResourceLoader createLoader(PathFilter exportFilter) throws Exception {
		
		resourceRoot = getResource("test/fileresourceloader");
		copyResource("com/kylin/msc/stu/Main.class", "test/fileresourceloader", "com/kylin/msc/stu");
		
		return null;
	}

	protected void assertResource(Resource resource, String fileName) {

	}
	
	public static void main(String[] args) throws Exception {
		FileResourceLoaderTest test = new FileResourceLoaderTest();
		
		ResourceLoader resourceLoader = test.createLoader(PathFilters.acceptAll());
	}

}
