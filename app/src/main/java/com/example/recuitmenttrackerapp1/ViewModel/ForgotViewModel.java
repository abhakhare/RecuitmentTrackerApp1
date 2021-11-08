package com.example.recuitmenttrackerapp1.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import com.example.recuitmenttrackerapp1.Model.ForgotUser;


public class ForgotViewModel extends ViewModel {
    public MutableLiveData<String> Email = new MutableLiveData<>();
    private MutableLiveData<ForgotUser> userMutableLiveData;

    public MutableLiveData<ForgotUser> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }
    public void onClick(View view) {
        ForgotUser forgotUser=new ForgotUser(Email.getValue());

        userMutableLiveData.setValue(forgotUser);
    }

}
