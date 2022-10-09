package parsers.jaxb;

import dao.ConcertDAO;
import dao.HallDAO;
import models.Artist;
import models.Concert;
import models.Country;
import models.Hall;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class JaxbParser {

    private static final Logger logger = LogManager.getLogger(JaxbParser.class);
    private static String basePath = "src\\main\\resources\\xml\\xmlclasses\\";

    public static void main(String[] args) throws JAXBException, IOException {
        try {

            objectToXML();

            String newXmlPath = basePath + "artistJaxb.xml";

            Artist unmarshalledArtist = xmlToArtist(newXmlPath);

            logger.info(unmarshalledArtist);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public static Artist xmlToArtist(String xmlPath) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Artist.class);
        return (Artist) context.createUnmarshaller().unmarshal(new FileReader(xmlPath));
    }

    public static void objectToXML() throws JAXBException, IOException, SQLException {

        Country country = new Country();
        country.setId(5);
        country.setDescription("France");

        Artist artist = new Artist();
        artist.setId(9);
        artist.setName("Pol Granch");
        artist.setCountry(country);

        Hall hall = new HallDAO().getById(1);

        JAXBContext hallContext = JAXBContext.newInstance(Hall.class);
        Marshaller hallContextMarshaller = hallContext.createMarshaller();
        hallContextMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        hallContextMarshaller.marshal(hall, new File(basePath + "hallJaxb.xml"));

        logger.info(hall);

        JAXBContext countryContext = JAXBContext.newInstance(Country.class);
        Marshaller countryMar = countryContext.createMarshaller();
        countryMar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        countryMar.marshal(country, new File(basePath + "countryJaxb.xml"));


        JAXBContext artistContext = JAXBContext.newInstance(Artist.class);
        Marshaller mar = artistContext.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(artist, new File(basePath + "artistJaxb.xml"));

        Concert concert = new ConcertDAO().getById(1);

        JAXBContext concertContext = JAXBContext.newInstance(Concert.class);
        Marshaller concertContextMarshaller = concertContext.createMarshaller();
        concertContextMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        concertContextMarshaller.marshal(concert, new File(basePath + "concertJaxb.xml"));


    }



}
