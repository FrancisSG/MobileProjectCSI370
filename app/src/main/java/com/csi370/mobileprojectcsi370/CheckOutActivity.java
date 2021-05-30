package com.csi370.mobileprojectcsi370;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CheckOutActivity extends AppCompatActivity {

    boolean isGuest = true;

    TextView txtVTotalPrice, txtVForGuest;
    EditText edtAddress, edtPhoneNumber;
    Button btnConfirmPurchase,btnBack;

    SQLDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        if(AppUserDb.loggedInUserId != -1){
            isGuest = false;
        }

        edtAddress = (EditText) findViewById(R.id.edtAddressRegisterCheckOut);
        edtPhoneNumber = (EditText) findViewById(R.id.edtPhoneNumberCheckOut);
        txtVTotalPrice = (TextView) findViewById(R.id.txtVTotalCheckout);
        txtVForGuest = (TextView) findViewById(R.id.txtVForGuest);
        btnConfirmPurchase = (Button) findViewById(R.id.btnConfirmPurchase);
        btnBack = (Button) findViewById(R.id.btnBackCheckout);

        database = new SQLDatabase(getApplicationContext());
//        ArrayList<Purchase> Pur_List = new ArrayList<Purchase>();
//        Pur_List.get(LoginActivity.userID);

        Bundle bundle = getIntent().getExtras();
        txtVTotalPrice.setText("$" + bundle.getDouble("grandTotal", 0.0));

        if(!isGuest) {
            edtAddress.setVisibility(View.GONE);
            edtPhoneNumber.setVisibility(View.GONE);
            txtVForGuest.setVisibility(View.GONE);
        }

        btnConfirmPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isGuest) {
                    // If EditText are empty
                    if(TextUtils.isEmpty(edtAddress.getText().toString()) && TextUtils.isEmpty(edtPhoneNumber.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Fill in the field(s)!", Toast.LENGTH_SHORT).show();
                    }
                    // If EditText are not empty
                    else {
                        database.insertProducts(Cart.cart.get(LoginActivity.userID));
                        Toast.makeText(getApplicationContext(), "Order is processing!", Toast.LENGTH_SHORT).show();

                        txtVTotalPrice.setText("Thank you for your purchase!");

                        //Empty Cart
                        MainActivity.purchaseID = 0;
                        Cart.cart.clear();
                        Intent i = new Intent(getApplicationContext(), CategoriesActivity.class);
                        startActivity(i);
                        finish();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Order is processing!", Toast.LENGTH_SHORT).show();

                    txtVTotalPrice.setText("Thank you for your purchase!");

                    //Empty Cart
                    MainActivity.purchaseID = 0;
                    Cart.cart.clear();
                    Intent i = new Intent(getApplicationContext(), CategoriesActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myCartActivity = new Intent(getApplicationContext(), MyCartActivity.class);
                Bundle whichActivityBundle = new Bundle();
                Bundle whichActivityBundleFromMyCart = getIntent().getExtras();

                whichActivityBundle.putInt("whichActivity",whichActivityBundleFromMyCart.getInt("whichActivity"));

                myCartActivity.putExtras(whichActivityBundle);
                startActivity(myCartActivity);
                finish();
            }
        });



    }
}