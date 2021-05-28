package com.csi370.mobileprojectcsi370;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CategoriesActivity extends AppCompatActivity {

    ImageButton imgBtnBusinessPCs, imgBtnCasualPCs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        imgBtnBusinessPCs = (ImageButton) findViewById(R.id.imgBtnBusinessPCs);
        imgBtnCasualPCs = (ImageButton) findViewById(R.id.imgBtnCasualPCs);

        imgBtnBusinessPCs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent officePCActivity = new Intent(getApplicationContext(), OfficePCActivity.class);
                startActivity(officePCActivity);
                finish();

            }
        });

        imgBtnCasualPCs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent officePCActivity = new Intent(getApplicationContext(), OfficePCActivity.class);
                startActivity(officePCActivity);
                finish();

            }
        });


    }
}