package com.example.vybecosapp.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vybecosapp.Model.DataAluminiumFoil;
import com.example.vybecosapp.Model.SavedSarveys;
import com.example.vybecosapp.R;
import com.example.vybecosapp.Rest.PrefManager;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {
    Button btnSave;
    EditText period , futureSlection , contentBox;
    PrefManager prefManager;
//    ArrayList<SavedSarveys> savedSarveys = new ArrayList<SavedSarveys>();
    int ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        btnSave = findViewById(R.id.btnSave);
        period = findViewById(R.id.subjectBox);
        futureSlection = findViewById(R.id.subjectBox1);
        contentBox = findViewById(R.id.contentBox);
        prefManager = new PrefManager(getApplicationContext());
        Bundle bundle = getIntent().getExtras();
       ID = bundle.getInt("ID");
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate(period) && validate(futureSlection) && validate(contentBox)) {
//                    savedSarveys.add(new SavedSarveys(ID,period.getText().toString() , futureSlection.getText().toString() , contentBox.getText().toString()));
                    prefManager.setReviewDetails(ID,period.getText().toString() , futureSlection.getText().toString() , contentBox.getText().toString());
                    showConfirmationDialog();

                }
            }
        });
    }
    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.confirmation_submition_review);
        builder.setCancelable(true);
        builder.setNegativeButton(R.string.cancel,new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(ReviewActivity.this, MainActivity.class);//Bug 1258 by anupama
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                Bundle bundle = new Bundle();
//                bundle.putParcelable("savedSarveys", (Parcelable) savedSarveys);
//                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
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
