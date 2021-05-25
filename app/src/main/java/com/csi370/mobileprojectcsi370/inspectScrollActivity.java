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

public class inspectScrollActivity extends AppCompatActivity {

    int productId;

    TextView txtVProductName;

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

                Bundle bundle = getIntent().getExtras();
                productId = bundle.getInt("productId", 1);

                //Populating fields
                txtVProductName.setText(txtVProductName.getText().toString() + ProductsInfoArrayList.productsInfoArrayList.get(productId).getName());

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