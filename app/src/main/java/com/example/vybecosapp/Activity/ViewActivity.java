package com.example.vybecosapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vybecosapp.R;
import com.example.vybecosapp.Rest.PrefManager;
import com.google.android.material.button.MaterialButton;

public class ViewActivity extends AppCompatActivity {
    TextView txtPeriod , txtFutureSlection , txtContentBox;
    MaterialButton btnViewProducts;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        txtPeriod = findViewById(R.id.txtPeriod);
        txtFutureSlection = findViewById(R.id.txtFutureSlection);
        txtContentBox = findViewById(R.id.txtContentBox);

        btnViewProducts = findViewById(R.id.btnViewProducts);
        prefManager = new PrefManager(getApplicationContext());
        Log.d("TAG", "onCreate: "+ prefManager.getperiod()+prefManager.getfutureSlection() + prefManager.getcontentBox());

        if (!prefManager.getperiod().equals("")) {
            txtPeriod.setText(prefManager.getperiod());
        }
        if (!prefManager.getfutureSlection().equals("")) {
            txtFutureSlection.setText(prefManager.getfutureSlection());
        }
        if (!prefManager.getcontentBox().equals("")) {
            txtContentBox.setText(prefManager.getcontentBox());
        }
        btnViewProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}