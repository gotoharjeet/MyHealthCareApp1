package com.neatroots.myhealthcareapp1;

import android.content.Intent;
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

            if(UserName.isEmpty() || Password.isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        "Pl. fill all details.....", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(),
                        "Login Success", Toast.LENGTH_SHORT).show();
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