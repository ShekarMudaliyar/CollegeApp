package com.mudaliyar.shekar.mldcc_clone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class NotificationActivity extends AppCompatActivity {
    ListView listView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        getSupportActionBar().setTitle("Notifications");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        intent = getIntent();
        String temp = intent.getStringExtra("notification");
        String[] notifications = temp.split("%");
        ListAdapter listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,notifications);
        listView = (ListView)findViewById(R.id.listnotification);
        listView.setAdapter(listAdapter);

    }
}
