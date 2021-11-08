package com.example.recuitmenttrackerapp1.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;


import com.example.recuitmenttrackerapp1.Model.ForgotUser;
import com.example.recuitmenttrackerapp1.R;
import com.example.recuitmenttrackerapp1.ViewModel.ForgotViewModel;
import com.example.recuitmenttrackerapp1.databinding.ActivityForgotBinding;


import java.util.Objects;


public class ForgotActivity extends AppCompatActivity implements View.OnClickListener {
    private ForgotViewModel forgotViewModel;
    private ActivityForgotBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        forgotViewModel = ViewModelProviders.of(this).get(ForgotViewModel.class);

        binding = DataBindingUtil.setContentView(ForgotActivity.this, R.layout.activity_forgot);

        binding.setLifecycleOwner(this);

        binding.setForgotViewModel(forgotViewModel);

        forgotViewModel.getUser().observe(this, new Observer<ForgotUser>() {
            @Override
            public void onChanged(ForgotUser forgotUser) {

                if (TextUtils.isEmpty(Objects.requireNonNull(forgotUser).getEmail())) {
                    Toast.makeText(ForgotActivity.this,"Please enter your email address",Toast.LENGTH_SHORT).show();

                }else if (!forgotUser.isEmailValid()) {

                    Toast.makeText(ForgotActivity.this,"This email address is invalid",Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(ForgotActivity.this,"Forgot Password send your mail",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public void onClick(View v) {
        int ID=v.getId();
        if(ID==R.id.btnSubmit){


        }else if(ID==R.id.back){
            Intent intent=new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
