package com.example.craxinno1.model;

import com.google.gson.annotations.SerializedName;

public class Agenda_speak {

    @SerializedName("name")
    private String name;
    @SerializedName("title")
    private String title;
    private String companyName;
    @SerializedName("image")
    private String image;

    public Agenda_speak(String name, String title, String companyName, String image) {
        this.name = name;
        this.title = title;
        this.companyName = companyName;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
