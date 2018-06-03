package com.mudaliyar.shekar.mldcc_clone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NavPrinMsg extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_prin_msg);
        getSupportActionBar().setTitle("Principal's Message");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView = findViewById(R.id.prinimage);
        textView=findViewById(R.id.printext);
        Picasso.with(getApplicationContext()).load("https://mldcc-clone4.000webhostapp.com/principal.jpg")
                .into(imageView);
        textView.setText("M.L. Dahanukar College of Commerce is a vastly creative and motive part of the suburban Mumbai community that has been contributing to Indian Society by creating alert, righteous, exuberant and industrious citizens from last 52 years. Since the year 1960 this entity has witnessed not just the passing by years but tremendous growth in infrastructure, courses, co-curricular and extracurricular activities.\n" +
                "\n" +
                "Our past is writ large with the achievements of our alumni in fields as diverse as the corporate world, politics, dramatics, singing, acting, journalism, social activities and many more. These achievers will keenly attribute their success to the gurus and all others Dahanukarites who were and are the sturdy pillars of this institute. With respect to one and all I would to put on record my obeisance for all of them.\n" +
                "Education today has changed with its fragmentations, diversity and wide variety of choices. It is lot more demanding and intense. Education had always been a resource to be taken and not given. In today's date and age bookish knowledge cannot be the only measure of education but education needs to be an activity that makes learner more versatile and induces out-of-box thinking. Understanding the need of time we at Dahanukar strive hard to make each student a matured individual who can learn, unlearn and relearn.\n" +
                "");
    }
}
