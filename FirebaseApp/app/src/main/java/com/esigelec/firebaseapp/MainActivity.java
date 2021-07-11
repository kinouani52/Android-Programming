package com.esigelec.firebaseapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView msgTextView;
    ListView mainListView;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgTextView = findViewById(R.id.msgTextView);
        mainListView = findViewById(R.id.mainListView);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        rootReference = firebaseDatabase.getReference();
        ValueEventListener itensEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                itens.clear();
                for(DataSnapshot d:snapshot.getChildren()){
                    itens.add((String) d.getValue());
                    Log.d("SNAPSHOT",d.getKey() +":"+d.getValue());
                }
                ArrayAdapter<String>arrayAdapter = new ArrayAdapter<>(
                        MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,
                        itens
                );
                mainListView.setAdapter(arrayAdapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        rootReference.child("itens").
                addValueEventListener(itensEventListener);

        ChildEventListener itensChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.e("SNAPSHOT",
                        "onChildAdded("+snapshot.getKey()+"):"
                                +snapshot.getValue());

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.e("SNAPSHOT",
                        "onChildChanged("+snapshot.getKey()+"):"
                                +snapshot.getValue());
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                Log.e("SNAPSHOT",
                        "onChildRemoved("+snapshot.getKey()+"):"
                                +snapshot.getValue());
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.e("SNAPSHOT",
                        "onChildMoved("+snapshot.getKey()+"):"
                                +snapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        rootReference.child("itens").
                addChildEventListener(itensChildEventListener);
    }
    FirebaseDatabase firebaseDatabase;
    DatabaseReference rootReference;
    ArrayList<String> itens = new ArrayList<>();

    void fireabaseDatabaseTesting(){
        DatabaseReference databaseReference =
                firebaseDatabase.getReference("message");
        databaseReference.setValue("Hello World");

        rootReference.child("String").setValue("one string");
        rootReference.child("MyBoolean").setValue(true);
        rootReference.child("int").setValue(4);
        rootReference.child("double").setValue(3.5);

        rootReference.child("Custom User").setValue(
                new UserData("mark",
                        "mjoselli@fasf.com",
                        "20201218"));

        itens.add("Banana");
        itens.add("Apple");
        itens.add("pineapple");

        rootReference.child("itens").setValue(itens);

        Map<String,String> myMap = new HashMap<>();
        myMap.put("key","mykey");
        myMap.put("name","Mark Joselli");
        rootReference.child("Custom User").
                child("MyMap").setValue(myMap);

        rootReference.child("myNumbers").push().setValue("1");
        rootReference.child("myNumbers").push().setValue("2");


        rootReference.child("String").setValue("string");
        rootReference.child("MyBoolean").setValue(false);
        rootReference.child("int").setValue(40);
        rootReference.child("double").setValue(5.5);

        rootReference.child("myNumbers").setValue(null);

    }

    public void onAddButtonClicked(View v){
        itens.add("test");
        rootReference.child("itens").setValue(itens);
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser != null){
            msgTextView.setText("User Logged on Start:"+
                    firebaseUser.getUid());
        }
        //fireabaseDatabaseTesting();
    }

    public void onCreateUserButtonClicked(View v){
        createUser("mark.joselli@gmail.com","123456");
    }
    public void onLogInButtonClicked(View v){
        logInUser("mark.joselli@gmail.com","123456");
    }
    public void onLogOutButtonClicked(View v){
        firebaseAuth.signOut();
        msgTextView.setText("No User");
    }

    void logInUser(String email, String password){
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(MainActivity.this,
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    firebaseUser = firebaseAuth.getCurrentUser();

                                    msgTextView.setText("User Logged:"+
                                            firebaseUser.getUid());
                                }else{
                                    msgTextView.setText("User Not Logged");
                                    Log.e("FIREBASEAUTH",
                                            "LogError:"
                                                    +task.getException().toString());
                                }
                            }
                        });
    }

    void createUser(String email,String password){
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(MainActivity.this,
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    firebaseUser = firebaseAuth.getCurrentUser();

                                    msgTextView.setText("User Created:"+
                                            firebaseUser.getUid());
                                }else{
                                    msgTextView.setText("User  Not Created");
                                    Log.e("FIREBASEAUTH",
                                            "CreateError:"
                                                    +task.getException().toString());
                                }
                            }
                        });

    }
}