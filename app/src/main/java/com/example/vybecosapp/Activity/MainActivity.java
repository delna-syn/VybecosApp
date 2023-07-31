package com.example.vybecosapp.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vybecosapp.Adapters.CustomAdapter;
import com.example.vybecosapp.Adapters.KeyChainAdapter;
import com.example.vybecosapp.Model.DataAluminiumFoil;
import com.example.vybecosapp.Model.SavedSarveys;
import com.example.vybecosapp.R;
import com.example.vybecosapp.Rest.PrefManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView listAluminiumFoil , listKeyChain;
    ArrayList<DataAluminiumFoil> dataAluminiumFoils = new ArrayList<DataAluminiumFoil>();
    ArrayList<DataAluminiumFoil> dataKeyChains = new ArrayList<DataAluminiumFoil>();
    CustomAdapter foilAdapter;
    KeyChainAdapter keyChainAdapter;
    PrefManager prefManager;
    int itemID = 0;
//    ArrayList<SavedSarveys> savedSarveys = new ArrayList<SavedSarveys>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefManager = new PrefManager(getApplicationContext());
        listAluminiumFoil = findViewById(R.id.listAluminiumFoil);
        listKeyChain = findViewById(R.id.listKeyChain);
        dataAluminiumFoils.add(new DataAluminiumFoil(1001,"House Wrap Aluminium Foil for Kitchen","Food Packing, Cooking, Baking - 9 Meter Net Guaranteed 11 Microns in Thickness for Keeping Food Warm (Pack of 3)", "240", R.drawable.house_wrap));
        dataAluminiumFoils.add(new DataAluminiumFoil(1002,"Freshmetz Aluminium Foil","1Kg Gross (18 Microns, Pack of 1)", "549", R.drawable.freshmetz));
        dataAluminiumFoils.add(new DataAluminiumFoil(1003,"Freshwrapp Hindalco Aluminium Foil","33 Grams + 17 Grams, 11microns (Pack of 3) | Food Packing, Wrapping, Storing and Serving", "249", R.drawable.freshwrapp));
        dataAluminiumFoils.add(new DataAluminiumFoil(1004,"Superwrap Hindalco Aluminium Foil" ,"(Pack of 4)", "260", R.drawable.super_wrap));

        foilAdapter = new CustomAdapter(dataAluminiumFoils,MainActivity.this, item -> {
            itemID = prefManager.getID();
            //            savedSarveys = getIntent().getParcelableExtra("savedSarveys");
            if (itemID != item.getID()) {
                Intent intent = new Intent(MainActivity.this, ReviewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("ID", item.getID());
                intent.putExtras(bundle);
                startActivity(intent);
            }else {
                ShowAlert();
            }
        });
        listAluminiumFoil.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        listAluminiumFoil.setAdapter(foilAdapter);
        foilAdapter.notifyDataSetChanged();

        dataKeyChains.add(new DataAluminiumFoil(2001,"Tommy Hilfiger","Men Black Textured Key Case", "999", R.drawable.tommy));
        dataKeyChains.add(new DataAluminiumFoil(2002,"EXIM DECOR","Rust Antique Brass Pocket Compass Keychain", "449", R.drawable.eximdecccor));
        dataKeyChains.add(new DataAluminiumFoil(2003,"CONTACTS","Brown Pack Of 2 Genuine Leather Car Remote Key Case", "1224", R.drawable.contactskey));
        dataKeyChains.add(new DataAluminiumFoil(2004,"FEMMIBELLA" ,"Anti-Scratch Rustproof Royal Enfield Key chain", "299", R.drawable.enfield));
        keyChainAdapter = new KeyChainAdapter(dataKeyChains,MainActivity.this, item -> {
            itemID = prefManager.getID();
            if (itemID != item.getID()) {
                Intent intent = new Intent(MainActivity.this, ReviewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("ID", item.getID());
                intent.putExtras(bundle);
                startActivity(intent);
            }else {
                ShowAlert();
            }
        });
        listKeyChain.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        listKeyChain.setAdapter(keyChainAdapter);
        keyChainAdapter.notifyDataSetChanged();

    }
    private void ShowAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("You can submit one Review for each product?");
        builder.setCancelable(true);
        builder.setPositiveButton(R.string.view_review, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent);
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}