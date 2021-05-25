package com.csi370.mobileprojectcsi370;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AddToCartPopUpActivity extends AppCompatActivity {

    TextView txtVPrice;
    EditText edtQuantity;
    Button btnAddToCart, btnBack;

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_to_cart_pop_up);

        // Pop Up code
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

        // Other Code

        txtVPrice = (TextView) findViewById(R.id.txtVPriceAddToCart);
        edtQuantity = (EditText) findViewById(R.id.edtQuantityPopUp);
        btnAddToCart = (Button) findViewById(R.id.btnAddToCartPC1PopUp);
        btnBack = (Button) findViewById(R.id.btnBackAddToCartPopUp);

        Bundle cartBundle = getIntent().getExtras();
        txtVPrice.setText(txtVPrice.getText().toString() + "$" + cartBundle.getDouble("productPrice"));

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(!TextUtils.isEmpty(edtQuantity.getText().toString())){

                    if(Integer.parseInt(edtQuantity.getText().toString()) <= 0){
                        Toast.makeText(getApplicationContext(), "You can only order 1 or more items!", Toast.LENGTH_SHORT).show();

                    } else {

                        quantity =  Integer.parseInt(edtQuantity.getText().toString());

                        Cart.cart.add(new Purchase(AppUserDb.loggedInUserId,
                                cartBundle.getInt("productId", 0),
                                quantity,
                                (quantity*cartBundle.getDouble("productPrice"))));

                        Toast.makeText(getApplicationContext(), "Added to cart!", Toast.LENGTH_SHORT).show();
                        Cart.cart.size();

                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Fill in the field!", Toast.LENGTH_SHORT).show();
                }

            }
        });

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