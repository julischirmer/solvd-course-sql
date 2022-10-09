package parsers.StAX;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.stax.StAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class XSDValidation {
    private static final Logger logger = LogManager.getLogger(XSDValidation.class);

    public static void main(String[] args) {
        String xsdPath = "src/main/resources/xml/xsdclasses/country.xsd";
        String xmlPath = "src/main/resources/xml/xmlclasses/country.xml";

        logger.info("XSD file: " + xsdPath);
        logger.info("XML file: " + xmlPath);

        if (StAXValidator(xsdPath, xmlPath)) {
            logger.log(Level.getLevel("SUCCESS"), (xmlPath + " is valid XML."));
        } else {
            logger.warn(xmlPath + " is not valid XML.");
        }
    }

    public static boolean StAXValidator(String xsdPath, String xmlPath) {
        try {
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(xmlPath));
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema xsd = factory.newSchema(new File(xsdPath));

            Validator validator = xsd.newValidator();
            validator.validate(new StAXSource(reader));
        } catch (IOException | SAXException | XMLStreamException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
