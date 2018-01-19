package com.roshank.grihaestate;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    TextView findproperties, resetfilter;
ImageView mylocation, map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_layout);

        findproperties = (TextView) findViewById(R.id.findproperties);
        resetfilter = (TextView) findViewById(R.id.resetfilter);
mylocation = (ImageView) findViewById(R.id.mylocation);
        map = (ImageView) findViewById(R.id.map);

        findproperties.setOnClickListener(this);
        resetfilter.setOnClickListener(this);
        mylocation.setOnClickListener(this);
        map.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.findproperties) {
            findpropertiesProcess();
        } else if (view.getId() == R.id.resetfilter) {
            resetfilterProcess();
        }else if (view.getId()==R.id.mylocation){
        startActivity(new Intent(this, MapsActivity.class));
            }
        else if (view.getId()==R.id.map){
            startActivity(new Intent(this, MapsActivity.class));
        }
    }
    public void findpropertiesProcess (){
        Intent intent = new Intent(this, PropertyList_Activity.class);
        startActivity(intent);

    }

    public void resetfilterProcess (){
Intent intent = new Intent (this, HomeActivity.class);
        startActivity(intent);
    }

}
