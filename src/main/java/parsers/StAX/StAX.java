package parsers.StAX;// Java Code to implement StAX parser

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

public class StAX {
    public static final Logger logger = LogManager.getLogger(StAX.class.getName());
    private static boolean bcountryid, bcountryname;
    private static boolean bhallid, baddress, bcapacity, bname;

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        // Create a File object with appropriate xml file name
        File countryFile = new File("src/main/resources/xml/xmlclasses/country.xml");
        File hallFile = new File("src/main/resources/xml/xmlclasses/hall.xml");

        // Function for accessing the data
        logger.info("--- Parse COUNTRY XML file ---");
        parserCountries(countryFile);

        logger.info("--- Parse HALL XML file ---");
        parserHalls(hallFile);
    }

    public static void parserCountries(File file) throws FileNotFoundException, XMLStreamException {
        // Variables to make sure whether a element
        // in the xml is being accessed or not
        // if false that means elements is
        // not been used currently , if true the element or the
        // tag is being used currently

        bcountryid = bname = false;
        // Instance of the class which helps on reading tags
        XMLInputFactory factory = XMLInputFactory.newInstance();

        // Initializing the handler to access the tags in the XML file
        XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(file));

        // Checking the availability of the next tag
        while (eventReader.hasNext()) {
            // Event is actually the tag . It is of 3 types
            // <name> = StartEvent
            // </name> = EndEvent
            // data between the StartEvent and the EndEvent
            // which is Characters Event
            XMLEvent event = eventReader.nextEvent();

            // This will trigger when the tag is of type <...>
            if (event.isStartElement()) {
                StartElement element = (StartElement) event;

                // Iterator for accessing the metadata related
                // the tag started.
                // Here, it would name of the company
                Iterator<Attribute> iterator = element.getAttributes();
                while (iterator.hasNext()) {
                    Attribute attribute = iterator.next();
                    QName name = attribute.getName();
                    String value = attribute.getValue();
                    logger.info(name + " = " + value);
                }

                // Checking which tag needs to be opened for reading.
                // If the tag matches then the boolean of that tag
                // is set to be true.
                if (element.getName().toString().equalsIgnoreCase("country_id")) {
                    bcountryid = true;
                }
                if (element.getName().toString().equalsIgnoreCase("name")) {
                    bname = true;
                }
            }

            // This will be triggered when the tag is of type </...>
            if (event.isEndElement()) {
                EndElement element = (EndElement) event;

                // Checking which tag needs to be closed after reading.
                // If the tag matches then the boolean of that tag is
                // set to be false.
                if (element.getName().toString().equalsIgnoreCase("country_id")) {
                    bcountryid = false;
                }
                if (element.getName().toString().equalsIgnoreCase("name")) {
                    bname = false;
                }
            }

            // Triggered when there is data after the tag which is
            // currently opened.
            if (event.isCharacters()) {
                // Depending upon the tag opened the data is retrieved .
                Characters element = (Characters) event;
                if (bcountryid) {
                    logger.info("Country id: " + element.getData());
                }
                if (bname) {
                    logger.info("Country name: " + element.getData());
                }
            }
        }
    }

    public static void parserHalls(File file) throws FileNotFoundException, XMLStreamException {
        // Variables to make sure whether a element
        // in the xml is being accessed or not
        // if false that means elements is
        // not been used currently , if true the element or the
        // tag is being used currently

        bcountryid = bname = bcountryname = false;
        bhallid = baddress = bcapacity = false;

        // Instance of the class which helps on reading tags
        XMLInputFactory factory = XMLInputFactory.newInstance();

        // Initializing the handler to access the tags in the XML file
        XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(file));

        // Checking the availability of the next tag
        while (eventReader.hasNext()) {
            // Event is actually the tag . It is of 3 types
            // <name> = StartEvent
            // </name> = EndEvent
            // data between the StartEvent and the EndEvent
            // which is Characters Event
            XMLEvent event = eventReader.nextEvent();

            // This will trigger when the tag is of type <...>
            if (event.isStartElement()) {
                StartElement element = (StartElement) event;

                // Iterator for accessing the metadata related
                // the tag started.
                // Here, it would name of the company
                Iterator<Attribute> iterator = element.getAttributes();
                while (iterator.hasNext()) {
                    Attribute attribute = iterator.next();
                    QName name = attribute.getName();
                    String value = attribute.getValue();
                    logger.info(name + " = " + value);
                }

                // Checking which tag needs to be opened for reading.
                // If the tag matches then the boolean of that tag
                // is set to be true.
                if (element.getName().toString().equalsIgnoreCase("hall_id")) {
                    bhallid = true;
                }
                if (element.getName().toString().equalsIgnoreCase("name")) {
                    bname = true;
                }
                if (element.getName().toString().equalsIgnoreCase("address")) {
                    baddress = true;
                }
                if (element.getName().toString().equalsIgnoreCase("country_id")) {
                    bcountryid = true;
                }
                if (element.getName().toString().equalsIgnoreCase("country_name")) {
                    bcountryname = true;
                }
                if (element.getName().toString().equalsIgnoreCase("capacity")) {
                    bcapacity = true;
                }
            }

            // This will be triggered when the tag is of type </...>
            if (event.isEndElement()) {
                EndElement element = (EndElement) event;

                // Checking which tag needs to be closed after reading.
                // If the tag matches then the boolean of that tag is
                // set to be false.
                if (element.getName().toString().equalsIgnoreCase("hall_id")) {
                    bhallid = false;
                }
                if (element.getName().toString().equalsIgnoreCase("name")) {
                    bname = false;
                }
                if (element.getName().toString().equalsIgnoreCase("address")) {
                    baddress = false;
                }
                if (element.getName().toString().equalsIgnoreCase("country_id")) {
                    bcountryid = false;
                }
                if (element.getName().toString().equalsIgnoreCase("country_name")) {
                    bcountryname = false;
                }
                if (element.getName().toString().equalsIgnoreCase("capacity")) {
                    bcapacity = false;
                }
            }

            // Triggered when there is data after the tag which is
            // currently opened.
            if (event.isCharacters()) {
                // Depending upon the tag opened the data is retrieved .
                Characters element = (Characters) event;
                if (bhallid) {
                    logger.info("Hall id: " + element.getData());
                }
                if (bname) {
                    logger.info("Hall name: " + element.getData());
                }
                if (baddress) {
                    logger.info("Hall address:" + element.getData());
                }
                if (bcountryid) {
                    logger.info("Country id: " + element.getData());
                }
                if (bcountryname) {
                    logger.info("Country name: " + element.getData());
                }
                if (bcapacity) {
                    logger.info("Capacity: " + element.getData());
                }
            }
        }
    }
}
