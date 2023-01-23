package com.example.studentfeesmgt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity implements View.OnClickListener {
  private CardView StudentLoginPage,  AdminLoginPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        AdminLoginPage = findViewById(R.id.Admin_card);
       StudentLoginPage = findViewById(R.id.Student_card);



        AdminLoginPage.setOnClickListener ((View.OnClickListener) this);
        StudentLoginPage.setOnClickListener ((View.OnClickListener) this);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);




    }


@Override
    public void onClick(View v) {

        Intent i ;
        //use switch case
        switch (v.getId()){



            case R.id.Student_card:i = new Intent(this,StudentLoginPage.class);startActivity(i);
                break;


            case R.id.Admin_card:i = new Intent(this,AdminLoginPage.class);startActivity(i);
                break;

            default:break;
        }

    }
}
