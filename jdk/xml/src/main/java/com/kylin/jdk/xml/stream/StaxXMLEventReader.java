package com.kylin.jdk.xml.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * What's this?
 *   Illustrate use The Event Iterator API read XML file, run StaxXMLEventReader will read xml content and output to console
 * 
 * 
 * @author kylin
 *
 */
public class StaxXMLEventReader {

	static final String DATE = "date";
	static final String ITEM = "item";
	static final String MODE = "mode";
	static final String UNIT = "unit";
	static final String CURRENT = "current";
	static final String INTERACTIVE = "interactive";

	public List<Item> readConfig(String configFile) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError  {

		List<Item> items = new ArrayList<Item>();
		
		XMLEventReader eventReader = XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream(configFile));
		
		Item item = null;
		while (eventReader.hasNext()) {
			XMLEvent event = eventReader.nextEvent();

			if (event.isStartElement()) {
				StartElement startElement = event.asStartElement();
				// If we have a item element we create a new item
				if (startElement.getName().getLocalPart() == (ITEM)) {
					item = new Item();
					// We read the attributes from this tag and add the date
					// attribute to our object
					Iterator<Attribute> attributes = startElement.getAttributes();
							
					while (attributes.hasNext()) {
						Attribute attribute = attributes.next();
						if (attribute.getName().toString().equals(DATE)) {
							item.setDate(attribute.getValue());
						}

					}
				}

				if (event.isStartElement()) {
					if (event.asStartElement().getName().getLocalPart().equals(MODE)) {
						event = eventReader.nextEvent();
						item.setMode(event.asCharacters().getData());
						continue;
					}
				}
				
				if (event.asStartElement().getName().getLocalPart().equals(UNIT)) {
					event = eventReader.nextEvent();
					item.setUnit(event.asCharacters().getData());
					continue;
				}

				if (event.asStartElement().getName().getLocalPart().equals(CURRENT)) {
					event = eventReader.nextEvent();
					item.setCurrent(event.asCharacters().getData());
					continue;
				}

				if (event.asStartElement().getName().getLocalPart().equals(INTERACTIVE)) {
					event = eventReader.nextEvent();
					item.setInteractive(event.asCharacters().getData());
					continue;
				}
			}
			// If we reach the end of an item element we add it to the list
			if (event.isEndElement()) {
				EndElement endElement = event.asEndElement();
				if (endElement.getName().getLocalPart() == (ITEM)) {
					items.add(item);
				}
			}
		}
		
		return items;
	}
	
	public static void main(String args[]) throws Exception {
		StaxXMLEventReader read = new StaxXMLEventReader();
		List<Item> readConfig = read.readConfig("config-item.xml");
		for (Item item : readConfig) {
			System.out.println(item);
		}
	}
}
