package com.example.craxinno1.model;

import android.provider.CalendarContract;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FinalAgendaModel {

    private String name;

    @SerializedName("start_date")
    private String StartDate;

    @SerializedName("end_date")
    private String EndDate;
    @SerializedName("description")
    private String description;

    @SerializedName("sponsor_name")
    private String SponserName;
    @SerializedName("sponsor_img")
    private String sponserImage;
    @SerializedName("header_img")
    private String headerImage;

    @SerializedName("location_name")
    private String locationName;
    private List<Attendee> attendees;
    private List<Register_link> register_links;
    @SerializedName("agenda_documents")
    private List<Agenda_doc> agenda_docs;

    @SerializedName("agenda_speakers")
    private List<Agenda_speak> agenda_speaks;

    public FinalAgendaModel(String name, String startDate, String endDate, String description,
                            String sponserName, String sponserImage, String headerImage, String locationName,
                            List<Attendee> attendees, List<Register_link> register_links,
                            List<Agenda_doc> agenda_docs, List<Agenda_speak> agenda_speaks) {
        this.name = name;
        StartDate = startDate;
        EndDate = endDate;
        this.description = description;
        SponserName = sponserName;
        this.sponserImage = sponserImage;
        this.headerImage = headerImage;
        this.locationName = locationName;
        this.attendees = attendees;
        this.register_links = register_links;
        this.agenda_docs = agenda_docs;
        this.agenda_speaks = agenda_speaks;
    }

    public FinalAgendaModel(String name, String startDate, String locationName) {
        this.name = name;
        StartDate = startDate;
        this.locationName = locationName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSponserName() {
        return SponserName;
    }

    public void setSponserName(String sponserName) {
        SponserName = sponserName;
    }

    public String getSponserImage() {
        return sponserImage;
    }

    public void setSponserImage(String sponserImage) {
        this.sponserImage = sponserImage;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }

    public List<Register_link> getRegister_links() {
        return register_links;
    }

    public void setRegister_links(List<Register_link> register_links) {
        this.register_links = register_links;
    }

    public List<Agenda_doc> getAgenda_docs() {
        return agenda_docs;
    }

    public void setAgenda_docs(List<Agenda_doc> agenda_docs) {
        this.agenda_docs = agenda_docs;
    }

    public List<Agenda_speak> getAgenda_speaks() {
        return agenda_speaks;
    }

    public void setAgenda_speaks(List<Agenda_speak> agenda_speaks) {
        this.agenda_speaks = agenda_speaks;
    }

    @Override
    public String toString() {
        return "FinalAgendaModel{" +
                "name='" + name + '\'' +
                ", StartDate='" + StartDate + '\'' +
                ", EndDate='" + EndDate + '\'' +
                ", description='" + description + '\'' +
                ", SponserName='" + SponserName + '\'' +
                ", sponserImage='" + sponserImage + '\'' +
                ", headerImage='" + headerImage + '\'' +
                ", locationName='" + locationName + '\'' +
                ", attendees=" + attendees +
                ", register_links=" + register_links +
                ", agenda_docs=" + agenda_docs +
                ", agenda_speaks=" + agenda_speaks +
                '}';
    }
}
