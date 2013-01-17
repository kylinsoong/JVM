package com.kylin.msc.stu;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Utility class providing commonly used test utilities.
 *
 * @author John E. Bailey
 */
public class Util {

    public static byte[] readBytes(final InputStream is) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            byte[] buff = new byte[1024];
            int read;
            while((read = is.read(buff)) > -1) {
                os.write(buff, 0, read);
            }
        } finally {
            is.close();
        }
        return os.toByteArray();
    }

    public static URL getResource(final Class<?> baseClass, final String path) throws Exception {
        final URL url = baseClass.getClassLoader().getResource(path);
        return url;
    }

    public static File getResourceFile(final Class<?> baseClass, final String path) throws Exception {
        return new File(getResource(baseClass, path).toURI());
    }

    public static <T> List<T> toList(Enumeration<T> enumeration) {
        final List<T> list = new ArrayList<T>();
        while(enumeration.hasMoreElements()) {
            list.add(enumeration.nextElement());
        }
        return list;
    }

    public static byte[] getClassBytes(final Class<?> aClass) throws Exception {
        final String resourcePath = getResourceNameOfClass(aClass);
        final File classFile = Util.getResourceFile(aClass, resourcePath);
        byte[] classBytes = Util.readBytes(new FileInputStream(classFile));
        return classBytes;
    }

    public static String getResourceNameOfClass(final Class<?> aClass) throws IllegalArgumentException {
        final String nameAsResourcePath = aClass.getName().replace('.', '/');
        final String resourceName = nameAsResourcePath + ".class";
        return resourceName;
    }

	public static File getResourceFile(String path) {
		return new File(path);
	}

}
