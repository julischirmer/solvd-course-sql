package myBatis;

import dao.BandMemberDAO;
import dao.CountryDAO;
import dao.HallDAO;
import dao.IDAO;
import models.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainMyBatis {
    private static final Logger logger = LogManager.getLogger(MainMyBatis.class);

    public static void main(String[] args) throws IOException, SQLException {
        try {

            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();

            IArtistDAO artistDAO = session.getMapper(IArtistDAO.class);
            Artist artist=artistDAO.getById(1);
            logger.info("artist: "+ artist);
            ArrayList<Artist> artists= (ArrayList<Artist>) artistDAO.getAll();
            logger.info("artists: "+ artists);

            Country country = new Country();
            country.setId(3);
            Artist artist1=new Artist(9,"artist1",country);
            //artistDAO.insert(artist1);

            //artistDAO.update(artist1);
            //artistDAO.deleteById(9);

            IBandMemberDAO bandMemberDAO = session.getMapper(IBandMemberDAO.class);
            BandMember bandMember=bandMemberDAO.getById(1);
            logger.info("bandMember: "+ bandMember);

            ArrayList<BandMember> bandMembers= (ArrayList<BandMember>) bandMemberDAO.getAll();
            logger.info("bandMembers: "+ bandMembers);

            Instrument instrument = new Instrument();
            instrument.setId(1);

            Artist artist2=new Artist();
            artist2.setId(1);
            BandMember bandMember1=new BandMember(10,999,"bandMember1","bandMember1",instrument,artist2);

            IBookingDAO bookingDAO = session.getMapper(IBookingDAO.class);
            logger.info("booking: "+ bookingDAO.getById(1));
            logger.info("bookings: "+ bookingDAO.getAll());

            Booking booking = new Booking();
            booking.setId(4);
            booking.setDateBook("2019-10-10");
            Customer customer = new Customer();
            customer.setId(1);
            booking.setCustomer(customer);
            Payment payment = new Payment();
            payment.setId(1);
            booking.setPayment(payment);
            //bookingDAO.insert(booking);
            //bookingDAO.update(booking);
            //bookingDAO.deleteById(4);

            IConcertDAO concertDAO = session.getMapper(IConcertDAO.class);
            logger.info("concert: "+ concertDAO.getById(1));
            logger.info("concerts: "+ concertDAO.getAll());

            IHallDAO hallDAO = session.getMapper(IHallDAO.class);
            logger.info("hall: "+ hallDAO.getById(1));
            logger.info("halls: "+ hallDAO.getAll());

            IInstrumentDAO instrumentDAO = session.getMapper(IInstrumentDAO.class);
            logger.info("instrument: "+ instrumentDAO.getById(1));
            logger.info("instruments: "+ instrumentDAO.getAll());

            IPaymentDAO paymentDAO = session.getMapper(IPaymentDAO.class);
            logger.info("payment: "+ paymentDAO.getById(1));
            logger.info("payments: "+ paymentDAO.getAll());

            IRoleStaffDAO roleStaffDAO = session.getMapper(IRoleStaffDAO.class);
            logger.info("roleStaff: "+ roleStaffDAO.getById(1));
            logger.info("roleStaffs: "+ roleStaffDAO.getAll());

            ITicketDAO ticketDAO = session.getMapper(ITicketDAO.class);
            logger.info("ticket: "+ ticketDAO.getById(1));
            logger.info("tickets: "+ ticketDAO.getAll());

            session.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
}
