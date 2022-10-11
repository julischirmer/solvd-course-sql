package models;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Ticket")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("Ticket")
public class Ticket {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "cost")
    private double cost;
    @XmlElement(name = "rowLetter")
    private String rowLetter;
    @XmlElement(name = "seatNo")
    private int seatNo;
    @XmlElement(name = "sector")
    private String sector;
    @XmlElement(name = "booking")
    private Booking booking;
    @XmlElement(name = "concert")
    private Concert concert;


    public Ticket() {

    }

    public Ticket(int id, double cost, String rowLetter, int seatNo, String sector, Booking booking, Concert concert) {
        this.id = id;
        this.cost = cost;
        this.rowLetter = rowLetter;
        this.seatNo = seatNo;
        this.sector = sector;
        this.booking = booking;
        this.concert = concert;


    }

    public Ticket(double cost, String rowLetter, int seatNo, String sector, Booking booking, Concert concert) {
        this.cost = cost;
        this.rowLetter = rowLetter;
        this.seatNo = seatNo;
        this.sector = sector;
        this.booking = booking;
        this.concert = concert;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public String getRowLetter() {
        return rowLetter;
    }

    public void setRowLetter(String rowLetter) {
        this.rowLetter = rowLetter;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    @Override
    public String toString() {
        return "\nTicket{" +
                "id=" + id +
                ", cost=" + cost +
                ", rowLetter='" + rowLetter + '\'' +
                ", seatNo=" + seatNo +
                ", sector='" + sector + '\'' +
                ", booking=" + booking +
                ", concert=" + concert +
                '}';
    }
}
