package com.roshank.grihaestate;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Loginorcreateacc_Activity extends AppCompatActivity implements View.OnClickListener{

    Button login, register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginorcreateacc_layout);

    login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);

        login.setOnClickListener(this);
        register.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login) {
            loginProcess();
        } else if (view.getId() ==R.id.register) {
            registerProcess();
        }
    }

    public void loginProcess () {
        Intent intent = new Intent(this, Login_Activity.class);
        startActivity(intent);

        finish();}


    public void registerProcess () {
        Intent intent = new Intent(this, Register_ActivityFragment.class);
        startActivity(intent);}
}
