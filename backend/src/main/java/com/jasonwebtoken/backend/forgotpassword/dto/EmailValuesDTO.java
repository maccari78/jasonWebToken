package com.jasonwebtoken.backend.forgotpassword.dto;

public class EmailValuesDTO {
    
    private String mailFrom;
    private String mailTo;
    private String subject;
    private String userName;
    private String forgotPassword;

    public EmailValuesDTO() {
    }

    public EmailValuesDTO(String mailFrom, String mailTo, String subject, String userName, String forgotPassword) {
        this.mailFrom = mailFrom;
        this.mailTo = mailTo;
        this.subject = subject;
        this.userName = userName;
        this.forgotPassword = forgotPassword;
    }    

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getForgotPassword() {
        return forgotPassword;
    }

    public void setForgotPassword(String forgotPassword) {
        this.forgotPassword = forgotPassword;
    }

        
}