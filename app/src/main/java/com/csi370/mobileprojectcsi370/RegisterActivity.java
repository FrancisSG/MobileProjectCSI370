package com.csi370.mobileprojectcsi370;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

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

        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(
                        !TextUtils.isEmpty(edtEmail.getText().toString())
                        && !TextUtils.isEmpty(edtPassword.getText().toString())
                        && !TextUtils.isEmpty(edtAddress.getText().toString())
                        && !TextUtils.isEmpty(edtPhoneNumber.getText().toString())
                ) {

                    AppUserDb.userId++;

                    AppUserDb.UsersArrayList.add(
                            new AppUser(
                                    AppUserDb.userId,
                                    edtEmail.getText().toString(),
                                    edtPassword.getText().toString(),
                                    edtAddress.getText().toString(),
                            Integer.parseInt(edtPhoneNumber.getText().toString())));

                    Toast.makeText(getApplicationContext(), "Registered Successfully!", Toast.LENGTH_SHORT).show();

                    AppUserDb.UsersArrayList.size();

                    Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(mainActivity);
                    finish();

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
}