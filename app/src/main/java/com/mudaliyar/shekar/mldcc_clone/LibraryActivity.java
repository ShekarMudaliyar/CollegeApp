package com.mudaliyar.shekar.mldcc_clone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        getSupportActionBar().setTitle("Library");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
