package com.roshank.grihaestate.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.roshank.grihaestate.R;
import com.roshank.grihaestate.ViewPagerActivity;

/**
 * Created by roshank on 06/12/2017.
 */

public class ViewpagerFragment extends Fragment {

    ViewPager pager;
    TextView forsale, longlet, shortlet;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_view_pager, null);

        pager = (ViewPager) view.findViewById(R.id.pager);

        forsale = (TextView) view.findViewById(R.id.forsale);
        longlet = (TextView) view.findViewById(R.id.longlet);
        shortlet = (TextView) view.findViewById(R.id.shortlet);

        forsale.setOnClickListener(tabclicklistner);
        longlet.setOnClickListener(tabclicklistner);
        shortlet.setOnClickListener(tabclicklistner);
        pager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));
//        forsale.setBackgroundResource(R.drawable.fragmentbutton);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                forsale.setBackgroundColor(Color.WHITE);
                longlet.setBackgroundColor(Color.WHITE);
                shortlet.setBackgroundColor(Color.WHITE);
                if (position == 0) {
                    forsale.setBackgroundResource(R.drawable.fragmentbutton);
                } else if (position==1) {
                    longlet.setBackgroundResource(R.drawable.fragmentbutton);
                } else if (position== 2) {
                    shortlet.setBackgroundResource(R.drawable.fragmentbutton);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        pager.setCurrentItem(0);

        return view;
    }

    public View.OnClickListener tabclicklistner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            forsale.setBackgroundColor(Color.WHITE);
            longlet.setBackgroundColor(Color.WHITE);
            shortlet.setBackgroundColor(Color.WHITE);
            if (v.getId() == R.id.forsale) {
                forsale.setBackgroundResource(R.drawable.fragmentbutton);
                pager.setCurrentItem(0);
            } else if (v.getId() == R.id.longlet) {
                longlet.setBackgroundResource(R.drawable.fragmentbutton);
                pager.setCurrentItem(1);

            } else if (v.getId() == R.id.shortlet) {
                shortlet.setBackgroundResource(R.drawable.fragmentbutton);
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
            forsale.setBackgroundColor(Color.WHITE);
            longlet.setBackgroundColor(Color.WHITE);
            shortlet.setBackgroundColor(Color.WHITE);

            if (position == 0) {
                forsale.setBackgroundResource(R.drawable.fragmentbutton);

                return new FragmentForSale();
            } else if (position == 1) {
                longlet.setBackgroundResource(R.drawable.fragmentbutton);

                return new FragmentLongLet();

            } else {
                shortlet.setBackgroundResource(R.drawable.fragmentbutton);
                return new FragmentShortLet();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
