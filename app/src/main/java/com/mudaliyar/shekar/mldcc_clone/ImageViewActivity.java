package com.mudaliyar.shekar.mldcc_clone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageViewActivity extends AppCompatActivity {
    ImageView imageView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        intent = getIntent();
        imageView = (ImageView)findViewById(R.id.image);
        String string = intent.getStringExtra("image");
        Picasso.with(getApplicationContext()).load(string).into(imageView);
    }
}
