package com.roshank.grihaestate.Fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.roshank.grihaestate.MapsActivity;
import com.roshank.grihaestate.R;

import java.util.zip.Inflater;

public class MyPropertyFragment extends Fragment {

    ImageView gobutton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_property_fragment, null);

        gobutton = view.findViewById(R.id.gobutton);

view.findViewById(R.id.gobutton).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      startActivity(new Intent(getActivity(), MapsActivity.class));
    }
});
        return view;
    }
}
