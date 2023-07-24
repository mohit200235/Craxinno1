package com.example.craxinno1.model;

import com.google.gson.annotations.SerializedName;

public class Agenda_doc {


    private String doc_name;
    @SerializedName("document_file")
    private String doc_file;

    public Agenda_doc(String doc_name, String doc_file) {
        this.doc_name = doc_name;
        this.doc_file = doc_file;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getDoc_file() {
        return doc_file;
    }

    public void setDoc_file(String doc_file) {
        this.doc_file = doc_file;
    }

    @Override
    public String toString() {
        return "Agenda_doc{" +
                "doc_name='" + doc_name + '\'' +
                ", doc_file='" + doc_file + '\'' +
                '}';
    }
}
