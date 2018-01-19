package com.roshank.grihaestate;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.roshank.grihaestate.Fragment.FragmentShortLet;
import com.roshank.grihaestate.Fragment.MyGrihaEstateFragment;
import com.roshank.grihaestate.Fragment.MyPropertyFragment;
import com.roshank.grihaestate.Fragment.ViewpagerFragment;

/**
 * Created by roshank on 10/12/2017.
 */

public class LoggedInActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loggedinactivity_layout);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new LoggedInFragmentActivity()).commit();

    }
}
