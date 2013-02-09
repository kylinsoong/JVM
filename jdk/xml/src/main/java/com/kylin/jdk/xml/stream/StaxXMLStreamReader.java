package com.kylin.jdk.xml.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
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
		Employee employee = read.readConfig("employee.xml");
		System.out.println(employee);
	}
	
	public Employee readConfig(String configFile) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError {
		
		Employee employee = new Employee();
		
		XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(configFile));
		
		
		while (true) {
			
			if(reader.getEventType() == XMLStreamConstants.END_DOCUMENT) {
				break;
			}
			
			if(reader.getEventType() == XMLStreamConstants.START_ELEMENT) {
				
				String cursor = reader.getLocalName();
				
				if(cursor.equals("employee")) {
					String value = reader.getAttributeValue(0);
					employee.setId(value);
				} else if(cursor.equals("name")) {
					reader.next();
					String value = reader.getText();
					employee.setName(value.trim());
				} else if(cursor.equals("age")) {
					reader.next();
					String value = reader.getText();
					employee.setAge(value.trim());
				} else if(cursor.equals("gender")){
					reader.next();
					String value = reader.getText();
					employee.setGender(value.trim());
				} else if(cursor.equals("role")) {
					reader.next();
					String value = reader.getText();
					employee.setRole(value.trim());
				}
			}
			
			reader.next();
		}
		
		return employee ;
	}

}
