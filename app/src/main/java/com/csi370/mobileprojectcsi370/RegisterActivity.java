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

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {



    public static boolean hasBeenUsed = false;

    Button btnRegister, btnBack;
    EditText edtEmail, edtPassword, edtAddress, edtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnBack = (Button) findViewById(R.id.btnBackRegister);

        edtEmail = (EditText) findViewById(R.id.edtEmailRegister);
        edtPassword = (EditText) findViewById(R.id.edtPasswordRegister);
        edtAddress = (EditText) findViewById(R.id.edtAddressRegister);
        edtPhoneNumber = (EditText) findViewById(R.id.edtPhoneNumberRegister);

        // For sharedPreference - DO NOT REMOVE YET
        if(!AppUserDb.UsersArrayList.isEmpty()){
            AppUserDb.UsersArrayList = PrefConfig.readListFromSharedPreference(this);
        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(
                        !TextUtils.isEmpty(edtEmail.getText().toString())
                        && !TextUtils.isEmpty(edtPassword.getText().toString())
                        && !TextUtils.isEmpty(edtAddress.getText().toString())
                        && !TextUtils.isEmpty(edtPhoneNumber.getText().toString())
                ) {
                if(!checkIfEmailExists()){
                    AppUserDb.loggedInUserId = PrefConfig.arraySize + 1;

                    AppUserDb.UsersArrayList.add(
                            new AppUser(
                                    AppUserDb.loggedInUserId,
                                    edtEmail.getText().toString(),
                                    edtPassword.getText().toString(),
                                    edtAddress.getText().toString(),
                                    Integer.parseInt(edtPhoneNumber.getText().toString())));

                    // For sharedPreference - DO NOT REMOVE YET
                    //Add AppUser ArrayList into sharedPreference
                    PrefConfig.writeArrayListInPref(getApplicationContext(), AppUserDb.UsersArrayList);

                    Toast.makeText(getApplicationContext(), "Registered Successfully!", Toast.LENGTH_SHORT).show();

                    hasBeenUsed = true;
                    saveData();

                    Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(mainActivity);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Email already in use!", Toast.LENGTH_SHORT).show();

                }
                } else {
                    Toast.makeText(getApplicationContext(), "Fill in the empty field(s)!", Toast.LENGTH_SHORT).show();
                }

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

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(MainActivity.BOOLEAN_PREF, hasBeenUsed);

    }

}