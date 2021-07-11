package serge.kinouani.guessgame.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import serge.kinouani.guessgame.R;
import serge.kinouani.guessgame.model.list_items;

public class game extends AppCompatActivity {
    private RecyclerView RecyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager LayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ArrayList<list_items> itemList = new ArrayList<>();
        itemList.add(new list_items(R.drawable.africanrenaissance,"Paris","Dakar","Guess the location"));
        itemList.add(new list_items(R.drawable.africanrenaissance,"Paris","Dakar", "Guess the location"));
        itemList.add(new list_items(R.drawable.africanrenaissance,"Paris","Dakar", "Guess the location"));
        itemList.add(new list_items(R.drawable.africanrenaissance,"Paris","Dakar", "Guess the location"));


       RecyclerView = findViewById(R.id.RecyclerView);
        RecyclerView.setHasFixedSize(true);
        LayoutManager = new LinearLayoutManager(this);
        Adapter = new listItemsAdapter(itemList);
        RecyclerView.setLayoutManager(LayoutManager);
        RecyclerView.setAdapter(Adapter);
    }
}