package com.luv2code.springrestdemo.rest;

public class StudentErrorMessage {
    private int status;
    private String message;
    private long timeLine;

    public StudentErrorMessage() {

    }

    public StudentErrorMessage(int status, String message, long timeLine) {
        this.status = status;
        this.message = message;
        this.timeLine = timeLine;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeLine() {
        return timeLine;
    }

    public void setTimeLine(long timeLine) {
        this.timeLine = timeLine;
    }
}
