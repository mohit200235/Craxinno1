package com.example.craxinno1.model;

public class Attendee {
    private String image;
    private String companyName;
    private String name;

    public Attendee(String image, String companyName, String name) {
        this.image = image;
        this.companyName = companyName;
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Attendee{" +
                "image='" + image + '\'' +
                ", companyName='" + companyName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
