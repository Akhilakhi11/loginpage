package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity2 extends AppCompatActivity {
    @BindView(R.id.txt1)
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        ButterKnife.bind(this);
        String username= getIntent().getStringExtra("keyname");
        txt1.setText(username);
    }

}