package com.mudaliyar.shekar.mldcc_clone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class finalResult extends AppCompatActivity {
    TextView textView;
    Intent intent;
    //ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);
        textView = (TextView)findViewById(R.id.final_text);
        intent=getIntent();
        String temp =intent.getStringExtra("final_result");
        String[] res = temp.split(",");
        textView.setText("Total marks:"+res[0]+"\nmaths:"+res[1]+"\njava:"+res[2]+"\ndbms:"+res[3]);
//        ListAdapter listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,res);
//        listView = (ListView)findViewById(R.id.listresult);
//        listView.setAdapter(listAdapter);
            getSupportActionBar().setTitle("Result");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
