package com.neatroots.myhealthcareapp1;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    EditText edUserName,edEmail,edPassword,edConfirmPassword;
    Button btn;

    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edUserName=findViewById(R.id.editTextTextRegisterUsername);
        edEmail=findViewById(R.id.editTextTextRegisterEmail);
        edPassword=findViewById(R.id.editTextTextRegisterPassword);
        edConfirmPassword=findViewById(R.id.editTextTextRegisterConfirmPassword);
        btn=findViewById(R.id.buttonRegister);
        tv=findViewById(R.id.textRegisterLogin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=edUserName.getText().toString();
                String email=edEmail.getText().toString().trim();
                String password=edPassword.getText().toString();
                String conpassword=edConfirmPassword.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                if(userName.isEmpty() ||
                        email.isEmpty() || password.isEmpty()
                        || conpassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter all details", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(password.compareTo(conpassword)==0){
                        if(isValid(password))
                        {
                            db.register(userName,email,password);
                            Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent (RegisterActivity.this,LoginActivity.class));
                        }
                        else    {
                            Toast.makeText(getApplicationContext(), "not a valid password", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        Toast.makeText(getApplicationContext(), "password and confirm password are not matched", Toast.LENGTH_SHORT).show();
                    }
                }
//                if(isValidEmail(email)){
//                    Toast.makeText(RegisterActivity.this,"Email is valid",
//                            Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(RegisterActivity.this," invalid email address",Toast.LENGTH_SHORT).show();
//                }

            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });




    }

    public static boolean isValid(String passwordhere) {
        int f1=0,f2=0,f3=0;

        if(passwordhere.length() < 8)   {
            return false;
        }
        else {
            for(int p=0;p<passwordhere.length();p++)    {
                if(Character.isLetter(passwordhere.charAt(p)))  {
                    f1=1;
                }
            }
            for(int r=0;r<passwordhere.length();r++)    {
                if(Character.isDigit(passwordhere.charAt(r)))   {
                    f2=1;
                }
            }
            for(int s=0;s<passwordhere.length();s++)    {
                char c=passwordhere.charAt(s);
                if(c>=33&&c<=46||c==64) {
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1 )
                return true;
            return false;
        }
    }


}