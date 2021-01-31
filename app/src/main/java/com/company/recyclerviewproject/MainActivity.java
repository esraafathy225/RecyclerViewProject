package com.company.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Item> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items=new ArrayList<>();
        items.add(new Item("Item 1","This is item1's descripion"));
        items.add(new Item("Item 2","This is item2's descripion"));
        items.add(new Item("Item 3","This is item3's descripion"));
        items.add(new Item("Item 4","This is item4's descripion"));
        items.add(new Item("Item 5","This is item5's descripion"));


        recyclerView=findViewById(R.id.recycler);

        ItemAdapter itemAdapter=new ItemAdapter(this,items);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        recyclerView.setAdapter(itemAdapter);

    }
}