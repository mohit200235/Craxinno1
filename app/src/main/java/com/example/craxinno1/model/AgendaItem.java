package com.example.craxinno1.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class AgendaItem {

    @SerializedName("id")
    private int id;
    private String name;
    @SerializedName("start_date")
    private Date startDate;
    @SerializedName("end_date")
    private Date endDate;
    private int myAgenda;
    private List<Attendee> attendees;

    public AgendaItem(int id, String name, Date startDate, Date endDate, int myAgenda, List<Attendee> attendees) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.myAgenda = myAgenda;
        this.attendees = attendees;
    }

    public AgendaItem(String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMyAgenda() {
        return myAgenda;
    }

    public void setMyAgenda(int myAgenda) {
        this.myAgenda = myAgenda;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }

    @NonNull
    @Override
    public String toString() {
        return "AgendaItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", myAgenda=" + myAgenda +
                ", attendees=" + attendees +
                '}';
    }
}
