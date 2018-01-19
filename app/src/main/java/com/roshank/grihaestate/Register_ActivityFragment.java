package com.roshank.grihaestate;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.roshank.grihaestate.R;


public class Register_ActivityFragment extends Fragment {

    EditText firstname, lastname, email, homephone, mobile, address, username, password, passwordconfirmation;
    Button register;
    Spinner spinnerTitle;
    SharedPreferences preferences;
    DatabaseHelper databaseHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.register_layout,null);

        databaseHelper = new DatabaseHelper(getActivity());

        preferences = getActivity().getSharedPreferences("Userinfo", 0);

        spinnerTitle = (Spinner) view.findViewById(R.id.spinnerTitle);
        firstname = (EditText) view.findViewById(R.id.firstname);
        lastname = (EditText) view.findViewById(R.id.lastname);
        email = (EditText) view.findViewById(R.id.email);
        homephone = (EditText) view.findViewById(R.id.homephone);
        mobile = (EditText) view.findViewById(R.id.mobile);
        address = (EditText) view.findViewById(R.id.address);
        username = (EditText) view.findViewById(R.id.username);
        password = (EditText) view.findViewById(R.id.password);
        passwordconfirmation = (EditText) view.findViewById(R.id.passwordconfirmation);
        register = (Button) view.findViewById(R.id.register);


        view.findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processRegister();
            }
        });

        return view;
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

            Toast.makeText(getActivity(), "User Registered", Toast.LENGTH_SHORT).show();

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
            Toast.makeText(getActivity(), "Password didn't match", Toast.LENGTH_SHORT).show();
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

