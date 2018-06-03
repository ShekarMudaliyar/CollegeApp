package com.mudaliyar.shekar.mldcc_clone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    EditText seatno;
    Button submit;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        spinner= (Spinner)findViewById(R.id.spinner);
      ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(ResultActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.section));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);
        seatno = (EditText) findViewById(R.id.seatno);
        getSupportActionBar().setTitle("Result");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    public void onLogin(View view){
        String section = spinner.getSelectedItem().toString();
        String seat_no =seatno.getText().toString();
        String type ="login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,section,seat_no);


    }
}
