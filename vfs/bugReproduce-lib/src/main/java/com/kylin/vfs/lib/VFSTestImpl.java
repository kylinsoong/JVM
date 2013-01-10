package com.kylin.vfs.lib;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class VFSTestImpl {
	
	private static final Logger log = Logger.getLogger(VFSTestImpl.class);

	public VFSTestImpl()  {
		
		try {
			URL source = getClass().getProtectionDomain().getCodeSource().getLocation();
			
			log.info("vfs source: " + source);
			
			String extForm = source.toExternalForm();
			
			if (extForm.startsWith("vfs:")) {
				extForm = extForm.replaceFirst("vfs", "file");
			}
			
			source = new URL(source, canonicalize(extForm));
			
			log.info("file source: " + source);
			
			source.openStream();
		} catch (Exception e) {
			throw new RuntimeException("", e);
		}

	}
	
	 private  String canonicalize(String url) throws MalformedURLException {
		String[] urlParts = url.split("\\/");

		List retainedParts = new ArrayList();

		for (String part : urlParts) {
			if (part.equals(".")) {
				continue;
			}
			if (part.equals("..")) {
				if (retainedParts.isEmpty())
					throw new MalformedURLException(url + " has too many \"..\" parts");
				retainedParts.remove(retainedParts.size() - 1);
			} else {
				retainedParts.add(part);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < retainedParts.size(); i++) {
			sb.append((String) retainedParts.get(i));
			if (i < retainedParts.size() - 1) {
				sb.append("/");
			}
		}

		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		new VFSTestImpl();
		
		System.out.println("DONE");
	}
}
