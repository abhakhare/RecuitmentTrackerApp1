package com.example.recuitmenttrackerapp1.Model;

import android.util.Patterns;

public class ForgotUser {
    private String email;

    public ForgotUser(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
    }
}
