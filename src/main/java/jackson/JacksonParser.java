package jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JacksonParser {
    private static final Logger logger = LogManager.getLogger(JacksonParser.class);

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Country country = new Country(10,"Peru");

        Artist artist = new Artist(9,"Yma Sumac",country);

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/json/artistTest.json"), artist);

        File artistfile = new File("src/main/resources/json/artist.json");
        File concert = new File("src/main/resources/json/concert.json");
        File hall = new File("src/main/resources/json/hall.json");
        File staff = new File("src/main/resources/json/staff.json");
        File roleStaff = new File("src/main/resources/json/roleStaff.json");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //
        Artist artist1 = objectMapper.readValue(artistfile, Artist.class);
        Concert concert1 = objectMapper.readValue(concert, Concert.class);
        Hall hall1 = objectMapper.readValue(hall, Hall.class);
        Staff staff1 = objectMapper.readValue(staff, Staff.class);
        RoleStaff roleStaff1 = objectMapper.readValue(roleStaff, RoleStaff.class);


        logger.info("artist: " + artist1);
        logger.info("concert: " + concert1);
        logger.info("hall: " + hall1);
        logger.info("staff: " + staff1);
        logger.info("roleStaff: " + roleStaff1);

    }
}
