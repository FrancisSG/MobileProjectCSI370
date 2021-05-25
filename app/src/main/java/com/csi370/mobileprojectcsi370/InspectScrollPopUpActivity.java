package com.csi370.mobileprojectcsi370;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class InspectScrollPopUpActivity extends AppCompatActivity {

    int productId;

    TextView txtVProductName, txtVProductBrand, txtVProductCPU, txtVProductRAM, txtVProductHDD, txtVProductSSD, txtVProductGraphics, txtVProductOS;

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspect_scroll);
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

                DisplayMetrics display = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(display);

                int width = display.widthPixels;
                int height = display.heightPixels;

                getWindow().setLayout((int)(width*.7), (int)(height*.5));

                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.gravity = Gravity.CENTER;
                params.x = 0;
                params.y = -20;

                getWindow().setAttributes(params);

                btnBack = (Button) findViewById(R.id.btnBackInspectScroll);
                txtVProductName = (TextView) findViewById(R.id.txtVProductName);
        txtVProductBrand = (TextView) findViewById(R.id.txtVProductBrand);
        txtVProductCPU = (TextView) findViewById(R.id.txtVProductCpu);
        txtVProductRAM = (TextView) findViewById(R.id.txtVProductRam);
        txtVProductHDD = (TextView) findViewById(R.id.txtVProductHdd);
        txtVProductSSD = (TextView) findViewById(R.id.txtVProductSsd);
        txtVProductGraphics = (TextView) findViewById(R.id.txtVProductGraphics);
        txtVProductOS = (TextView) findViewById(R.id.txtVProductOs);


        Bundle bundle = getIntent().getExtras();
        productId = bundle.getInt("productId", 1);

        //Populating fields
        txtVProductName.setText(txtVProductName.getText().toString() + ProductsInfoArrayList.productsInfoArrayList.get(productId).getName());
        txtVProductBrand.setText(txtVProductBrand.getText().toString() + ProductsInfoArrayList.productsInfoArrayList.get(productId).getBrand());
        txtVProductCPU.setText(txtVProductCPU.getText().toString() + ProductsInfoArrayList.productsInfoArrayList.get(productId).getCpu());
        txtVProductRAM.setText(txtVProductRAM.getText().toString() + ProductsInfoArrayList.productsInfoArrayList.get(productId).getRam());
        txtVProductHDD.setText(txtVProductHDD.getText().toString() + ProductsInfoArrayList.productsInfoArrayList.get(productId).getHdd());
        txtVProductSSD.setText(txtVProductSSD.getText().toString() + ProductsInfoArrayList.productsInfoArrayList.get(productId).getSsd());
        txtVProductGraphics.setText(txtVProductGraphics.getText().toString() + ProductsInfoArrayList.productsInfoArrayList.get(productId).getGraphics());
        txtVProductOS.setText(txtVProductOS.getText().toString() + ProductsInfoArrayList.productsInfoArrayList.get(productId).getOs());

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent officePCActivity = new Intent(getApplicationContext(), OfficePCActivity.class);
                startActivity(officePCActivity);
                finish();
            }
        });


    }
}