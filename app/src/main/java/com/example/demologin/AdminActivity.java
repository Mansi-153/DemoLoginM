package com.example.demologin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
    DatabaseHelper dbms;
    EditText e1, e2, e3 ,e4;
    public void btn(View view){
        boolean isInserted = dbms.insertData(e1.getText().toString(), e2.getText().toString(), e3.getText().toString(), e4.getText().toString());
        if(isInserted==true) {
            Toast.makeText(this, "Data has been successfully entered", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Try Again", Toast.LENGTH_LONG).show();
        }
    }
    public void btn1(View view){
        Cursor res = dbms.viewAll(e1.getText().toString());
        if(res.getCount()==0){
            showMessage("Error", "No argument");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append("ID : "+res.getString(0)+"\n");
            buffer.append("Name : "+res.getString(1)+"\n");
            buffer.append("Surname: "+res.getString(2)+"\n");
            buffer.append("Marks: "+res.getString(3)+"\n");
            showMessage("data", buffer.toString());
        }

    }

    public void btn2(View view){
        dbms.updateAll(e1.getText().toString(), e2.getText().toString(), e3.getText().toString(), e4.getText().toString());

    }
    public void btn3(View view){
        dbms.deleteAll(e1.getText().toString());
    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle(title);
        adb.setMessage(Message);
        adb.setCancelable(true);
        adb.show();
    }

    public void img(View view){
        showMessage("INFORMATION", "To view or delete the details of any employee just enter the ID\nTo insert data of an employee enter in all 4 columns");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        dbms = new DatabaseHelper(this);
        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        e3 = findViewById(R.id.editText3);
        e4 = findViewById(R.id.editText4);


    }
}
