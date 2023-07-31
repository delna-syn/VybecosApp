package com.example.vybecosapp.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vybecosapp.R;
import com.example.vybecosapp.Rest.PrefManager;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    TextView txtCreateAccount , txtCredentialsError;
    Button Login;
    String uname, pword;
    PrefManager prefManager;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username_edtxt);
        password = (EditText) findViewById(R.id.password_edtxt);
        txtCredentialsError = (TextView) findViewById(R.id.txtCredentialsError);
        txtCreateAccount = (TextView) findViewById(R.id.txtCreateAccount);
        Login = (Button) findViewById(R.id.btnLogin);
        prefManager = new PrefManager(getApplicationContext());
        progressDialog = new ProgressDialog(LoginActivity.this);
        // Setting Message
        progressDialog.setMessage("Please Wait...Loading...");
        // Cannot Cancel Progress Dialog
        progressDialog.setCancelable(false);
        txtCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RegistrationActivity.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                // validate the fields and call login method to implement the api
                if (validate(username) && validate(password)) {
                    if (password.getText().toString().length() < 8) {
                        password.setError(getString(R.string.password_validation));
                    } else {
                        progressDialog.show();
                        uname = username.getText().toString();
                        pword = password.getText().toString();
                        Log.d("TAG", "onClick: "+ prefManager.getuname()+" , "+ prefManager.getpword());
                        if (prefManager.getuname().equals(uname) && prefManager.getpword().equals(pword)){
                            progressDialog.dismiss();
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }else {
                            progressDialog.dismiss();
                            txtCredentialsError.setVisibility(View.VISIBLE);
                            txtCredentialsError.setText(R.string.login_credential_error);
                        }
                    }
                }
            }
        });
    }

    private boolean validate(EditText editText) {
        // check the lenght of the enter data in EditText and give error if its empty
        if (editText.getText().toString().trim().length() > 0) {
            return true; // returns true if field is not empty
        }
        editText.setError("Please Fill This");
        editText.requestFocus();
        return false;
    }
}

