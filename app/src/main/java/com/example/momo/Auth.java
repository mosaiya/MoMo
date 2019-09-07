package com.example.momo;

public class Auth {
    private static final String EMAIL="momosung@hotmail.com"; //**
    private static final String PASSWORD="0968350536"; //**

    private String mEmail;
    private  String mPassword;

    public Auth(String email,String password){
        this.mEmail=email;
        this.mPassword=password;
    }
    public boolean check() {
        if (mEmail.equals(EMAIL) && mPassword.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}
