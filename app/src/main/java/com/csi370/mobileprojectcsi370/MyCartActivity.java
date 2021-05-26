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

public class MyCartActivity extends AppCompatActivity {

    Button btnBack, btnRemovePurchase;
    TextView txtVCartContents;
    EditText edtRemovePurchase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        btnBack = (Button) findViewById(R.id.btnBackMyCart);
        btnRemovePurchase = (Button) findViewById(R.id.btnRemovePurchaseMyCart);
        txtVCartContents = (TextView) findViewById(R.id.txtVCartContents);
        edtRemovePurchase = (EditText) findViewById(R.id.edtEnterProductIDMyCart);

        String text = "";
        double grandTotal = 0.0;

        if(!Cart.cart.isEmpty()) {
            for (Purchase purchase : Cart.cart) {
                text += buildString(purchase) + "\n\n";
                grandTotal += purchase.getPrice();
            }

            text += "\nGrand Total of $" + grandTotal;
            txtVCartContents.setText(text);

        } else {
            text += "Cart is currently empty";
            txtVCartContents.setText(text);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent officePCActivity = new Intent(getApplicationContext(), OfficePCActivity.class);
                startActivity(officePCActivity);
                finish();
            }
        });

        btnRemovePurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(edtRemovePurchase.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Fill in the field!", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }



    private String buildString(Purchase purchase) {

        String builtString = "";
        String user;

        if(purchase.getUserId() == -1){
            user = "guest";
        } else {
            user = "" + purchase.getUserId();
        }

        builtString += "Product Name: " + purchase.getProductName() + "\n" + "Sum: (" + purchase.getQuantity() + " item(s)) $" + purchase.getPrice()
        + "\n" + "Purchaser ID: " + user;

        return builtString;
    }

    public boolean removePurchase(ArrayList<Cart> cart, int idOfPurchaseToRemove){

        for(Purchase purchase: Cart.cart) {
            if(Integer.parseInt(edtRemovePurchase.getText().toString()) == idOfPurchaseToRemove) {
                Cart.cart.remove(idOfPurchaseToRemove);
            }
        }

        return false;
    }

}