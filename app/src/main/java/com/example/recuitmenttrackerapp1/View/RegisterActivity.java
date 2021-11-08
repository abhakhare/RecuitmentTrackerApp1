package com.example.recuitmenttrackerapp1.View;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.recuitmenttrackerapp1.Model.RegisterUser;
import com.example.recuitmenttrackerapp1.Model.SharedPreference;
import com.example.recuitmenttrackerapp1.R;
import com.example.recuitmenttrackerapp1.ViewModel.RegisterViewModel;
import com.example.recuitmenttrackerapp1.databinding.ActivityRegisterBinding;


import java.util.ArrayList;
import java.util.Objects;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
private ActivityRegisterBinding binding;
private RegisterViewModel registerViewModel;
    EditText name, email, phone, password;
    Button register;
    TextView login;
    boolean isNameValid, isEmailValid, isPhoneValid, isPasswordValid;
    private SharedPreference sharedPreference;
    RegisterActivity context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreference = new SharedPreference();
        registerViewModel= ViewModelProviders.of(this).get(RegisterViewModel.class);

        binding = DataBindingUtil.setContentView(RegisterActivity.this, R.layout.activity_register);

        binding.setLifecycleOwner(this);

        binding.setRegisterViewModel(registerViewModel);

        registerViewModel.getUser().observe(this, new Observer<RegisterUser>() {
            @Override
            public void onChanged(@Nullable RegisterUser registerUser) {

                if (TextUtils.isEmpty(Objects.requireNonNull(registerUser).getName())) {
                    Toast.makeText(RegisterActivity.this,"Please enter your Name",Toast.LENGTH_SHORT).show();

                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(registerUser).getEmail())) {

                    Toast.makeText(RegisterActivity.this,"Please enter your Email",Toast.LENGTH_SHORT).show();
                }
                else if (!registerUser.isEmailValid()) {

                    Toast.makeText(RegisterActivity.this,"This email address is invalid",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(registerUser).getNumber())) {
                    Toast.makeText(RegisterActivity.this,"Please enter your Number",Toast.LENGTH_SHORT).show();
                }
               else if (registerUser.getNumber().length()<10) {
                    // This is a FULL MATCH
                    Toast.makeText(RegisterActivity.this,"Please enter a right mobile number",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(registerUser).getPassword())) {

                    Toast.makeText(RegisterActivity.this,"Please enter your Password",Toast.LENGTH_SHORT).show();
                }
                else if (!registerUser.isPasswordLengthGreaterThan5()) {
                    Toast.makeText(RegisterActivity.this,"Enter at least 6 Digit password",Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(Objects.requireNonNull(registerUser).getConfirmpassword())) {

                    Toast.makeText(RegisterActivity.this, "Please enter your ConfirmPassword", Toast.LENGTH_SHORT).show();
                }else if (!registerUser.getPassword().equals(registerUser.getConfirmpassword())) {

                    Toast.makeText(RegisterActivity.this, "Password Not matching", Toast.LENGTH_SHORT).show();
                } else {

                    SaveUsersDetails(registerUser);
                    Toast.makeText(RegisterActivity.this,"Register User Successful",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private void SaveUsersDetails(RegisterUser registerUser) {
        ArrayList<RegisterUser> userslist=new ArrayList<>();
        userslist.add(registerUser);
        sharedPreference.addUsers(context,registerUser);

    }

    @Override
    public void onClick(View v) {
        int ID=v.getId();
        if(ID== R.id.btnRegister){
            // finish();

        }else if(ID==R.id.loginback){
            Intent intent=new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}