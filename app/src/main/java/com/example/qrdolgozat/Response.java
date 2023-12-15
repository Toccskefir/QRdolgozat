package com.example.qrdolgozat;

public class Response {
    private String responseCode;
    private String responseMessage;

    public Response(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public String getResponseCode() { return responseCode; }

    public void setResponseCode(String responseCode) { this.responseCode = responseCode; }

    public String getResponseMessage() { return responseMessage; }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
