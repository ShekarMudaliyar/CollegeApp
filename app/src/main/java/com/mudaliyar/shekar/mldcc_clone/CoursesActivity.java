package com.mudaliyar.shekar.mldcc_clone;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CoursesActivity extends AppCompatActivity {
        ViewPager viewPager;
        LinearLayout dotlayout;
        SliderAdapter sliderAdapter;
        TextView[] dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        getSupportActionBar().setTitle("Courses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = findViewById(R.id.slider);
        dotlayout = findViewById(R.id.dotpager);
        sliderAdapter= new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        dotsIndicator();
    }
    public void dotsIndicator(){
        dots=new TextView[3];
        for(int i=0;i<dots.length;i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(50);
            dotlayout.addView(dots[i]);

        }
    }
}
