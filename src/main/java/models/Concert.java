package models;

import java.time.LocalTime;
import java.util.Date;

public class Concert {
    private int id;
    private Date dateConcert;
    private LocalTime startTime;
    private Hall hall;

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
}
