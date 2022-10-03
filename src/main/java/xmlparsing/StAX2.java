package xmlparsing;

import models.*;
import javax.xml.namespace.QName;
import javax.xml.stream.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//Source: https://www.w3schools.blog/java-stax-xmlstreamreader-example

public class StAX2 {

    public static void main(String[] args) {
        String concertPath= "src/main/resources/xml/xmlclasses/concert.xml";
        writeXML(concertPath);

        try {
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter outputWriter = outputFactory.createXMLStreamWriter(new FileOutputStream(concertPath));

            Concert concert1 = new Concert();

            Country usa = new Country();
            usa.setId(2);
            usa.setDescription("USA");

            Artist artist1 = new Artist();
            artist1.setId(1);
            artist1.setName("Dua Lipa");
            artist1.setCountry(usa);

            Country mexico = new Country();
            mexico.setId(3);
            mexico.setDescription("Mexico");

            Artist artist2 = new Artist();
            artist2.setId(2);
            artist2.setName("Rosalia");
            artist2.setCountry(mexico);


            List<Artist> artistList = new ArrayList<>();
            artistList.add(artist1);
            artistList.add(artist2);

            RoleStaff roleStaff1 = new RoleStaff();
            roleStaff1.setId(1);
            roleStaff1.setDescription("receptionist");

            Staff staff1 = new Staff();
            staff1.setId(1);
            staff1.setDocumentNo(22222222);
            staff1.setName("Nahuel");
            staff1.setLastName("Perez");
            staff1.setRoleStaff(roleStaff1);

            RoleStaff roleStaff2 = new RoleStaff();
            roleStaff2.setId(2);
            roleStaff2.setDescription("light manager");

            Staff staff2 = new Staff();
            staff2.setId(2);
            staff2.setDocumentNo(44444444);
            staff2.setName("Damian");
            staff2.setLastName("Salut");
            staff2.setRoleStaff(roleStaff2);

            List<Staff> staffList = new ArrayList<>();
            staffList.add(staff1);
            staffList.add(staff2);

            Country england = new Country();
            england.setId(4);
            england.setDescription("England");

            Hall hall1 = new Hall();
            hall1.setId(1);
            hall1.setName("Royal Albert Hall");
            hall1.setAddress("Penelope St. 145");
            hall1.setCapacity(10000);
            hall1.setCountry(england);


            concert1.setId(1);
            concert1.setDateConcert("2022-10-10");
            concert1.setStartTime("09:00:00");
            concert1.setHall(hall1);
            concert1.setArtists(artistList);
            concert1.setStaffs(staffList);

            pojoToXML(concert1, outputWriter);
            outputWriter.flush();
            outputWriter.close();

            readXML(concertPath);
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readXML(String path) {
        try {
            Reader reader = new FileReader(path);
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader xmlReader = inputFactory.createXMLStreamReader(reader);

            while (xmlReader.hasNext()) {
                int event = xmlReader.next();

                if (event == XMLStreamConstants.START_ELEMENT) {
                    System.out.println("Start element:" + xmlReader.getLocalName());
                    int attributes = xmlReader.getAttributeCount();
                    for (int i = 0; i < attributes; i++) {
                        QName name = xmlReader.getAttributeName(i);
                        String value = xmlReader.getAttributeValue(i);
                        System.out.println("Attribute name :" + name);
                        System.out.println("Attribute value :" + value);
                    }
                }
                if (event == XMLStreamConstants.END_ELEMENT) {
                    System.out.println("End element: " + xmlReader.getLocalName());
                }

            }
        } catch (FileNotFoundException | XMLStreamException e) {
            System.out.println(e);
        }
    }

    public synchronized static void writeXML(String path) {
        try {
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter outputWriter = outputFactory.createXMLStreamWriter(new FileOutputStream(path));
            outputWriter.writeStartDocument("UTF-8", "1.0");
            // Create concert
            outputWriter.writeStartElement("Concert");
            outputWriter.writeEndElement();
            outputWriter.flush();
            outputWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public synchronized static void pojoToXML(Concert concert, XMLStreamWriter outputWriter) throws FileNotFoundException, XMLStreamException {
        outputWriter.writeStartElement("Concert");
        outputWriter.writeAttribute("Id", String.valueOf(concert.getId()));

        // pojoToXML(concert.getArtists(), outputWriter);

        outputWriter.writeStartElement("Date");
        outputWriter.writeCharacters(concert.getDateConcert().toString());
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("StarTime");
        outputWriter.writeCharacters(concert.getStartTime().toString());
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("HallId");
        outputWriter.writeCharacters(String.valueOf(concert.getHall().getId()));
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("HallName");
        outputWriter.writeCharacters(concert.getHall().getName());
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("HallAddress");
        outputWriter.writeCharacters(concert.getHall().getAddress());
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("HallCapacity");
        outputWriter.writeCharacters(String.valueOf(concert.getHall().getCapacity()));
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("HallCountryId");
        outputWriter.writeCharacters(String.valueOf(concert.getHall().getCountry().getId()));
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("HallCountryName");
        outputWriter.writeCharacters(String.valueOf(concert.getHall().getCountry().getDescription()));
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("HallCapacity");
        outputWriter.writeCharacters(String.valueOf(concert.getHall().getCapacity()));
        outputWriter.writeEndElement();



        outputWriter.writeStartElement("Artists");
        for (Artist artist : concert.getArtists()) {
            pojoToXML(artist, outputWriter);
        }
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("Staffs");
        for (Staff staff : concert.getStaffs()) {
            pojoToXML(staff, outputWriter);
        }
        outputWriter.writeEndElement();
        outputWriter.writeEndElement();
    }

    public synchronized static void pojoToXML(Artist artist, XMLStreamWriter outputWriter) throws FileNotFoundException, XMLStreamException {
        outputWriter.writeStartElement("Artist");
        outputWriter.writeAttribute("Id", String.valueOf(artist.getId()));

        outputWriter.writeStartElement("Name");
        outputWriter.writeCharacters(artist.getName());
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("CountryId");
        outputWriter.writeCharacters(String.valueOf(artist.getCountry().getId()));
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("CountryName");
        outputWriter.writeCharacters(String.valueOf(artist.getCountry().getDescription()));
        outputWriter.writeEndElement();

        outputWriter.writeEndElement();
    }

    public synchronized static void pojoToXML(Staff staff, XMLStreamWriter outputWriter) throws FileNotFoundException, XMLStreamException {
        outputWriter.writeStartElement("Staff");
        outputWriter.writeAttribute("Id", String.valueOf(staff.getId()));

        outputWriter.writeStartElement("Name");
        outputWriter.writeCharacters(staff.getName());
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("LastName");
        outputWriter.writeCharacters(staff.getLastName());
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("Document_no");
        outputWriter.writeCharacters(String.valueOf(staff.getDocumentNo()));
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("StaffRoleId");
        outputWriter.writeCharacters(String.valueOf(staff.getRoleStaff().getId()));
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("StaffRoleDescription");
        outputWriter.writeCharacters(staff.getRoleStaff().getDescription());
        outputWriter.writeEndElement();

        outputWriter.writeEndElement();
    }


}