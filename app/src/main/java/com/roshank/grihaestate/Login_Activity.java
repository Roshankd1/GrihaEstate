package com.roshank.grihaestate;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    Button login;
    TextView forgotpassword;
    DatabaseHelper databaseHelper;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        databaseHelper = new DatabaseHelper(this);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        preferences = getSharedPreferences("Userinfo", 0);
        login = (Button) findViewById(R.id.login);
        forgotpassword = (TextView) findViewById(R.id.forgotpassword);

        login.setOnClickListener(this);
        forgotpassword.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login) {
            loginProcess();
        } else if (view.getId() == R.id.forgotpassword) {
            forgotpasswordProcess();
        }
    }

    public void loginProcess() {
        String usernameValue = username.getText().toString();
        String passwordValue = password.getText().toString();

        String registeredUsername = preferences.getString("username", "");
        String registeredPassword = preferences.getString("password", "");
        Toast.makeText(this, "Username:" + usernameValue + "Password:" + passwordValue, Toast.LENGTH_SHORT).show();
        if (databaseHelper.isValidLogin(usernameValue, passwordValue)) {
            Intent intent = new Intent(this, LoggedInActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
        }
    }

    public void forgotpasswordProcess() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}




