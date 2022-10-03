package models;

import com.fasterxml.jackson.annotation.JsonRootName;
import dao.BandMemberDAO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BandMember")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("BandMember")
public class BandMember {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "documentNo")
    private int documentNo;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "lastName")
    private String lastName;
    @XmlElement(name = "instrument")
    private Instrument instrument;
    @XmlElement(name = "artist")
    private Artist artist;

    public BandMember(){

    }

    public BandMember(int id, int documentNo, String name, String lastName, Instrument instrument, Artist artist){
        this.id = id;
        this.documentNo = documentNo;
        this.name = name;
        this.lastName = lastName;
        this.instrument = instrument;
        this.artist = artist;
    }

    public BandMember(int documentNo, String name, String lastName, Instrument instrument, Artist artist){
        this.documentNo = documentNo;
        this.name = name;
        this.lastName = lastName;
        this.instrument = instrument;
        this.artist = artist;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(int documentNo) {
        this.documentNo = documentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "BandMember{" +
                "id=" + id +
                ", documentNo=" + documentNo +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", instrument=" + instrument +
                ", artist=" + artist +
                '}';
    }
}
