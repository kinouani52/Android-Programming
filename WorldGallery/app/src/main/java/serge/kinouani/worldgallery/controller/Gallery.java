package serge.kinouani.worldgallery.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import serge.kinouani.worldgallery.R;

public class Gallery extends AppCompatActivity {
    RecyclerView cardRecyclerView;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    Button Logout;
    CardDataAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        cardRecyclerView = findViewById(R.id.cardRecyclerView);
          Logout= findViewById(R.id.LogoutButton);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Gallery.this,3);

        cardRecyclerView.setLayoutManager(gridLayoutManager);
        adapter = new CardDataAdapter();
        cardRecyclerView.setAdapter(adapter);


        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gallery.this, UserFinalForm.class);
                startActivity(intent);
            }
        });

    }
}