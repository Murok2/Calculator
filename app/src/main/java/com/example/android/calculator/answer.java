package com.example.android.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class answer extends AppCompatActivity {
    TextView tv;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer);

        tv=findViewById(R.id.Result);

        st=getIntent().getExtras().getString("Answer");

        tv.setText(st);

    }

}
