package com.csi370.mobileprojectcsi370;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {



    EditText edtEmail, edtPassword;

    Button btnLogin, btnReset, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = (EditText) findViewById(R.id.edtEmailLogin);
        edtPassword = (EditText) findViewById(R.id.edtPasswordLogin);

        btnLogin = (Button) findViewById(R.id.btnLoginLogin);
        btnReset = (Button) findViewById(R.id.btnResetLogin);
        btnBack = (Button) findViewById(R.id.btnBackLogin);

        // For sharedPreference - DO NOT REMOVE YET
        //Keep sharePreference updated with AppUserDb

            AppUserDb.UsersArrayList = PrefConfig.readListFromSharedPreference(this);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!TextUtils.isEmpty(edtEmail.getText().toString()) && !TextUtils.isEmpty(edtPassword.getText().toString())){

                    if(true){

                        if(authenticateUser()){
                            Toast.makeText(getApplicationContext(), "Happy shopping!", Toast.LENGTH_SHORT).show();

                            // User is redirected to CategoriesActivity
                            Intent categoriesActivity = new Intent(getApplicationContext(), CategoriesActivity.class);
                            startActivity(categoriesActivity);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Incorrect password!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "User doesn't exist! Go back to register", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                    Intent resetPassActivity = new Intent(getApplicationContext(), ResetPassActivity.class);
                    startActivity(resetPassActivity);
                    finish();

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);
                finish();

            }
        });

    }

    private boolean authenticateUser()
    {

        if(!AppUserDb.UsersArrayList.isEmpty()) {
            for (AppUser user : AppUserDb.UsersArrayList) {
                if (user.getEmail().equals(edtEmail.getText().toString()) && user.getPassword().equals(edtPassword.getText().toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkIfEmailExists() {

        if (!AppUserDb.UsersArrayList.isEmpty()) {
            for (AppUser user : AppUserDb.UsersArrayList) {
                if (user.getEmail().equals(edtEmail.getText().toString())) {
                    return true;
                }
            }
        }
        return false;
    }




}