package com.example.studentfeesmgt;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class AdminSection extends AppCompatActivity {
    EditText name, grade, fee_amount, amount_paid ,outstanding_fees ;
    Button insert, update, delete, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_section);
        name = findViewById(R.id.name);
        grade = findViewById(R.id.grade);
       fee_amount = findViewById(R.id.fee_amount);
     amount_paid = findViewById(R.id.amount_paid);
     outstanding_fees = findViewById(R.id.outstanding_fees);

        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new DBHelper(this);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);



        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String gradeTXT = grade.getText().toString();
                String fee_amountTXT = fee_amount.getText().toString();
                String amount_paidTXT = amount_paid.getText().toString();
                String outstanding_feesTXT = outstanding_fees.getText().toString();

   Boolean checkinsertdata = DB.insertuserdata(nameTXT, gradeTXT, fee_amountTXT, amount_paidTXT,outstanding_feesTXT);
                if(checkinsertdata==true)
                    Toast.makeText(AdminSection.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminSection.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String gradeTXT = grade.getText().toString();
                String fee_amountTXT = fee_amount.getText().toString();
                String amount_paidTXT = amount_paid.getText().toString();
                String outstanding_feesTXT = outstanding_fees.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(nameTXT,gradeTXT, fee_amountTXT, amount_paidTXT,outstanding_feesTXT);
                if(checkupdatedata==true)
                    Toast.makeText(AdminSection.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminSection.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkudeletedata = DB.deletedata(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(AdminSection.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminSection.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(AdminSection.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("name:"+res.getString(0)+"\n");
                    buffer.append("grade :"+res.getString(1)+"\n");
                    buffer.append("fee_amount :"+res.getString(2)+"\n");
                    buffer.append("amount_paid :"+res.getString(3)+"\n");
                    buffer.append("outstanding_fees:"+res.getString(4)+"\n"+"\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(AdminSection.this);
                builder.setCancelable(true);
                builder.setTitle("Student Records");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
    }}