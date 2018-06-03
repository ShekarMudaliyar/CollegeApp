package com.mudaliyar.shekar.mldcc_clone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class GalleryActivity extends AppCompatActivity {
    ImageView imageView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        getSupportActionBar().setTitle("Gallery");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        intent = getIntent();
        String temp = intent.getStringExtra("gallery");
        final String[] gal_url = temp.split("~");

        GridView gridView = (GridView)findViewById(R.id.grid);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent2 = new Intent(getApplicationContext(),ImageViewActivity.class);
                intent2.putExtra("image",gal_url[position]);
                startActivity(intent2);
            }
        });
        gridView.setAdapter(new BaseAdapter() {

            @Override
            public int getCount() {
                return gal_url.length;
            }

            @Override
            public Object getItem(int position) {
                return gal_url[position];
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                imageView = new ImageView(getApplicationContext());
                Picasso.with(getApplicationContext()).load(gal_url[position]).into(imageView);
                return imageView;
            }
        });

    }

}
