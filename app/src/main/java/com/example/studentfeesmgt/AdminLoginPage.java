package com.example.studentfeesmgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLoginPage extends AppCompatActivity    {
    private Button Button2;
    EditText Username, Password;
    Button btnLogin;
    String correct_Username = "admin";
    String correct_Password = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_page);

        Username= findViewById(R.id.Username2);
        Password= findViewById(R.id.Password2);
        btnLogin= findViewById(R.id.Button2);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //validate inputs


                if(TextUtils.isEmpty(Username.getText().toString())

                        || TextUtils.isEmpty(Password.getText().toString())){
                    Toast.makeText(AdminLoginPage.this,
                            "Fill a field",Toast.LENGTH_LONG ).show();


                }else if (Username.getText().toString().equals(correct_Username)){
                    //check password

                    if(Password.getText().toString().equals(correct_Password)){
                        Toast.makeText(AdminLoginPage.this,
                                "Login Success",Toast.LENGTH_LONG ).show();
                        openAdminSection();
                    }else{
                        Toast.makeText(AdminLoginPage.this,
                                "Invalid Username/Password",Toast.LENGTH_LONG ).show();
                    }
                }else{Toast.makeText(AdminLoginPage.this,
                        "Invalid Username/Password",Toast.LENGTH_LONG ).show();

                }

            }
        });




    }


    private void openAdminSection() {
        Intent intent = new Intent(this,AdminSection.class);
        startActivity(intent);
    }
}