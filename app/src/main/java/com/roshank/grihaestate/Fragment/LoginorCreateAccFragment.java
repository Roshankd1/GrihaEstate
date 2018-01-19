package com.roshank.grihaestate.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.roshank.grihaestate.Login_Activity;
import com.roshank.grihaestate.R;
import com.roshank.grihaestate.RegisterActivity;
import com.roshank.grihaestate.Register_ActivityFragment;


public class LoginorCreateAccFragment extends Fragment implements View.OnClickListener{

    Button login, register;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loginorcreateacc_layout, null);

        register = (Button) view.findViewById(R.id.register);
        login = (Button) view.findViewById(R.id.login);

        login.setOnClickListener(this);
        register.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login) {
            startActivity(new Intent(getActivity(), Login_Activity.class));
        } else if (v.getId() ==R.id.register) {
            startActivity(new Intent(getActivity(), RegisterActivity.class));
        }
    }


}

