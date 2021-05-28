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

    Button btnBack, btnRemovePurchase, btnCheckout;
    TextView txtVCartContents;
    EditText edtRemovePurchase;

    public static double grandTotal = 0.0;
    public double bGrandTotal = 0.0;
    public static String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        btnBack = (Button) findViewById(R.id.btnBackMyCart);
        btnCheckout = (Button) findViewById(R.id.btnCheckoutMyCart);
        btnRemovePurchase = (Button) findViewById(R.id.btnRemovePurchaseMyCart);
        txtVCartContents = (TextView) findViewById(R.id.txtVCartContents);
        edtRemovePurchase = (EditText) findViewById(R.id.edtEnterProductIDMyCart);


        updateCart(text, grandTotal);

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
                } else {
                    removePurchase(Integer.parseInt(edtRemovePurchase.getText().toString()));
                    updateCart("", grandTotal);
                }

            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Cart.cart.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Cart is empty!", Toast.LENGTH_SHORT).show();
                } else {

                    Bundle totalPriceBundle = new Bundle();
                    totalPriceBundle.putDouble("grandTotal", bGrandTotal);
                    Intent checkOutActivity = new Intent(getApplicationContext(), CheckOutActivity.class);
                    checkOutActivity.putExtras(totalPriceBundle);
                    startActivity(checkOutActivity);
                    finish();
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
        + "\n" + "Purchaser ID: " + user + "\n" + "Purchase ID: " + purchase.getPurchaseId() ;

        return builtString;
    }

    private void updateCart(String text, double grandTotal){

        if(!Cart.cart.isEmpty()) {
            for (Purchase purchase : Cart.cart) {
                text += buildString(purchase) + "\n\n";
                grandTotal += purchase.getPrice();
            }

            text += "\nGrand Total of $" + grandTotal;
            bGrandTotal = grandTotal;
            txtVCartContents.setText(text);

        } else {
            text += "Cart is currently empty";
            txtVCartContents.setText(text);
        }

    }

    public void removePurchase(int idOfPurchaseToRemove){

        boolean isFound = false;

        if(Cart.cart.isEmpty()){
            Toast.makeText(getApplicationContext(), "Nothing to remove!", Toast.LENGTH_SHORT).show();
        } else {
            for(Purchase purchase: Cart.cart) {
                if(idOfPurchaseToRemove == purchase.getPurchaseId()) {
                    Cart.cart.remove(purchase);
                    isFound = true;
                    break;
                }
            }
        }

        if(isFound) {
            Toast.makeText(getApplicationContext(), "Purchase removed!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Purchase with that ID does not exist!", Toast.LENGTH_SHORT).show();

        }
    }

}