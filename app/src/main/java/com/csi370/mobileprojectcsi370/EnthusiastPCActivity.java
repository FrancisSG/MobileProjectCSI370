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

public class EnthusiastPCActivity extends AppCompatActivity {

    Button btnInspectPC7, btnAddToCartPC7, btnMyCart, btnBack;
    Button btnInspectPC8, btnAddToCartPC8;
    Button btnInspectPC9, btnAddToCartPC9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enthusiast_p_c);
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

        btnInspectPC7 = (Button) findViewById(R.id.btnInspectPC7);
        btnAddToCartPC7 = (Button) findViewById(R.id.btnAddtoCartPC7);
        btnInspectPC8 = (Button) findViewById(R.id.btnInspectPC8);
        btnAddToCartPC8 = (Button) findViewById(R.id.btnAddtoCartPC8);
        btnInspectPC9 = (Button) findViewById(R.id.btnInspectPC9);
        btnAddToCartPC9 = (Button) findViewById(R.id.btnAddtoCartPC9);

        btnMyCart = (Button) findViewById(R.id.btnMyCartScrollingEnth);
        btnBack = (Button) findViewById(R.id.btnBackScrollingEnth);

        btnInspectPC7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ProductsInfoArrayList.productsInfoArrayList.add(new ProductDescription(

                        6,
                        "CLX Uprising Gaming Desktop",
                        "CLX",
                        "AMD Ryzen 7 3000 Series",
                        "16 GB RAM DDR4 SDRAM",
                        "960 GB HDD",
                        "960 GB SSD",
                        "NVIDIA GeForce RTX 2070",
                        "Windows 10",
                        1939.99

                ));

                Bundle bundle = new Bundle();
                bundle.putInt("productId", 6);
                bundle.putInt("whichActivity", 2);
                Intent inspectScrollActivity = new Intent(getApplicationContext(), InspectScrollPopUpActivity.class);

                inspectScrollActivity.putExtras(bundle);

                startActivity(inspectScrollActivity);
                finish();
            }
        });

        btnAddToCartPC7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle cartBundle = new Bundle();
                cartBundle.putInt("productId", 6);
                cartBundle.putString("productName", "CLX Uprising Gaming Desktop");
                cartBundle.putDouble("productPrice", 1939.99);
                cartBundle.putInt("whichActivity", 2);

                Intent addToCartPopUpActivity = new Intent(getApplicationContext(), AddToCartPopUpActivity.class);

                addToCartPopUpActivity.putExtras(cartBundle);

                startActivity(addToCartPopUpActivity);
                finish();
            }
        });

        btnInspectPC8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProductsInfoArrayList.productsInfoArrayList.add(new ProductDescription(

                        7,
                        "CyberPowerPC - Gamer Supreme Gaming Desktop",
                        "CyberPower",
                        "Intel 11th Generation Core i9 - i9-11900KF",
                        "16 GB RAM DDR4 SDRAM",
                        "2 TB HDD",
                        "500 GB SSD",
                        "NVIDIA GeForce RTX 3060",
                        "Windows 10",
                        1939.99

                ));

                Bundle bundle = new Bundle();
                bundle.putInt("productId", 7);
                bundle.putInt("whichActivity", 2);

                Intent inspectScrollActivity = new Intent(getApplicationContext(), InspectScrollPopUpActivity.class);

                ProductsInfoArrayList.productsInfoArrayList.size();

                inspectScrollActivity.putExtras(bundle);

                startActivity(inspectScrollActivity);
                finish();
            }
        });

        btnAddToCartPC8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle cartBundle = new Bundle();
                cartBundle.putInt("productId", 7);
                cartBundle.putString("productName", "CyberPowerPC - Gamer Supreme Gaming Desktop");
                cartBundle.putDouble("productPrice", 1939.99);
                cartBundle.putInt("whichActivity", 2);

                Intent addToCartPopUpActivity = new Intent(getApplicationContext(), AddToCartPopUpActivity.class);

                addToCartPopUpActivity.putExtras(cartBundle);

                startActivity(addToCartPopUpActivity);
                finish();
            }
        });

        btnInspectPC9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //populate ArrayList with Office PC 3's information
                ProductsInfoArrayList.productsInfoArrayList.add(new ProductDescription(

                        8,
                        "CLX Revo Gaming Desktop",
                        "CLX ",
                        "Intel Core i9 10850K",
                        "32 GB RAM DDR4 SDRAM",
                        "4 TB HDD",
                        "960 GB SSD",
                        "NVIDIA GeForce RTX 3070",
                        "Windows 10",
                        3149.99

                ));

                Bundle bundle = new Bundle();
                bundle.putInt("productId", 8);
                bundle.putInt("whichActivity", 2);

                Intent inspectScrollActivity = new Intent(getApplicationContext(), InspectScrollPopUpActivity.class);

                ProductsInfoArrayList.productsInfoArrayList.size();

                inspectScrollActivity.putExtras(bundle);

                startActivity(inspectScrollActivity);
                finish();
            }
        });

        btnAddToCartPC9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle cartBundle = new Bundle();
                cartBundle.putInt("productId", 8);
                cartBundle.putString("productName", "CLX Revo Gaming Desktop");
                cartBundle.putDouble("productPrice", 3149.99);
                cartBundle.putInt("whichActivity", 2);
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
                activityBundle.putInt("whichActivity", 2);
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