package com.mudaliyar.shekar.mldcc_clone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StaffActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        getSupportActionBar().setTitle("Staff");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
