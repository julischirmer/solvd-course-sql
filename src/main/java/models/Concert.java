package models;

import com.fasterxml.jackson.annotation.JsonRootName;
import jdk.jshell.execution.LocalExecutionControl;

import javax.xml.bind.annotation.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@XmlRootElement(name = "Concert")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("Concert")
public class Concert {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "dateConcert")
    private String dateConcert;
    @XmlElement(name = "startTime")
    private String startTime;
    @XmlElement(name = "hall")
    private Hall hall;
    @XmlElementWrapper(name = "artists")
    @XmlElement(name = "artist")
    private List<Artist> artists;
    @XmlElementWrapper(name = "staffs")
    @XmlElement(name = "staff")
    private List<Staff> staffs;
    public Concert(){

    }

    public Concert(int id, String dateConcert, String startTime, Hall hall, ArrayList<Artist> artists, ArrayList<Staff> staffs){
        this.id = id;
        this.dateConcert = dateConcert;
        this.startTime = startTime;
        this.hall = hall;
        this.artists = artists;
        this.staffs = staffs;
    }

    public Concert(String dateConcert, String startTime, Hall hall, ArrayList<Artist> artists, ArrayList<Staff> staffs){
        this.dateConcert = dateConcert;
        this.startTime = startTime;
        this.hall = hall;
        this.artists = artists;
        this.staffs = staffs;
    }

    public Concert(int id, String dateConcert, String startTime, Hall hall){
        this.id = id;
        this.dateConcert = dateConcert;
        this.startTime = startTime;
        this.hall = hall;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateConcert() {
        return dateConcert;
    }

    public void setDateConcert(String dateConcert) {
        this.dateConcert = dateConcert;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
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

    @Override
    public String toString() {
        return "Concert{" +
                "id=" + id +
                ", dateConcert=" + dateConcert +
                ", startTime=" + startTime +
                ", hall=" + hall +
                ", artists=" + artists +
                ", staffs=" + staffs +
                '}';
    }
}
