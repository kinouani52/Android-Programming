package com.esigelec.recyclerviewapp.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.esigelec.recyclerviewapp.R;
import com.esigelec.recyclerviewapp.model.DataModel;
import com.esigelec.recyclerviewapp.model.ProductItem;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    RecyclerView mainRecycleView;
    ProductItemsAdapter productItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataModel.getInstance().loadFromFile(MainActivity.this);

        mainRecycleView = findViewById(R.id.mainRecycleView);


        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        mainRecycleView.addItemDecoration(itemDecoration);
        productItemsAdapter = new ProductItemsAdapter();
        mainRecycleView.setAdapter(productItemsAdapter);
        mainRecycleView.setLayoutManager(new
                LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_add_item){
            DataModel.getInstance().productItems.add(
                    0,new ProductItem("Added",
                            false));
            DataModel.getInstance().saveFromFile(
                    MainActivity.this);
            //productItemsAdapter.notifyDataSetChanged();
            productItemsAdapter.notifyItemInserted(0);
            View contextView = findViewById(android.R.id.content);
            Snackbar.make(contextView,"Item Added",
                    Snackbar.LENGTH_LONG)
                    .setAction("Undo", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            DataModel.getInstance().
                                    productItems.remove(0);
                            DataModel.getInstance().saveFromFile(
                                    MainActivity.this);
                            productItemsAdapter.notifyItemRemoved(0);

                        }
                    })
                    .show();
        }
        return true;
    }
}