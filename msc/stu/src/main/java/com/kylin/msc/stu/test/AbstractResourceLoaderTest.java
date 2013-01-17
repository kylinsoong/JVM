package com.kylin.msc.stu.test;

import org.jboss.modules.Resource;
import org.jboss.modules.ResourceLoader;
import org.jboss.modules.filter.PathFilter;
import org.jboss.modules.filter.PathFilters;

public abstract class AbstractResourceLoaderTest extends TestBase {
	
	protected ResourceLoader loader;
	
	public void init() throws Exception {
		loader = createLoader(PathFilters.acceptAll());
	}
	
	protected abstract ResourceLoader createLoader(final PathFilter exportFilter) throws Exception;
   
	protected abstract void assertResource(final Resource resource, final String fileName);

}
