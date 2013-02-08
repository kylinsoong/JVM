package com.kylin.jdk.xml.stream;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * What's this?
 *   Illustrate use The Cursor API write XML file, run StaxXMLStreamWriter will generate a XML file employee.xml
 * 
 * @author kylin
 *
 */
public class StaxXMLStreamWriter {

	public static void main(String[] args) throws XMLStreamException, Exception {

		String fileName = "employee.xml";
        String rootElement = "employee";
        StaxXMLStreamWriter xmlStreamWriter = new StaxXMLStreamWriter();
        Map<String,String> elementsMap = new HashMap<String, String>();
        elementsMap.put("id", "100");
        elementsMap.put("name", "Kylin Soong");
        elementsMap.put("age", "28");
        elementsMap.put("role", "Java Developer");
        elementsMap.put("gender", "Male");
        xmlStreamWriter.writeXML(fileName, rootElement, elementsMap);
	}

	private void writeXML(String fileName, String rootElement, Map<String, String> elementsMap) throws Exception, XMLStreamException {

		XMLStreamWriter xmlStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
	
		//start writing xml file
        xmlStreamWriter.writeStartDocument("UTF-8", "1.0");
        xmlStreamWriter.writeCharacters("\n");
        xmlStreamWriter.writeStartElement(rootElement);
		xmlStreamWriter.writeAttribute("id", elementsMap.get("id"));
		
		xmlStreamWriter.writeCharacters("\n\t");
        xmlStreamWriter.writeStartElement("name");
        xmlStreamWriter.writeCharacters("\n\t\t"+elementsMap.get("name"));
        xmlStreamWriter.writeCharacters("\n\t");
        xmlStreamWriter.writeEndElement();
        
        xmlStreamWriter.writeCharacters("\n\t");
        xmlStreamWriter.writeStartElement("age");
        xmlStreamWriter.writeCharacters("\n\t\t"+elementsMap.get("age"));
        xmlStreamWriter.writeCharacters("\n\t");
        xmlStreamWriter.writeEndElement();
        
        xmlStreamWriter.writeCharacters("\n\t");
        xmlStreamWriter.writeStartElement("gender");
        xmlStreamWriter.writeCharacters("\n\t\t"+elementsMap.get("gender"));
        xmlStreamWriter.writeCharacters("\n\t");
        xmlStreamWriter.writeEndElement();
        
        xmlStreamWriter.writeCharacters("\n\t");
        xmlStreamWriter.writeStartElement("role");
        xmlStreamWriter.writeCharacters("\n\t\t"+elementsMap.get("role"));
        xmlStreamWriter.writeCharacters("\n\t");
        xmlStreamWriter.writeEndElement();
        
		// write end tag of Employee element
        xmlStreamWriter.writeCharacters("\n");
        xmlStreamWriter.writeEndElement();
        
		// write end document
        xmlStreamWriter.writeEndDocument();
         
        //flush data to file and close writer
        xmlStreamWriter.flush();
        xmlStreamWriter.close();
	}

}
