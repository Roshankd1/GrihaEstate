package com.roshank.grihaestate.Fragment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.roshank.grihaestate.MapsActivity;
import com.roshank.grihaestate.R;

public class MyGrihaEstateFragment extends Fragment {

    ImageView gobutton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_griha_estate_fragment,null);
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
