package com.roshank.grihaestate.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roshank.grihaestate.R;

/**
 * Created by roshank on 06/12/2017.
 */

public class SettingsFragmentActivity extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_settting, null);
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}


