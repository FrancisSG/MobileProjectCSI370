package com.csi370.mobileprojectcsi370;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(checkIfEmailExists()){

                   if(authenticateUser()){
                       Toast.makeText(getApplicationContext(), "Happy shopping!", Toast.LENGTH_SHORT).show();

                       Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                       startActivity(mainActivity);
                       finish();
                   } else {
                       Toast.makeText(getApplicationContext(), "Incorrect password!", Toast.LENGTH_SHORT).show();
                   }
                } else {
                    Toast.makeText(getApplicationContext(), "User doesn't exist! Go back to register", Toast.LENGTH_SHORT).show();

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

        for (AppUser user: AppUserDb.UsersArrayList)
        {
            if (user.getPassword().equals(edtPassword.getText().toString()))
            {
                return true;
            }
            else
                return false;
        }
        return false;
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

}