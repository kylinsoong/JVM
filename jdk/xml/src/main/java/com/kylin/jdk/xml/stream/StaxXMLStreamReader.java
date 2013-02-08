package com.kylin.jdk.xml.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * What's this?
 *   Illustrate use The Cursor API read XML file, run StaxXMLStreamReader will read xml content and output to console
 * 
 * @author kylin
 *
 */
public class StaxXMLStreamReader {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError {
		StaxXMLStreamReader read = new StaxXMLStreamReader();
		List<Item> readConfig = read.readConfig("config-item.xml");
		for (Item item : readConfig) {
			System.out.println(item);
		}
	}
	
	public List<Item> readConfig(String configFile) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError {
		
		List<Item> items = new ArrayList<Item>();
		
		XMLStreamReader streamReader = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(configFile));
		
		
		return items ;
	}

}
