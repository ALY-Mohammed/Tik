package com.example.tic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private TextView text1 , text2;
    private ImageView imageView5,imageView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView10 = (ImageView) findViewById(R.id.imageView10);

        text1 =(TextView) findViewById(R.id.one);
        text2 =(TextView) findViewById(R.id.two);
        Bundle d = getIntent().getExtras();
        String r3 = d.getString("n1");
        String r4 = d.getString("n2");
    }
}