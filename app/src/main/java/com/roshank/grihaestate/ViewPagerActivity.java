package com.roshank.grihaestate;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.roshank.grihaestate.Fragment.FragmentForSale;
import com.roshank.grihaestate.Fragment.FragmentLongLet;
import com.roshank.grihaestate.Fragment.FragmentShortLet;

public class ViewPagerActivity extends AppCompatActivity {

    ViewPager pager;
    TextView forsale, longlet, shortlet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_navigation);

        pager = (ViewPager) findViewById(R.id.pager);

        forsale = (TextView) findViewById(R.id.forsale);
        longlet = (TextView) findViewById(R.id.longlet);
        shortlet = (TextView) findViewById(R.id.shortlet);

        forsale.setOnClickListener(tabclicklistner);
        longlet.setOnClickListener(tabclicklistner);
        shortlet.setOnClickListener(tabclicklistner);

        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }

    public View.OnClickListener tabclicklistner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.forsale) {
                pager.setCurrentItem(0);
            } else if (v.getId() == R.id.longlet) {
                pager.setCurrentItem(1);

            } else if (v.getId() == R.id.shortlet) {
                pager.setCurrentItem(2);
            }
        }
    };

    public class ViewPagerAdapter extends FragmentPagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new FragmentForSale();
            }
            else if (position == 1)
                return new FragmentLongLet();
            else return new FragmentShortLet();
        }
        @Override
        public int getCount() {
            return 3;
        }
    }
}

