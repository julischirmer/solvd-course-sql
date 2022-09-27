package models;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class Concert {
    private int id;
    private Date dateConcert;
    private LocalTime startTime;
    private Hall hall;
    private List<Artist> artists;
    private List<Staff> staffs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateConcert() {
        return dateConcert;
    }

    public void setDateConcert(Date dateConcert) {
        this.dateConcert = dateConcert;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }
}
