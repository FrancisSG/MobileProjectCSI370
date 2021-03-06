package com.csi370.mobileprojectcsi370;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CategoriesActivity extends AppCompatActivity {

    ImageButton imgBtnBusinessPCs, imgBtnCasualPCs, imgBtnEnthusiastPCs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        imgBtnBusinessPCs = (ImageButton) findViewById(R.id.imgBtnBusinessPCs);
        imgBtnCasualPCs = (ImageButton) findViewById(R.id.imgBtnCasualPCs);
        imgBtnEnthusiastPCs = (ImageButton) findViewById(R.id.imgBtnEnthusiastPCs);

        imgBtnBusinessPCs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent officePCActivity = new Intent(getApplicationContext(), OfficePCActivity.class);
                startActivity(officePCActivity);
                finish();

            }
        });

        imgBtnCasualPCs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent casualPCActivity = new Intent(getApplicationContext(), CasualPCActivity.class);
                startActivity(casualPCActivity);
                finish();

            }
        });

        imgBtnEnthusiastPCs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent enthusiastPCActivity = new Intent(getApplicationContext(), EnthusiastPCActivity.class);
                startActivity(enthusiastPCActivity);
                finish();

            }
        });


    }
}