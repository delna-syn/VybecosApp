package com.example.vybecosapp.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vybecosapp.R;
import com.example.vybecosapp.Rest.PrefManager;

import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {

    EditText password , name_edtxt , phoneNumber_edtxt , email_edtxt;
    TextView txtAlreadyHavingAccount;
    Button btnRegister;

    String uname, pword;
    PrefManager prefManager;
    static AlertDialog.Builder builder;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        password = (EditText) findViewById(R.id.password_edtxt);
        name_edtxt = (EditText) findViewById(R.id.name_edtxt);
        phoneNumber_edtxt = (EditText) findViewById(R.id.phoneNumber_edtxt);
        email_edtxt = (EditText) findViewById(R.id.email_edtxt);

        txtAlreadyHavingAccount = (TextView) findViewById(R.id.txtAlreadyHavingAccount);
        btnRegister = (Button) findViewById(R.id.registration_btn);

        prefManager = new PrefManager(getApplicationContext());
        builder = new AlertDialog.Builder(this);
        progressDialog = new ProgressDialog(RegistrationActivity.this);
        // Setting Message
        progressDialog.setMessage("Please Wait...Loading...");
        // Cannot Cancel Progress Dialog
        progressDialog.setCancelable(false);
        // Obtain the FirebaseAnalytics instance.

        txtAlreadyHavingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                // validate the fields and call login method to implement the api
                if (validate(name_edtxt) && validate(phoneNumber_edtxt) && validate(email_edtxt) && validate(password)) {
                    if (isValidMail(email_edtxt.getText().toString())) {
                        if (isValidMobile(phoneNumber_edtxt.getText().toString())) {
                            if (password.getText().toString().length() >= 8) {
                                progressDialog.show();
                                // The mobile number should serve as the username for the customer
                                uname = phoneNumber_edtxt.getText().toString();
                                pword = password.getText().toString();
                                prefManager.setRegistrationDetails(uname, pword, name_edtxt.getText().toString(), email_edtxt.getText().toString());
                                progressDialog.dismiss();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }else {
                                password.setError(getString(R.string.password_validation));
                            }
                        }else {
                            phoneNumber_edtxt.setError(getString(R.string.phone_number_correction));
                        }
                    }else {
                        email_edtxt.setError(getString(R.string.email_correction));
                    }
                }
            }
        });
    }

    private boolean isValidMail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private boolean isValidMobile(String phone) {
        if(!Pattern.matches("[a-zA-Z]+", phone)) {
            return phone.length() == 10;
        }
        return false;
    }
    private boolean validate(EditText editText) {
        // check the lenght of the enter data in EditText and give error if its empty
        if (editText.getText().toString().trim().length() > 0) {
            return true;
        }
        editText.setError(getString(R.string.fill_this));
        editText.requestFocus();
        return false;
    }
}

