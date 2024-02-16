package dev.meininger.RevShopApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BuyerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    private String userEmail;

    private String userPassword;

    private String securityQuestion;

    private String securityAnswer;

    public BuyerAccount(){

    }

    public BuyerAccount(String UserEmail, String UserPassword, String SecurityQuestion, String SecurityAnswer){
        this.userEmail = UserEmail;
        this.userPassword = UserPassword;
        this.securityQuestion = SecurityQuestion;
        this.securityAnswer = SecurityAnswer;
    }

    public BuyerAccount(Integer UserId, String UserEmail, String UserPassword, String SecurityQuestion, String SecurityAnswer){
        this.userId = UserId;
        this.userEmail = UserEmail;
        this.userPassword = UserPassword;
        this.securityQuestion = SecurityQuestion;
        this.securityAnswer = SecurityAnswer;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer UserId) {
        this.userId = UserId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String UserEmail) {
        this.userEmail = UserEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String UserPassword) {
        this.userPassword = UserPassword;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String SecurityQuestion) {
        this.securityQuestion = SecurityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String SecurityAnswer) {
        this.securityAnswer = getSecurityAnswer();
    }
}
