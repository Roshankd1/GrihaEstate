package com.roshank.grihaestate.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.roshank.grihaestate.DatabaseHelper;
import com.roshank.grihaestate.HomeActivity;
import com.roshank.grihaestate.R;
import com.roshank.grihaestate.RegisterActivity;
import com.roshank.grihaestate.Register_ActivityFragment;

public class Login_ActivityFragment extends Fragment implements View.OnClickListener {

    EditText username, password;
    Button login;
    TextView forgotpassword;
    DatabaseHelper databaseHelper;
    SharedPreferences preferences;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_layout, null);

        databaseHelper = new DatabaseHelper(getActivity());

        username = (EditText) view.findViewById(R.id.username);
        password = (EditText) view.findViewById(R.id.password);
        preferences = getActivity().getSharedPreferences("Userinfo", 0);
        login = (Button) view.findViewById(R.id.login);
        forgotpassword = (TextView) view.findViewById(R.id.forgotpassword);

        login.setOnClickListener(this);
        forgotpassword.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login) {
            loginProcess();
        } else if (v.getId() == R.id.forgotpassword) {
            forgotpasswordProcess();
        }
    }

    public void loginProcess() {
        String usernameValue = username.getText().toString();
        String passwordValue = password.getText().toString();

        String registeredUsername = preferences.getString("username", "");
        String registeredPassword = preferences.getString("password", "");
        Toast.makeText(getActivity(), "Username:" + usernameValue + "Password:" + passwordValue, Toast.LENGTH_SHORT).show();
        if (databaseHelper.isValidLogin(usernameValue, passwordValue)) {
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(getActivity(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
        }
    }

    public void forgotpasswordProcess() {
        startActivity(new Intent(getActivity(), RegisterActivity.class));

    }

}
