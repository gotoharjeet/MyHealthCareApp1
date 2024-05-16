package com.neatroots.myhealthcareapp1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
//import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.neatroots.myhealthcareapp1.Database.*;


public class LoginActivity extends AppCompatActivity {

    EditText edUserName,edPassword;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        edUserName=findViewById(R.id.editTextTextLoginUsername);
        edPassword=findViewById(R.id.editTextTextLoginPassword);
        btn=findViewById(R.id.buttonLogin);
        tv=findViewById(R.id.textRegNewUser);


        btn.setOnClickListener(v -> {

            String UserName=edUserName.getText().toString();
            String Password=edPassword.getText().toString();
            Database db=new Database(getApplicationContext(),"healthcare",null,1);


            if(UserName.isEmpty() || Password.isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        "Pl. fill all details.....", Toast.LENGTH_SHORT).show();
            }
            else {
                    int islogin=db.login(UserName,Password);
                    if(islogin == 1)    {

                        SharedPreferences sharedPreferences =getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("username",UserName);
                        //to save our data with key and value
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                        Toast.makeText(getApplicationContext(),"Login Success", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        startActivity(new Intent(LoginActivity.this, LoginActivity.class));
                        Toast.makeText(getApplicationContext(),"invalid Login", Toast.LENGTH_SHORT).show();
                    }

            }

        });
        tv.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this,RegisterActivity.class)));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}