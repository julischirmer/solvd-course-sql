package models;

public class BandMember {
    private int id;
    private int documentNo;
    private String name;
    private String lastName;
    private Instrument instrument;
    private Artist artist;

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
