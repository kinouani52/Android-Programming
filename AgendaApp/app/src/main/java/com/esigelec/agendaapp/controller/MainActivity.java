package com.esigelec.agendaapp.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.esigelec.agendaapp.R;
import com.esigelec.agendaapp.model.DataModel;

public class MainActivity extends AppCompatActivity {
    RecyclerView contactsRecyclerView;
    ContactsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataModel.getInstance().loadToFile(MainActivity.this);

        contactsRecyclerView = findViewById(R.id.contactsRecyclerView);
        RecyclerView.ItemDecoration decoration = new
                DividerItemDecoration(MainActivity.this,
                DividerItemDecoration.VERTICAL);
        adapter = new ContactsAdapter();
        contactsRecyclerView.setAdapter(adapter);
        contactsRecyclerView.setLayoutManager(
                new LinearLayoutManager(MainActivity.this)
        );

        adapter.setOnItemClickListener(new ContactsAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(MainActivity.this,
                        DetailActivity.class);
                intent.putExtra("index",position);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(int position, View v) {
                DataModel.getInstance().contactDetailsArrayList.
                        remove(position);
                adapter.notifyItemRemoved(position);
                DataModel.getInstance().saveToFile(
                        MainActivity.this);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    public void onAddButtonClicked(View v){
        Intent intent = new Intent(MainActivity.this,
                DetailActivity.class);
        intent.putExtra("index",-1);
        startActivity(intent);
    }
}