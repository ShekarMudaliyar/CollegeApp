package com.mudaliyar.shekar.mldcc_clone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

public class NoticePdfActivity extends AppCompatActivity {
    Intent intent;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_pdf);
        intent = getIntent();
        String temp = intent.getStringExtra("notices");
        String[] notices = temp.split("!");
        ListAdapter listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,notices);
        listView = (ListView)findViewById(R.id.listnotice);
        listView.setAdapter(listAdapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Notices");
    }
}
