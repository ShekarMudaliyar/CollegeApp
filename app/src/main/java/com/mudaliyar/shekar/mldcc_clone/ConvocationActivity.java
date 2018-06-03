package com.mudaliyar.shekar.mldcc_clone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ConvocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convocation);
        getSupportActionBar().setTitle("Convocation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
