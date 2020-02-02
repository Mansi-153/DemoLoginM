package com.example.demologin;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class RecActivity extends AppCompatActivity {
    private ProgrammingAdapter adapter;
    private List<ExampleItem> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec);
        RecyclerView programmingList = (RecyclerView)findViewById(R.id.programmingList);
        programmingList.setLayoutManager(new LinearLayoutManager(this));
        data = new ArrayList<>();
        data.add(new ExampleItem(R.mipmap.ic_home_foreground, "Home Board","This is a piece of wooden block that's size is 15 x 55 inches with the word HOME.This is a home decor product selled by the famous GP Company.It costs between 500 to 6oo.This piece would sure add glory to your house"));
       data.add(new ExampleItem(R.mipmap.ic_chair_foreground, "Wooden Chair", "This is wooden chair that contains a cushion alongwith it that's size is 15 x 55 inches with full comfort.This is a home decor product selled by the famous GP Company.It costs between 500 to 6oo.This piece would sure add glory to your house"));
       data.add(new ExampleItem(R.mipmap.ic_produc_foreground, "Welcome Board", "This is a piece of wooden block that's size is 15 x 55 inches with the word WELCOME.This is a home decor product selled by the famous GP Company.It costs between 500 to 6oo.This piece would sure add glory to your house"));
       data.add(new ExampleItem(R.mipmap.ic_stick_foreground, "Sticky Notes", "This is a block that's size is 150 x 155 inches it is used to hold the sticky notes.This is a home decor product selled by the famous GP Company.It costs between 500 to 6oo.This piece would sure add glory to your house"));
       data.add(new ExampleItem(R.mipmap.ic_plant_foreground, "Plant", "This is a piece of artificial plant that's size is 15 x 55 inches with the essence of flowers.This is a home decor product selled by the famous GP Company.It costs between 500 to 6oo.This piece would sure add glory to your house"));
       data.add(new ExampleItem(R.mipmap.ic_plastic_foreground, "Plastic Chairs", "These are the set of plastic chairs. It can be proved to very longlasting and useful to accomodate higher number of people.This is a home decor product selled by the famous GP Company.It costs between 500 to 6oo.This piece would sure add glory to your house"));
       data.add(new ExampleItem(R.mipmap.ic_flat_foreground, "Brushing Tools", "This is the set of brushing tools that can be used by self to do bits of work at home as well as to hand it over to professionals for painting your home.This is a home decor product selled by the famous GP Company.It costs between 500 to 6oo.This piece would sure add glory to your house"));
       data.add(new ExampleItem(R.mipmap.ic_stick, "Eight", "This is a piece of wooden block that's size is 15 x 55 inches with the word HOME.This is a home decor product selled by the famous GP Company.It costs between 500 to 6oo.This piece would sure add glory to your house"));
       data.add(new ExampleItem(R.mipmap.ic_produc_round, "Nine", "This is a piece of wooden block that's size is 15 x 55 inches with the word HOME.This is a home decor product selled by the famous GP Company.It costs between 500 to 6oo.This piece would sure add glory to your house"));
        adapter = new ProgrammingAdapter(data);
        programmingList.setAdapter(adapter);
    }
    public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {

        private int mItemOffset;

        public ItemOffsetDecoration(int itemOffset) {
            mItemOffset = itemOffset;
        }

        public ItemOffsetDecoration(@NonNull Context context, @DimenRes int itemOffsetId) {
            this(context.getResources().getDimensionPixelSize(itemOffsetId));
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.example_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}
