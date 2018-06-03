package com.mudaliyar.shekar.mldcc_clone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class EventsActivity extends AppCompatActivity {
GridLayout gridLayout;
Intent intent;
ImageView imageView1,imageView2,imageView3,imageView4,imageView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        getSupportActionBar().setTitle("Events");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        gridLayout = findViewById(R.id.eventgrid);
        setSingleEvent(gridLayout);
        imageView1=findViewById(R.id.event_1);
        imageView2=findViewById(R.id.event_2);
        imageView3=findViewById(R.id.event_3);
        imageView4=findViewById(R.id.event_4);
        imageView5=findViewById(R.id.event_5);
        Picasso.with(getApplicationContext()).load("https://mldcc-clone4.000webhostapp.com/1.jpg")
                .into(imageView1);
        Picasso.with(getApplicationContext()).load("https://mldcc-clone4.000webhostapp.com/2.jpg")
                .into(imageView2);
        Picasso.with(getApplicationContext()).load("https://mldcc-clone4.000webhostapp.com/3.jpg")
                .into(imageView3);
        Picasso.with(getApplicationContext()).load("https://mldcc-clone4.000webhostapp.com/4.jpg")
                .into(imageView4);
        Picasso.with(getApplicationContext()).load("https://mldcc-clone4.000webhostapp.com/5.jpg")
                .into(imageView5);
    }
    private void setSingleEvent(GridLayout gridLayout) {
        //loop child item in main grid
        for(int i=0;i<gridLayout.getChildCount();i++){
            CardView cardView =(CardView)gridLayout.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch(finalI){
                        case 0:
                            String type1 ="gallery";
                            BackgroundWorker backgroundWorker1 = new BackgroundWorker(getApplicationContext());
                            backgroundWorker1.execute(type1);
                            break;
                        case 1:
                            String type2 ="gallery";
                            BackgroundWorker backgroundWorker2 = new BackgroundWorker(getApplicationContext());
                            backgroundWorker2.execute(type2);
                            break;
                        case 2:
                            String type3 ="gallery";
                            BackgroundWorker backgroundWorker3 = new BackgroundWorker(getApplicationContext());
                            backgroundWorker3.execute(type3);
                            break;
                        case 3:
                            String type4 ="gallery";
                            BackgroundWorker backgroundWorker4 = new BackgroundWorker(getApplicationContext());
                            backgroundWorker4.execute(type4);
                            break;
                        case 4:
                            String type5 ="gallery";
                            BackgroundWorker backgroundWorker5 = new BackgroundWorker(getApplicationContext());
                            backgroundWorker5.execute(type5);
                            break;
                    }
                }
            });
        }

    }
}
