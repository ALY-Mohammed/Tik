package com.example.tic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.tic.MainActivity;
import com.example.tic.R;

public class MainActivity2 extends AppCompatActivity {

    Button start;
    RadioGroup XO_radio_group1,XO_radio_group2;
    RadioButton X_radio_btn1,O_radio_btn1,X_radio_btn2,O_radio_btn2;
    EditText  input1,input2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        start = (Button) findViewById(R.id.start_btn);
        XO_radio_group1=(RadioGroup) findViewById(R.id.XO_radio_group1);
        XO_radio_group2 = (RadioGroup) findViewById(R.id.xo_radio_group2);
        X_radio_btn1= (RadioButton ) findViewById(R.id.X_radio_btn1);
        O_radio_btn1= (RadioButton ) findViewById(R.id.O_radio_btn1);
        X_radio_btn2= (RadioButton ) findViewById(R.id.X_radio_btn2);
        O_radio_btn2= (RadioButton ) findViewById(R.id.O_radio_btn2);
        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);

        start.setOnClickListener(view -> {
            StringBuilder result = new StringBuilder();
            StringBuilder data = new StringBuilder();

            StringBuilder result2 = new StringBuilder();
            StringBuilder data2 = new StringBuilder();
            // show result string

            result.append(((X_radio_btn1.isChecked()) ? "X" : " ").toString());
            result.append(((O_radio_btn1.isChecked()) ? "O" : " ").toString());
            data.append(((X_radio_btn2.isChecked()) ? "X" : " ")).toString();
            data.append(((O_radio_btn2.isChecked()) ? "O" : "")).toString();

            result2.append(input1.getText()).toString();
            data2.append(input2.getText()).toString();

            Intent myintent = new Intent (this, MainActivity.class);

            Bundle b = new Bundle();

            b.putString("radioOne",result.toString());
            b.putString("radioTwo",data.toString());
            b.putString("text1",result2.toString());
            b.putString("text2",data2.toString());


            myintent.putExtras(b);
            startActivity(myintent);


        });
    }
}

