package com.example.recuitmenttrackerapp1.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import com.example.recuitmenttrackerapp1.Model.RegisterUser;


public class RegisterViewModel extends ViewModel {
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> number = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> confirmpassword = new MutableLiveData<>();
    private MutableLiveData<RegisterUser> userMutableLiveData;

    public MutableLiveData<RegisterUser> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }
    public void onClick(View view) {

        RegisterUser RegisterUser = new RegisterUser(name.getValue(), email.getValue(),number.getValue(),password.getValue(),confirmpassword.getValue());

        userMutableLiveData.setValue(RegisterUser);

    }

}
