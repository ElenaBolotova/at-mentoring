package com.epam.elena_bolotova.mentoring.task9.tests.gmail.bo;

public class Email {
    private String subject;
    private String addressee;
    private String body;

    public String getSubject() {
        return subject;
    }

    public String getAddressee() {
        return addressee;
    }

    public String getBody() {
        return body;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
