package com.roshank.grihaestate;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by roshank on 07/12/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    EditText firstname, lastname, email, homephone, mobile, address, username, password, passwordconfirmation;
    Button register;
    Spinner spinnerTitle;
    SharedPreferences preferences;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        databaseHelper = new DatabaseHelper(this);

        preferences = getSharedPreferences("Userinfo", 0);

        spinnerTitle = (Spinner) findViewById(R.id.spinnerTitle);
        firstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname);
        email = (EditText) findViewById(R.id.email);
        homephone = (EditText) findViewById(R.id.homephone);
        mobile = (EditText) findViewById(R.id.mobile);
        address = (EditText) findViewById(R.id.address);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        passwordconfirmation = (EditText) findViewById(R.id.passwordconfirmation);
        register = (Button) findViewById(R.id.register);


  findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processRegister();
            }
        });


    }




    public void processRegister() {
        String firstNameValue = firstname.getText().toString();
        String lastNameValue = lastname.getText().toString();
        String emailValue = email.getText().toString();
        String phoneValue = homephone.getText().toString();
        String mobilePhoneValue = mobile.getText().toString();
        String addressValue = address.getText().toString();
        String spinnerTitleValue = spinnerTitle.getSelectedItem().toString();
        String usernameValue = username.getText().toString();
        String passwordValue = password.getText().toString();
        String passwordConfirmationValue = passwordconfirmation.getText().toString();


        if (isEmpty(username) && isEmpty(password) && isValidEmail(email) && isValidPhone(mobile) && passwordMatch()) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("spinnerTitle", spinnerTitleValue);
            editor.putString("firstname", firstNameValue);
            editor.putString("lastname", lastNameValue);
            editor.putString("password", passwordValue);
            editor.putString("passwordconfirmation", passwordConfirmationValue);
            editor.putString("email", emailValue);
            editor.putString("mobile", mobilePhoneValue);
            editor.putString("homephone", phoneValue);
            editor.putString("address", addressValue);
            editor.putString("username", usernameValue);

            editor.apply();


            ContentValues cv = new ContentValues();
            cv.put("username", usernameValue);
            cv.put("password", passwordValue);
            cv.put("email", emailValue);
            cv.put("homephone", phoneValue);
            cv.put("mobile", mobilePhoneValue);
            cv.put("title", spinnerTitleValue);
            cv.put("address", addressValue);
            cv.put("firstname", firstNameValue);
            cv.put("lastname", lastNameValue);

            databaseHelper.InsertRecord(cv);

            Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show();
finish();
        }

    }



    //validation of user input
    public boolean isEmpty(EditText password) {

        if (password.getText().length() > 0) {
            return true;
        } else {
            password.setError("Enter Value");
            return false;
        }
    }

    public boolean passwordMatch() {
        if (password.getText().toString().equals(passwordconfirmation.getText().toString())) {
            return true;
        } else {
            Toast.makeText(this, "Password didn't match", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    public boolean isValidPhone(EditText phone) {

        if (phone.getText().length() == 10 && phone.getText().toString().startsWith("98")) {
            return true;
        } else {
            phone.setError("Must start with 98");
            return false;
        }
    }
    public boolean isValidEmail(EditText email) {

        if (Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            return true;
        } else {
            email.setError("Enter valid email address");
            return false;
        }
    }


}
