package com.csi370.mobileprojectcsi370;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String BOOLEAN_PREF = "booleanPref";

    Button btnLogin, btnRegister, btnGuest;

    boolean toggleButton = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnGuest = (Button) findViewById(R.id.btnGuest);


        loadData();

        try {
            if(PrefConfig.readListFromSharedPreference(this).isEmpty()){
                btnLogin.setEnabled(false);
            } else {
                btnLogin.setEnabled(true);
            }
        }
            catch(Exception e) {
                btnLogin.setEnabled(false);
            }



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent loginActivity = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginActivity);
                finish();

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent registerActivity = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(registerActivity);
                finish();

            }
        });

        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "Happy shopping!", Toast.LENGTH_SHORT).show();

                Intent categoriesActivity = new Intent(getApplicationContext(), CategoriesActivity.class);
                startActivity(categoriesActivity);
                finish();
            }
        });

    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        RegisterActivity.hasBeenUsed = sharedPreferences.getBoolean(BOOLEAN_PREF, true);
        if(RegisterActivity.hasBeenUsed) {
            toggleButton = true;
        }
    }

}