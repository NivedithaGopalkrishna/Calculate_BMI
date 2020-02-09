/*
Group 22:
Dhawala Bhagawat
Niveditha Gopalkrishna
Rohan Sriram
*/
package com.example.group22_hw01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView tv_bmi;
    private TextView tv_weight;
    private TextView tv_height;
    private TextView tv_dispbmi;
    private TextView tv_dispbmistatus;
    private Button bt_calculate;
    private EditText et_weight;
    private EditText et_height;
    private EditText et_heightin;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("BMI Calculator");
        tv_bmi = findViewById(R.id.tv_BMI);
        tv_weight = findViewById(R.id.tv_weight);
        tv_height = findViewById(R.id.tv_height);
        tv_dispbmi = findViewById(R.id.tv_dispbmi);
        tv_dispbmistatus = findViewById(R.id.tv_dispbmistatus);
        bt_calculate = findViewById(R.id.bt_calculate);
        et_weight = findViewById(R.id.et_weight);
        et_height = findViewById(R.id.et_height);
        et_heightin = findViewById(R.id.et_heightin);
        double weight;
        double heightft;
        double heightin;

        String button_label = getResources().getString(R.string.calculate_button_label);
        bt_calculate.setText(button_label);



        bt_calculate.setOnClickListener(new View.OnClickListener() {

            double weight=0;
            double heightft=0;
            double heightin=0;
            double result=0;
            double fttoin=0;
            double totheightin=0;
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty((et_weight.getText())))
                {
                    et_weight.setError("Please Enter the value!!");
                    CharSequence text = "Invalid input";
                    addToast(text);

                }
                if(TextUtils.isEmpty((et_height.getText())))
                {
                    et_height.setError("Please Enter the value!!");
                    CharSequence text = "Invalid input";
                    addToast(text);
                }
                if(TextUtils.isEmpty((et_heightin.getText())))
                {
                    et_heightin.setError("Please Enter the value!!");
                    CharSequence text = "Invalid input";
                    addToast(text);
                }
                else {

                    weight = Double.parseDouble(et_weight.getText().toString());
                    heightft = Double.parseDouble(et_height.getText().toString());
                    heightin = Double.parseDouble(et_heightin.getText().toString());
                    fttoin = heightft * 12;
                    totheightin = fttoin + heightin;
                    result = (weight / (totheightin * totheightin)) * 703;
                    double res = Math.round(result * 10) / 10.0;
                    tv_dispbmi.setText("Your BMI: " + res);
                    if (res < 18.5) {
                        tv_dispbmistatus.setText("You are Underweight!");
                        CharSequence text = "BMI Calculated!";
                        addToast(text);

                    } else if (res >= 18.5 && res <= 24.9) {
                        tv_dispbmistatus.setText("Your weight is Normal!");
                        CharSequence text = "BMI Calculated!";
                        addToast(text);

                    } else if (res >= 25 && res <= 29.9) {
                        tv_dispbmistatus.setText("You are Overweight!");
                        CharSequence text = "BMI Calculated!";
                        addToast(text);

                    } else {
                        tv_dispbmistatus.setText("You are Obese!");
                        CharSequence text = "BMI Calculated!";
                        addToast(text);

                    }
                }

            }
        });

    }
    public void addToast(CharSequence calToast) {
        Context context = getApplicationContext();

        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context,calToast, duration);
        toast.show();
    }
}
