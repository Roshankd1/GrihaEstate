package com.roshank.grihaestate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.roshank.grihaestate.R;

public class PropertyList_Activity extends AppCompatActivity implements View.OnClickListener {

    ImageView house1, save, share, map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_list);
        house1 = (ImageView) findViewById(R.id.house1);
        save = (ImageView) findViewById(R.id.save);
        share = (ImageView) findViewById(R.id.share);
        map = (ImageView) findViewById(R.id.map);

        house1.setOnClickListener(this);
        save.setOnClickListener(this);
        share.setOnClickListener(this);
        map.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.house1) {
            startActivity(new Intent(this, PropertyDetailActivity.class));
        } else if (v.getId() == R.id.save) {

        } else if (v.getId() == R.id.share) {
            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBody = "Your body here";
                    String shareSub = "Your subject here";
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    startActivity(Intent.createChooser(sharingIntent, "Share using"));
                }
            });
        } else if (v.getId() == R.id.map) {
startActivity(new Intent(this, MapsActivity.class));
        }
    }
}