package com.roshank.grihaestate;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.roshank.grihaestate.Fragment.FragmentForSale;
import com.roshank.grihaestate.Fragment.FragmentLongLet;
import com.roshank.grihaestate.Fragment.FragmentShortLet;
import com.roshank.grihaestate.Fragment.MyGrihaEstateFragment;
import com.roshank.grihaestate.Fragment.MyPropertyFragment;
import com.roshank.grihaestate.Fragment.ViewpagerFragment;

public class LoggedInFragmentActivity extends Fragment {


        ViewPager pager;
        TextView mygrihaestate, myproperty;


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_logged_in, null);

            pager = (ViewPager) view.findViewById(R.id.pager);

            mygrihaestate = (TextView) view.findViewById(R.id.mygrihaestate);
            myproperty = (TextView) view.findViewById(R.id.myproperty);

            mygrihaestate.setOnClickListener(tabclicklistner);
            myproperty.setOnClickListener(tabclicklistner);

            pager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));

            return view;
        }

        public View.OnClickListener tabclicklistner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mygrihaestate.setBackgroundColor(Color.WHITE);
                myproperty.setBackgroundColor(Color.WHITE);
                if (v.getId() == R.id.mygrihaestate) {
                    mygrihaestate.setBackgroundResource(R.drawable.fragmentbutton);
                     pager.setCurrentItem(0);
                } else if (v.getId() == R.id.myproperty) {
                    myproperty.setBackgroundResource(R.drawable.fragmentbutton);
                      pager.setCurrentItem(1);

                }
            }
        };

        public class ViewPagerAdapter extends FragmentPagerAdapter {
            public ViewPagerAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int position) {
                mygrihaestate.setBackgroundColor(Color.WHITE);
                myproperty.setBackgroundColor(Color.WHITE);

                if (position == 0) {
                    mygrihaestate.setBackgroundResource(R.drawable.fragmentbutton);
                    return new MyGrihaEstateFragment();
                } else {
                    myproperty.setBackgroundResource(R.drawable.fragmentbutton);
                    return new MyPropertyFragment();

                }
            }

            @Override
            public int getCount() {
                return 2;}
        }
}
