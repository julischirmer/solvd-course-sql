package dao;

import dao.ArtistDAO;
import models.*;

import javax.management.relation.Role;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class MainDAO {
    public static void main(String[] args) {
        Country country = new Country();
        country.setId(1);

        Artist artist = new Artist(7,"Los Palmeras",country);




        try{
            ArtistDAO artistdao = new ArtistDAO();
            // artistdao.insert(artist);
            // System.out.println(artistdao.getById(1));
            // Artist artistupd = new Artist(10,"Midachi",country);
            // artistdao.update(10,artistupd);
            //artistdao.deleteById(10);
            // System.out.println(artistdao.getAll());
        } catch (SQLException e){
            System.out.println(e);
        }

        try{
             CountryDAO countrydao = new CountryDAO();
            // Country countrypak = new Country();
            // countrypak.setDescription("Peru");
            // countrydao.insert(countryperu);
            // System.out.println(countrydao.getById(5));
            // System.out.println(countrydao.getAll());
            // countrydao.deleteById(5);
            // countrydao.update(6, countrypak);

        } catch (SQLException e){
            System.out.println(e);
        }

        try{
            RoleStaffDAO rolestaffdao = new RoleStaffDAO();
            RoleStaff roleStaff = new RoleStaff();
            roleStaff.setId(5);
            // roleStaff.setDescription("Saler");
            // rolestaffdao.insert(roleStaff);
            roleStaff.setDescription("Saler 2");
            // rolestaffdao.update(5,roleStaff);
            // System.out.println(rolestaffdao.getAll());
            // System.out.println(rolestaffdao.getById(5));
            // rolestaffdao.deleteById(5);
        } catch (SQLException e){
            System.out.println(e);
        }

        try{
            PaymentDAO paymentDAO = new PaymentDAO();
            Payment payment = new Payment();
            payment.setTypePay("Dolares");
            // paymentDAO.insert(payment);

            // paymentDAO.update(4,payment);
            // System.out.println(paymentDAO.getById(4));
            // System.out.println(paymentDAO.getAll());
            // paymentDAO.deleteById(4);

        } catch (SQLException e){
            System.out.println(e);
        }

        try{

            Customer customer =
                    new Customer(41947000,"Prueba Name", "Prueba ln", "Prueba addres","20221001" ,"@rpeuba.com");
            CustomerDAO customerDAO = new CustomerDAO();
            // customerDAO.insert(customer);
            // customerDAO.update(7,customer);
            // System.out.println(customerDAO.getAll());
            // System.out.println(customerDAO.getById(7));
        } catch (SQLException e){
            System.out.println(e);
        }

        try{
            RoleStaff roleStaff = new RoleStaff(1,"recepcionist");
            Staff staff = new Staff(555,"Julian", "Ricardo",roleStaff);
            StaffDAO staffDAO = new StaffDAO();
            // staffDAO.insert(staff);
            // System.out.println(staffDAO.getAll());
            //System.out.println(staffDAO.getById(1));

        } catch (SQLException e){
            System.out.println(e);
        }

        try{
            Country countryarg = new Country(1, "Argentina");

            Hall hall = new Hall("Arg estadio","address arg",15000,countryarg);
            HallDAO hallDAO = new HallDAO();
            // hallDAO.insert(hall);
            // hallDAO.update(6,hall);
            // System.out.println(hallDAO.getAll());
            // System.out.println(hallDAO.getById(1));

        } catch (SQLException e){
            System.out.println(e);
        }

        try{
            BandMemberDAO bandMemberDAO = new BandMemberDAO();
            // System.out.println(bandMemberDAO.getAll());
            //System.out.println(bandMemberDAO.getById(2));
            // Probar insert y update

        } catch (SQLException e){
            System.out.println(e);
        }

        try{
            BookingDAO bookingDAO = new BookingDAO();
            // System.out.println(bookingDAO.getAll());
            //System.out.println(bookingDAO.getById(1));


        } catch (SQLException e){
            System.out.println(e);
        }

        try{
            ConcertDAO concertDAO = new ConcertDAO();
            //System.out.println(concertDAO.getAll());
            // System.out.println(concertDAO.getById(1));


        } catch (SQLException e){
            System.out.println(e);
        }

        try{
            TicketDAO ticketDAO = new TicketDAO();
            Booking booking = new Booking();
            booking.setId(1);
            Concert concert = new Concert();
            concert.setId(2);

            Ticket ticket = new Ticket(350.8,"A",45,"Gold",booking,concert);
            // ticketDAO.insert(ticket);
            // ticketDAO.update(5,ticket);
            // ticketDAO.deleteById(5);
            // System.out.println(ticketDAO.getAll());
            // System.out.println(ticketDAO.getById(1));

        } catch (SQLException e){
            System.out.println(e);
        }


    }

}
