package com.kylin.jdk.xml.stream;

import java.io.FileOutputStream;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * What's this?
 *   Illustrate use The Event Iterator API write XML file, run StaxXMLEventWriter will generate a XML file item.xml
 * 
 * @author kylin
 *
 */
public class StaxXMLEventWriter {

	private String configFile;

	public void setFile(String configFile) {
		this.configFile = configFile;
	}
	
	public void saveConfig() throws Exception {
	    
		// Create XMLEventWriter
		XMLEventWriter eventWriter = XMLOutputFactory.newInstance().createXMLEventWriter(new FileOutputStream(configFile));
		
		// Create a EventFactory
	    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
	    XMLEvent end = eventFactory.createDTD("\n");
	    
		// Create and write Start Tag
	    StartDocument startDocument = eventFactory.createStartDocument();
	    eventWriter.add(startDocument);
	    eventWriter.add(end);
	    
		// Create config open tag
	    StartElement configStartElement = eventFactory.createStartElement("", "", "config");
	    eventWriter.add(configStartElement);
	    eventWriter.add(end);
	    
		// Write the different nodes
	    createNode(eventWriter, "mode", "1", eventFactory);
	    createNode(eventWriter, "unit", "901", eventFactory);
	    createNode(eventWriter, "current", "0", eventFactory);
	    createNode(eventWriter, "interactive", "0", eventFactory);
	    
	    eventWriter.add(eventFactory.createEndElement("", "", "config"));
	    eventWriter.add(end);
	    eventWriter.add(eventFactory.createEndDocument());
	    eventWriter.close();
	}
	
	private void createNode(XMLEventWriter eventWriter, String name, String value, XMLEventFactory eventFactory) throws XMLStreamException {

		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");
		
		// Create Start node
		StartElement sElement = eventFactory.createStartElement("", "", name);
		eventWriter.add(tab);
		eventWriter.add(sElement);
		
		// Create Content
		Characters characters = eventFactory.createCharacters(value);
		eventWriter.add(characters);
		
		// Create End node
		EndElement eElement = eventFactory.createEndElement("", "", name);
		eventWriter.add(eElement);
		eventWriter.add(end);
	}

	public static void main(String[] args) {

		StaxXMLEventWriter configFile = new StaxXMLEventWriter();
	    configFile.setFile("item.xml");
	    try {
	      configFile.saveConfig();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}

}
