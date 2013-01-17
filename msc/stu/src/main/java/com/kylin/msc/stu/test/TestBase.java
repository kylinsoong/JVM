package com.kylin.msc.stu.test;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.jboss.modules.Module;
import org.jboss.modules.ModuleIdentifier;
import org.jboss.modules.log.StreamModuleLogger;

import com.kylin.msc.stu.Util;

public class TestBase {
	
	static {
		Module.setModuleLogger(new StreamModuleLogger(System.err));
	}
	
	protected static final ModuleIdentifier MODULE_ID = ModuleIdentifier.fromString("test.test");

	protected File getResource(final String path) throws Exception {
        return Util.getResourceFile(getClass(), path);
    }
	
	protected void copyResource(final String inputResource, final String outputBase, final String outputPath) throws Exception {
        final File resource = getResource(inputResource);
        final File outputDirectory = new File(getResource(outputBase), outputPath);

        if(!resource.exists())
            throw new IllegalArgumentException("Resource does not exist");
        if (outputDirectory.exists() && outputDirectory.isFile())
            throw new IllegalArgumentException("OutputDirectory must be a directory");
        if (!outputDirectory.exists()) {
            if (!outputDirectory.mkdirs())
                throw new RuntimeException("Failed to create output directory");
        }
        final File outputFile = new File(outputDirectory, resource.getName());
        final InputStream in = new FileInputStream(resource);
        try {
            final OutputStream out = new FileOutputStream(outputFile);
            try {
                final byte[] b = new byte[8192];
                int c;
                while ((c = in.read(b)) != -1) {
                    out.write(b, 0, c);
                }
                out.close();
                in.close();
            } finally {
                safeClose(out);
            }
        } finally {
            safeClose(in);
        }
    }
	
	private static void safeClose(final Closeable closeable) {
        if (closeable != null) try {
            closeable.close();
        } catch (IOException e) {
            // meh
        }
    }
}
