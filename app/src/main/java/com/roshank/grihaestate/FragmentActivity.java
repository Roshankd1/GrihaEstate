
package com.roshank.grihaestate;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.roshank.grihaestate.Fragment.FragmentForSale;
import com.roshank.grihaestate.Fragment.FragmentLongLet;
import com.roshank.grihaestate.Fragment.FragmentShortLet;

public class FragmentActivity extends AppCompatActivity implements View.OnClickListener{

    FragmentForSale fragmentforsale;
    FragmentLongLet fragmentlonglet;
    FragmentShortLet fragmentshortlet;
    TextView forsale, longlet, shortlet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        fragmentforsale = new FragmentForSale();
        fragmentlonglet = new FragmentLongLet();
        fragmentshortlet = new FragmentShortLet();

        forsale = (TextView) findViewById(R.id.forsale);
        longlet = (TextView) findViewById(R.id.longlet);
        shortlet = (TextView) findViewById(R.id.shortlet);

        forsale.setOnClickListener(this);
        longlet.setOnClickListener(this);
        shortlet.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.forsale) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentforsale).commit();

        } else if (v.getId() == R.id.longlet) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentlonglet).commit();

        } else if (v.getId() == R.id.shortlet) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentshortlet).commit();

        }
    }
}


