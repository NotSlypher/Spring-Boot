package com.ayush.rest.rest;

public class StudentErrorResponse {
    public int StatusCode;
    public String message;
    public long timeStamp;

    public StudentErrorResponse(int statusCode, String message, long timeStamp) {
        StatusCode = statusCode;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public StudentErrorResponse() {
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
