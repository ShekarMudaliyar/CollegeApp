package com.mudaliyar.shekar.mldcc_clone;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    GridLayout gridLayout;
    Intent intent;
    ViewPager viewPager;
    BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigationdrawer);
        //fcm
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        };
        registerReceiver(broadcastReceiver,new IntentFilter(MyFirebaseInstanceIdService.TOKEN_BROADCAST));


        //image slider
        viewPager = findViewById(R.id.viewPager);
        Timer timer= new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),2000,4000);
        ViewPagerAdapter viewPagerAdapter=  new ViewPagerAdapter(getApplicationContext());
        viewPager.setAdapter(viewPagerAdapter);
        //menu drawer
        drawerLayout= (DrawerLayout)findViewById(R.id.drawermain);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        gridLayout = (GridLayout)findViewById(R.id.maingrid);
        //set event
        setSingleEvent(gridLayout);
        navigationView = (NavigationView)findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id){
                    case R.id.nav_home:
                        break;

                    case R.id.nav_PrMsg:
                        intent=new Intent(getApplicationContext(),NavPrinMsg.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_activities:
                        intent=new Intent(getApplicationContext(),ActivitiesActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_cources:
                        intent=new Intent(getApplicationContext(),CoursesActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_staff:
                        intent=new Intent(getApplicationContext(),StaffActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_convocation:
                        intent=new Intent(getApplicationContext(),ConvocationActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_aboutus:
                        break;

                    case R.id.nav_contact:
                        break;

                    case R.id.nav_aboutapp:
                        break;

                    case R.id.nav_settings:
                        break;

                    case R.id.nav_feedback:
                        intent=new Intent(getApplicationContext(),FeedbackActivity.class);
                        startActivity(intent);
                        break;

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

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
                          String type ="pdfnotice";
                          BackgroundWorker backgroundWorker = new BackgroundWorker(getApplicationContext());
                          backgroundWorker.execute(type);
                          break;
                      case 1:
                          intent=new Intent(getApplicationContext(),ResultActivity.class);
                          startActivity(intent);
                          break;
                      case 2:
                          intent=new Intent(getApplicationContext(),EventsActivity.class);
                          startActivity(intent);
                          break;
                      case 3:
                          String type1 ="gallery";
                          BackgroundWorker backgroundWorker1 = new BackgroundWorker(getApplicationContext());
                          backgroundWorker1.execute(type1);
                          break;
                      case 4:
                          intent=new Intent(getApplicationContext(),LibraryActivity.class);
                          startActivity(intent);
                          break;
                      case 5:
                          String type3 ="notifications";
                          BackgroundWorker backgroundWorker3 = new BackgroundWorker(getApplicationContext());
                          backgroundWorker3.execute(type3);
                          break;
                  }
                }
            });
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }


    }
    public class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);
                    }else if(viewPager.getCurrentItem() ==1){
                        viewPager.setCurrentItem(2);
                    }else{
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
