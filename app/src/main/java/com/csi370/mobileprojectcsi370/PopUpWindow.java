package com.csi370.mobileprojectcsi370;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class PopUpWindow extends AppCompatActivity {

    RadioButton yesBT, noBT;
    Button submitBT;

//    public static final String isCheckedYes = "IS_CHECKED_YES";
//    public static final String isCheckedNo = "IS_CHECKED_NO";
//    public static final int yesChecked = 0;
//    public static final int noChecked = 1;
//    public static int count = 0;
//    public static int procCount = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_window);

//        submitBT = (Button) findViewById(R.id.submitButton);
//        yesBT = (RadioButton) findViewById(R.id.yesButton);
//        noBT = (RadioButton) findViewById(R.id.noButton);

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

//        submitBT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (yesBT.isChecked())
//                {
//                    Intent openLogAct = new Intent (getApplicationContext(), LoginActivity.class);
//
//                    count++;
//                    procCount++;
//                    Bundle bundle = new Bundle();
//                    bundle.putInt(isCheckedYes, yesChecked);
//                    startActivity(openLogAct);
//                    finish();
//                }
//                else if (noBT.isChecked())
//                {
//                    Intent openLogAct = new Intent (getApplicationContext(), LoginActivity.class);
//
//                    procCount++;
//                    Bundle bundle = new Bundle();
//                    bundle.putInt(isCheckedNo, noChecked);
//                    startActivity(openLogAct);
//                    finish();
//                }
//                else
//                {
//                    Toast.makeText(getApplicationContext(), "Please choose one of the Options!", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

    }
}