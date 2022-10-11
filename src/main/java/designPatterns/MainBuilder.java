package designPatterns;

import models.Artist;
import models.BandMember;
import models.Country;
import models.Instrument;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MainBuilder {
    public static final Logger logger = LogManager.getLogger(MainBuilder.class.getName());

    public static void main(String[] args) {

        Artist artist = Artist.builder()
                .withId(5)
                .withName("Julian")
                .withCountry(Country.builder()
                        .withId(1)
                        .withDesc("Argentina")
                        .build())
                .build();

        logger.info(artist);

        BandMember bandMember = BandMember.builder()
                .withId(1)
                .withDocumentNo(123)
                .withName("John")
                .withLastName("Doe")
                .withInstrument(Instrument.builder()
                        .withId(1)
                        .withName("Guitar")
                        .build())
                .withArtist(Artist.builder()
                        .withId(1)
                        .withName("Dua Lipa")
                        .withCountry(Country.builder()
                                .withId(1)
                                .withDesc("USA")
                                .build())
                        .build())
                .build();

        logger.info(bandMember);


    }
}
