package com.roshank.grihaestate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class AminationActivity extends AppCompatActivity {

    LinearLayout splashscreen;
    Animation zoomin, zoomout, fadein, fadeout, combine, move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amination);

        splashscreen = (LinearLayout) findViewById(R.id.splashscreen);
        zoomin = AnimationUtils.loadAnimation(this,R.anim.zoom_in);
        zoomout = AnimationUtils.loadAnimation(this,R.anim.zoom_out);
        fadein = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        fadeout = AnimationUtils.loadAnimation(this,R.anim.fade_out);
        combine = AnimationUtils.loadAnimation(this,R.anim.combine_anim);
        move = AnimationUtils.loadAnimation(this,R.anim.move);


splashscreen.startAnimation(zoomin);
        zoomin.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
splashscreen.startAnimation(zoomin);
                startActivity(new Intent(AminationActivity.this, FragmentActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
