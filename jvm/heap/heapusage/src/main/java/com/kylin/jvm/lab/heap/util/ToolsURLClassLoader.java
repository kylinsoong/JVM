package com.kylin.jvm.lab.heap.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class ToolsURLClassLoader extends URLClassLoader {
	

	public ToolsURLClassLoader(ClassLoader parent) {
		super(new URL[] { }, parent);
	}
	
	public void loadDependencyJars(String folder) {

        List<URL>list = new ArrayList<URL>();

        try {
			File file = new File(folder);
			File[] sub = file.listFiles();
			for (int i = 0; i < sub.length; i++) {

				if (sub[i].getAbsolutePath().endsWith(".jar")) {
					list.add(sub[i].toURL());
				} else if (sub[i].isDirectory()) {
					addToList(sub[i], list);
				}
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("load " + folder + " jar error", e);
		}

//		addURLs(list);
	}

	private void addToList(File file, List<URL> list) throws MalformedURLException {
		for(File f : file.listFiles()){
			if(f.isDirectory()) {
				addToList(f, list);
			} else if(f.getAbsolutePath().endsWith(".jar")){
				System.out.println("loading file: " + f);
				addURL(f.toURL());
			}
		}
	}

	private void addURLs(List<URL> urls) {
		
		final int size = urls.size();
		
		for (int i = 0; i < size; i++) {
			// ensure that urls does not contain spaces
			String s = urls.get(i).toString().replaceAll(" ", "%20");

			System.out.println("Adding to path: " + s);

			try {
				addURL(new URL(s));
			} catch (MalformedURLException e) {
				throw new RuntimeException(s + " url is not a well formed url");
			}

		}

	}

}
