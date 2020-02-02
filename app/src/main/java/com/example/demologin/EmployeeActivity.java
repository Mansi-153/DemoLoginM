package com.example.demologin;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.demologin.Adapter.RecyclerViewAdapter;
import com.example.demologin.Adapter.example_item;

import java.util.ArrayList;

public class EmployeeActivity extends AppCompatActivity {
    private RecyclerView mrecyclerview;
    private RecyclerViewAdapter mrecycleadapter;
    private RecyclerView.LayoutManager layoutManager;
    DatabaseHelper dbms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        ActionBar actionBar = getSupportActionBar();
        dbms = new DatabaseHelper(this);
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        ArrayList<example_item> exampleList=new ArrayList<>();
        Cursor res = dbms.viewAll1();
        if(res.getCount()==0){
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append("ID : "+res.getString(0)+"\n");
            buffer.append("Name : "+res.getString(1)+"\n");
            buffer.append("Surname: "+res.getString(2)+"\n");
            buffer.append("Marks: "+res.getString(3)+"\n");
            exampleList.add(new example_item(R.mipmap.ic_logo_foreground,buffer.toString()));
            int x = buffer.length();
            buffer.delete(0,x-1);
        }

        mrecyclerview=findViewById(R.id.recycler_view);
        mrecyclerview.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        mrecycleadapter=new RecyclerViewAdapter(exampleList);
        mrecyclerview.setLayoutManager(layoutManager);
        mrecyclerview.setAdapter(mrecycleadapter);

    }
}
