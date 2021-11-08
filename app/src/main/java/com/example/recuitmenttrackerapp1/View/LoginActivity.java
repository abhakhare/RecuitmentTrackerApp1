package com.example.recuitmenttrackerapp1.View;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.recuitmenttrackerapp1.Model.LoginUser;
import com.example.recuitmenttrackerapp1.Model.RegisterUser;
import com.example.recuitmenttrackerapp1.Model.SharedPreference;
import com.example.recuitmenttrackerapp1.R;
import com.example.recuitmenttrackerapp1.View.navigationdrawer.MainActivity;
import com.example.recuitmenttrackerapp1.ViewModel.LoginViewModel;
import com.example.recuitmenttrackerapp1.ViewModel.RegisterViewModel;
import com.example.recuitmenttrackerapp1.databinding.ActivityLoginBinding;


import java.util.ArrayList;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private LoginViewModel loginViewModel;
    RegisterViewModel registerViewModel;
    private ActivityLoginBinding binding;

     ArrayList<RegisterUser> userlist;
    private SharedPreference sharedPreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
       // registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
        binding = DataBindingUtil.setContentView(LoginActivity.this, R.layout.activity_login);
        sharedPreference = new SharedPreference();
        binding.setLifecycleOwner(this);

        binding.setLoginViewModel(loginViewModel);
        loginViewModel.getUser().observe(this, new Observer<LoginUser>() {
            @Override
            public void onChanged(@Nullable final LoginUser loginUser) {

               if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrEmailAddress())) {
                    Toast.makeText(LoginActivity.this,"Please enter your email address",Toast.LENGTH_SHORT).show();

                }
                else if (!loginUser.isEmailValid()) {

                    Toast.makeText(LoginActivity.this,"This email address is invalid",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrPassword())) {
                    Toast.makeText(LoginActivity.this,"Please enter Password",Toast.LENGTH_SHORT).show();
                }
                else if (!loginUser.isPasswordLengthGreaterThan5()) {

                    Toast.makeText(LoginActivity.this,"Enter at least 6 Digit password",Toast.LENGTH_SHORT).show();
                }
                else {


              //Step 4: Iterate Using while loop
                   userlist=sharedPreference.getUsers(LoginActivity.this);
                   if(userlist!=null && userlist.size()>0) {

                       Log.e("listuser", userlist.toString());
           //
                       for(int i=0;userlist.size()>i;i++){
                           String email =userlist.get(i).getEmail().toString();
                           String pass =userlist.get(i).getPassword().toString();

                           if(loginUser.getStrEmailAddress().equals(email) && loginUser.getStrPassword().equalsIgnoreCase(pass) ){
                               Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                               startActivity(intent);
                           }else{
                               Toast.makeText(LoginActivity.this,"Please enter register email and password ",Toast.LENGTH_SHORT).show();
                           }



                       }


                   }else {

                       Toast.makeText(LoginActivity.this,"No Data Found, Please Register This Email ",Toast.LENGTH_SHORT).show();
                   }

                }

            }
        });

    }



    @Override
    public void onClick(View v) {

            int ID=v.getId();
           if(ID==R.id.btnLogin){

           }else if(ID==R.id.forgot){
                Intent intent=new Intent(this, ForgotActivity.class);
                startActivity(intent);
            }else if(ID==R.id.register){
                Intent intent=new Intent(this, RegisterActivity.class);
                startActivity(intent);
            }
        }

}
