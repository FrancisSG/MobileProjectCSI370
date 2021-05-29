package com.csi370.mobileprojectcsi370;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPassActivity extends AppCompatActivity {

    Button btnReset, btnBack;
    EditText edtEmail, edtNewPassword, edtRepeatedPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);

        btnReset = (Button) findViewById(R.id.btnResetPasswordReset);
        btnBack = (Button) findViewById(R.id.btnBackReset);
        edtEmail = (EditText) findViewById(R.id.edtEmailReset);
        edtNewPassword = (EditText) findViewById(R.id.edtPasswordReset);
        edtRepeatedPassword = (EditText) findViewById(R.id.edtReenterPasswordReset);

        btnReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(
                        !TextUtils.isEmpty(edtEmail.getText().toString())
                                && !TextUtils.isEmpty(edtNewPassword.getText().toString())
                                && !TextUtils.isEmpty(edtRepeatedPassword.getText().toString())
                ) {

                    if(edtNewPassword.getText().toString().equals(edtRepeatedPassword.getText().toString())){

                        if(checkIfEmailExists()){

                            changePassword(edtEmail.getText().toString(),edtNewPassword.getText().toString());
                            Toast.makeText(getApplicationContext(), "Password successfully changed!", Toast.LENGTH_SHORT).show();

                            Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(mainActivity);
                            finish();

                        } else {
                            Toast.makeText(getApplicationContext(), "Email doesn't exist!", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Passwords do not match!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Fill in the empty field(s)!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent loginActivity = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginActivity);
                finish();
            }
        });

}

    private boolean checkIfEmailExists()
    {

        for (AppUser user: AppUserDb.UsersArrayList)
        {
            if (user.getEmail().equals(edtEmail.getText().toString()))
            {
                return true;
            }
            else
                return false;
        }
        return false;
    }

    private void changePassword(String email, String newPassword)
    {

        for (AppUser user: AppUserDb.UsersArrayList)
        {
            if (user.getEmail().equals(edtEmail.getText().toString()))
            {
                user.setPassword(newPassword);
            }
        }
    }

}