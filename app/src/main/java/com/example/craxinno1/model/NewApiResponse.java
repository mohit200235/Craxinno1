package com.example.craxinno1.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewApiResponse {
    private String replyCode;
    private String replyMsg;
    private FinalAgendaModel data;

    @SerializedName("imgPath")
    private String imagePath;

    public NewApiResponse(String replyCode, String replyMsg, FinalAgendaModel data, String imagePath) {
        this.replyCode = replyCode;
        this.replyMsg = replyMsg;
        this.data = data;
        this.imagePath=imagePath;
    }

    public NewApiResponse() {
    }
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getReplyCode() {
        return replyCode;
    }

    public void setReplyCode(String replyCode) {
        this.replyCode = replyCode;
    }

    public String getReplyMsg() {
        return replyMsg;
    }

    public void setReplyMsg(String replyMsg) {
        this.replyMsg = replyMsg;
    }

    public FinalAgendaModel getData() {
        return data;
    }

    public void setData(FinalAgendaModel data) {
        this.data = data;
    }
// Getters and setters for the fields
}

