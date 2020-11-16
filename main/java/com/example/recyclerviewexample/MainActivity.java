package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RecyclerAdapter mRecyclerAdapter;
  ArrayList<Superstarid> superstarslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         superstarslist = new ArrayList<>();

        superstarslist.add(new Superstarid("CM Punk",R.drawable.cm_punk,7,6.3));
        superstarslist.add(new Superstarid("Undertaker",R.drawable.undertaker,1,6.9));
        superstarslist.add(new Superstarid("The Rock",R.drawable.rock,2,6.3));
        superstarslist.add(new Superstarid("TripleH",R.drawable.triplehhh,3,6.4));
        superstarslist.add(new Superstarid("Randyorton",R.drawable.randyorton,4,6.4));
        superstarslist.add(new Superstarid("Roman",R.drawable.roman,10,6.4));
        superstarslist.add(new Superstarid("StoneGold",R.drawable.stonegold,5,6.0));
        superstarslist.add(new Superstarid("Johncena",R.drawable.johncena,6,6.2));
        superstarslist.add(new Superstarid("Edge",R.drawable.edge,8,6.6));
        superstarslist.add(new Superstarid("Fiend",R.drawable.fiend,9,6.0));

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerAdapter = new RecyclerAdapter(superstarslist);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRecyclerAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        MenuItem item = menu.findItem(R.id.actionSearch);
        SearchView searchView =(SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mRecyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}