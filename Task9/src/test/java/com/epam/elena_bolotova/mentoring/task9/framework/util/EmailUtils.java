package com.epam.elena_bolotova.mentoring.task9.framework.util;

import com.epam.elena_bolotova.mentoring.task9.tests.gmail.bo.Email;

public class EmailUtils {

    public static final Email createEmail(String addressee, String subject, String body){
        Email email = new Email();
        email.setSubject(subject);
        email.setAddressee(addressee);
        email.setBody(body);
        return email;
    }
}
