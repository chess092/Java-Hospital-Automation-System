package com.example.studentfeesmgt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentLoginPage extends AppCompatActivity    {
    private Button Button1;
    EditText Username, Password;
    Button btnLogin;
    String correct_Username = "student";
    String correct_Password = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login_page);

        Username= findViewById(R.id.username1);
        Password= findViewById(R.id.Password1);
        btnLogin= findViewById(R.id.Button1);

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
            Toast.makeText(StudentLoginPage.this,
                    "Fill a field",Toast.LENGTH_LONG ).show();


        }else if (Username.getText().toString().equals(correct_Username)){
            //check password

            if(Password.getText().toString().equals(correct_Password)){
                Toast.makeText(StudentLoginPage.this,
                        "Login Success",Toast.LENGTH_LONG ).show();
                openStudentSection();
            }else{
                Toast.makeText(StudentLoginPage.this,
                        "Invalid Username/Password",Toast.LENGTH_LONG ).show();
            }
        }else{Toast.makeText(StudentLoginPage.this,
                "Invalid Username/Password",Toast.LENGTH_LONG ).show();

        }

           }
       });




    }


    private void openStudentSection() {
        Intent intent = new Intent(this,StudentSection.class);
        startActivity(intent);
    }
    }