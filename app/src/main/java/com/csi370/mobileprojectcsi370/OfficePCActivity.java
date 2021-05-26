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

public class OfficePCActivity extends AppCompatActivity {



    Button btnInspectPC1, btnAddToCartPC1, btnMyCart, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_p_c);
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

        btnInspectPC1 = (Button) findViewById(R.id.btnInspectPC1);
        btnAddToCartPC1 = (Button) findViewById(R.id.btnAddtoCartPC1);
        btnMyCart = (Button) findViewById(R.id.btnMyCartScrollingOffice);
        btnBack = (Button) findViewById(R.id.btnBackScrollingOffice);

        btnInspectPC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //populate ArrayList with Office PC 1's information
                ProductsInfoArrayList.productsInfoArrayList.add(new ProductDescription(

                        0,
                        "MSI - Desktop Computer, Mini-Desktop",
                        "MSI",
                        "i3 10th Gen i3-10110U",
                        "8 GB RAM DDR4 SDRAM",
                        "1 TB HDD",
                        "Unavailable",
                        "Intel HD Graphics 620",
                        "Windows 10",
                        549.99

                ));

                Bundle bundle = new Bundle();
                bundle.putInt("productId", 0);

                Intent inspectScrollActivity = new Intent(getApplicationContext(), InspectScrollPopUpActivity.class);

                inspectScrollActivity.putExtras(bundle);

                startActivity(inspectScrollActivity);
                finish();
            }
        });

        btnAddToCartPC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle cartBundle = new Bundle();
                cartBundle.putInt("productId", 0);
                cartBundle.putString("productName", "MSI - Desktop Computer, Mini-Desktop");
                cartBundle.putDouble("productPrice", 549.99);

                Intent addToCartPopUpActivity = new Intent(getApplicationContext(), AddToCartPopUpActivity.class);

                addToCartPopUpActivity.putExtras(cartBundle);

                startActivity(addToCartPopUpActivity);
                finish();
            }
        });

        btnMyCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myCartActivity = new Intent(getApplicationContext(), MyCartActivity.class);
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