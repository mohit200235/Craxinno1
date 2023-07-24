package com.example.craxinno1.model;

import java.util.List;

public class ApiResponse {
    private String replyCode;
    private String replyMsg;
    private List<AgendaItem> data;

    public ApiResponse(String replyCode, String replyMsg, List<AgendaItem> data) {
        this.replyCode = replyCode;
        this.replyMsg = replyMsg;
        this.data = data;
    }

    public ApiResponse() {
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

    public List<AgendaItem> getData() {
        return data;
    }

    public void setData(List<AgendaItem> data) {
        this.data = data;
    }
    // Getters and setters for the fields
}
