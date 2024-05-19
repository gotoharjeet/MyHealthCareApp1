package com.neatroots.myhealthcareapp1;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_home);
        //Show Welcome User
        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","");
        Toast.makeText(getApplicationContext(),"Welcome "+username,Toast.LENGTH_SHORT).show();


        CardView exit=findViewById(R.id.cardExit);
        CardView labTest=findViewById(R.id.cardLabText);
        CardView findDoctor=findViewById(R.id.cardFindDoctor);
//        CardView buyMedicine=findViewById(R.id.cardBuyMedicine);

        exit.setOnClickListener(v -> {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.clear();
            editor.apply();
            Toast.makeText(getApplicationContext(),"Good bye "+username,Toast.LENGTH_SHORT).show();
            startActivity(new Intent(HomeActivity.this,LoginActivity.class));
        });

        labTest.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this,LabtestActivity.class));
        });
        findDoctor.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this,FinddoctorActivity.class));
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}