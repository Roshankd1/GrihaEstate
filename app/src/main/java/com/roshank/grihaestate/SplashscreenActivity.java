package com.roshank.grihaestate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class SplashscreenActivity extends AppCompatActivity {

    ImageView splashscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        splashscreen = (ImageView) findViewById(R.id.splashscreen);

   /* to make thread
        findViewById(R.id.splashscreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        timetask();
                    }
                });
                thread.start();
            }
        });
    */
        splashscreen.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashscreenActivity.this, NavigationActivity.class));
            finish();
            }
        },1000);

    }


}
