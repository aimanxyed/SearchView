package com.unita.searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    ListView mylist;
    private ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView= (SearchView) findViewById(R.id.searchView);
        mylist= (ListView) findViewById(R.id.myList);
        list.add("imran khan");
        list.add("aamir khan");
        list.add("ranbir kapoor");
        list.add("shahrukh khan");
        list.add("salman khan");
        list.add("kareena kapoor khan");
        adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        mylist.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

    }
}