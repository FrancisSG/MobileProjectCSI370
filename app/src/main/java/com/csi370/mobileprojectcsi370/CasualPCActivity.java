package com.csi370.mobileprojectcsi370;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class CasualPCActivity extends AppCompatActivity {

    Button btnInspectPC4, btnAddToCartPC4, btnMyCart, btnBack;
    Button btnInspectPC5, btnAddToCartPC5;
    Button btnInspectPC6, btnAddToCartPC6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casual_p_c);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Inquiries unavailable at this time", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnInspectPC4 = (Button) findViewById(R.id.btnInspectPC4);
        btnAddToCartPC4 = (Button) findViewById(R.id.btnAddtoCartPC4);
        btnInspectPC5 = (Button) findViewById(R.id.btnInspectPC5);
        btnAddToCartPC5 = (Button) findViewById(R.id.btnAddtoCartPC5);
        btnInspectPC6 = (Button) findViewById(R.id.btnInspectPC6);
        btnAddToCartPC6 = (Button) findViewById(R.id.btnAddtoCartPC6);

        btnMyCart = (Button) findViewById(R.id.btnMyCartScrollingCasual);
        btnBack = (Button) findViewById(R.id.btnBackScrollingCasual);

        btnInspectPC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //populate ArrayList with Office PC 1's information
                ProductsInfoArrayList.productsInfoArrayList.add(new ProductDescription(

                        3,
                        "CyberPowerPC - Gamer Xtreme Gaming Desktop",
                        "CyberPower",
                        "Intel Core i5-10600KF",
                        "8 GB RAM DDR4 SDRAM",
                        "1 TB HDD",
                        "240 GB SSD",
                        "NVIDIA GeForce GTX 1660 SUPER",
                        "Windows 10",
                        1049.99

                ));

                Bundle bundle = new Bundle();
                bundle.putInt("productId", 3);
                bundle.putInt("whichActivity", 1);
                Intent inspectScrollActivity = new Intent(getApplicationContext(), InspectScrollPopUpActivity.class);

                inspectScrollActivity.putExtras(bundle);

                startActivity(inspectScrollActivity);
                finish();
            }
        });

        btnAddToCartPC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle cartBundle = new Bundle();
                cartBundle.putInt("productId", 3);
                cartBundle.putString("productName", "CyberPowerPC - Gamer Xtreme Gaming Desktop");
                cartBundle.putDouble("productPrice", 1049.99);
                cartBundle.putInt("whichActivity", 1);

                Intent addToCartPopUpActivity = new Intent(getApplicationContext(), AddToCartPopUpActivity.class);

                addToCartPopUpActivity.putExtras(cartBundle);

                startActivity(addToCartPopUpActivity);
                finish();
            }
        });

        btnInspectPC5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //populate ArrayList with Office PC 2's information
                ProductsInfoArrayList.productsInfoArrayList.add(new ProductDescription(

                        4,
                        "CyberPowerPC - Gamer Master Gaming Desktop",
                        "CyberPower",
                        "AMD Ryzen 3 3000 Series",
                        "8 GB RAM DDR4 SDRAM",
                        "1 TB HDD",
                        "240 GB SSD",
                        "AMD Radeon RX 570",
                        "Windows 10",
                        649.99

                ));

                Bundle bundle = new Bundle();
                bundle.putInt("productId", 4);
                bundle.putInt("whichActivity", 1);

                Intent inspectScrollActivity = new Intent(getApplicationContext(), InspectScrollPopUpActivity.class);

                ProductsInfoArrayList.productsInfoArrayList.size();

                inspectScrollActivity.putExtras(bundle);

                startActivity(inspectScrollActivity);
                finish();
            }
        });

        btnAddToCartPC5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle cartBundle = new Bundle();
                cartBundle.putInt("productId", 4);
                cartBundle.putString("productName", "CyberPowerPC - Gamer Master Gaming Desktop");
                cartBundle.putDouble("productPrice", 649.99);
                cartBundle.putInt("whichActivity", 1);

                Intent addToCartPopUpActivity = new Intent(getApplicationContext(), AddToCartPopUpActivity.class);

                addToCartPopUpActivity.putExtras(cartBundle);

                startActivity(addToCartPopUpActivity);
                finish();
            }
        });

        btnInspectPC6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //populate ArrayList with Office PC 3's information
                ProductsInfoArrayList.productsInfoArrayList.add(new ProductDescription(

                        5,
                        "Dell - G5 5000 Gaming Desktop",
                        "Dell",
                        "Intel 10th Generation Core i7-10700F",
                        "16 GB RAM DDR4 SDRAM",
                        "512 GB HDD",
                        "512 GB SSD",
                        "NVIDIA GeForce GTX 1660 SUPER",
                        "Windows 10",
                        1199.99

                ));

                Bundle bundle = new Bundle();
                bundle.putInt("productId", 5);
                bundle.putInt("whichActivity", 1);

                Intent inspectScrollActivity = new Intent(getApplicationContext(), InspectScrollPopUpActivity.class);

                ProductsInfoArrayList.productsInfoArrayList.size();

                inspectScrollActivity.putExtras(bundle);

                startActivity(inspectScrollActivity);
                finish();
            }
        });

        btnAddToCartPC6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle cartBundle = new Bundle();
                cartBundle.putInt("productId", 5);
                cartBundle.putString("productName", "Dell - G5 5000 Gaming Desktop");
                cartBundle.putDouble("productPrice", 1199.99);
                cartBundle.putInt("whichActivity", 1);
                Intent addToCartPopUpActivity = new Intent(getApplicationContext(), AddToCartPopUpActivity.class);

                addToCartPopUpActivity.putExtras(cartBundle);

                startActivity(addToCartPopUpActivity);
                finish();
            }
        });

        btnMyCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle activityBundle = new Bundle();
                activityBundle.putInt("whichActivity", 1);
                Intent myCartActivity = new Intent(getApplicationContext(), MyCartActivity.class);
                myCartActivity.putExtras(activityBundle);
                startActivity(myCartActivity);
                finish();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent categoriesActivity = new Intent(getApplicationContext(), CategoriesActivity.class);

                startActivity(categoriesActivity);
                finish();
            }
        });

    }
}