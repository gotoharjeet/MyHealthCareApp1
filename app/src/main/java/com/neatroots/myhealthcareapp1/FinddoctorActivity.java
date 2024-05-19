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

public class FinddoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_finddoctor);

        CardView back=findViewById(R.id.cardFDBack);
        CardView familyPhysician=findViewById(R.id.cardFDFamilyPhysician);
        CardView dietician=findViewById(R.id.cardFDDietician);
        CardView dentist=findViewById(R.id.cardFDDentist);
        CardView surgeon=findViewById(R.id.cardFDSurgeon);
        CardView cardiologists=findViewById(R.id.cardFDCardiologists);

        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","");
        Toast.makeText(getApplicationContext(),"Welcome to FindDoctor Module "+username,Toast.LENGTH_SHORT).show();

        back.setOnClickListener(v -> {
            startActivity(new Intent(FinddoctorActivity.this,HomeActivity.class));
        });

        familyPhysician.setOnClickListener(v -> {
            Intent it=new Intent(FinddoctorActivity.this,DoctorDetailsActivity.class);
            it.putExtra("title","Family Physicians");
            startActivity(it);
        });

        dietician.setOnClickListener(v -> {
            Intent it=new Intent(FinddoctorActivity.this,DoctorDetailsActivity.class);
            it.putExtra("title","Dietician");
            startActivity(it);
        });

        dentist.setOnClickListener(v -> {
            Intent it=new Intent(FinddoctorActivity.this,DoctorDetailsActivity.class);
            it.putExtra("title","Dentist");
            startActivity(it);
        });


        cardiologists.setOnClickListener(v -> {
            Intent it=new Intent(FinddoctorActivity.this,DoctorDetailsActivity.class);
            it.putExtra("title","Surgeon");
            startActivity(it);
        });

        surgeon.setOnClickListener(v -> {
            Intent it=new Intent(FinddoctorActivity.this,DoctorDetailsActivity.class);
            it.putExtra("title","Cardiologists");
            startActivity(it);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}