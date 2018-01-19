package com.roshank.grihaestate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PropertyDetailActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView save, favourite, share, call, info, gallery, property, location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_detail);

        save = (ImageView) findViewById(R.id.save);
        share = (ImageView) findViewById(R.id.share);
        favourite = (ImageView) findViewById(R.id.favourite);
        call = (ImageView) findViewById(R.id.call);
        info = (ImageView) findViewById(R.id.info);
        gallery = (ImageView) findViewById(R.id.gallery);
        property = (ImageView) findViewById(R.id.property);
        location = (ImageView) findViewById(R.id.location);

        save.setOnClickListener(this);
        share.setOnClickListener(this);
        favourite.setOnClickListener(this);
        call.setOnClickListener(this);
        info.setOnClickListener(this);
        gallery.setOnClickListener(this);
        property.setOnClickListener(this);
        location.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.share) {
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
        } else if (v.getId() == R.id.save) {
            saveprocess();
        } else if (v.getId() == R.id.favourite) {
            saveprocess();
        } else if (v.getId() == R.id.call) {
            saveprocess();
        } else if (v.getId() == R.id.info) {
            saveprocess();
        } else if (v.getId() == R.id.gallery) {
            saveprocess();
        }
        else if (v.getId() == R.id.property) {
            saveprocess();
        }
        else if (v.getId() == R.id.location) {
            startActivity(new Intent(this, MapsActivity.class));
        }

    }

    public void backprocess() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void saveprocess() {
        Intent intent = new Intent(this, Login_Activity.class);
        startActivity(intent);
    }
}



