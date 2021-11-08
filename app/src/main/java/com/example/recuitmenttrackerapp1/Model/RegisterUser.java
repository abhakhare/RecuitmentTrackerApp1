package com.example.recuitmenttrackerapp1.Model;

import android.util.Patterns;

public class RegisterUser {
    //private int id;
    private String name;
    private String email;
    private String number;
    private String password;
    private String confirmpassword;


    public RegisterUser( String name, String email, String number, String password, String confirmpassword) {
       // this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
        this.password = password;
        this.confirmpassword = confirmpassword;

    }



  /*  public int getId() {
      return id;
    }

    public void setId(int id) {
        this.id = id;}*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
    }


    public boolean isPasswordLengthGreaterThan5() {
        return getPassword().length() > 5;
    }

    @Override
    public String toString() {
        return "RegisterUser[ name=" + name + ", email="
                + email + ", number=" + number + ", password=" + password + ", confirmpassword=" + confirmpassword + "]";
    }
}
