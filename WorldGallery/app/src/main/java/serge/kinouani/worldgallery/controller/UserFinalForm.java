package serge.kinouani.worldgallery.controller;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import serge.kinouani.worldgallery.R;
import serge.kinouani.worldgallery.model.UserData;

public class UserFinalForm extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference rootReference;
    EditText userCity;
    EditText userWish;
    Button SaveForm;
     Button userLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_final_form);
        userCity = findViewById(R.id.userCityEditText);
        userWish = findViewById(R.id.userPreferenceEditText);
        SaveForm = findViewById(R.id.saveButton);
        userLogout = findViewById(R.id.SignOutbutton);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        rootReference = firebaseDatabase.getReference();



        userLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Intent intent = new Intent(UserFinalForm.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void onSaveButtonClicked(View v){
        String city = userCity.getText().toString();
        String wish = userWish.getText().toString();
        if (TextUtils.isEmpty(city)) {
            Toast.makeText(getApplicationContext(), "Enter your city of residence", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(wish)) {
            Toast.makeText(getApplicationContext(), "Enter your prefred statues", Toast.LENGTH_SHORT).show();
            return;
        }

        DatabaseReference databaseReference =
                firebaseDatabase.getReference("questionnaire");
        databaseReference.setValue("answers");
        rootReference.child("User Answers").setValue(  new UserData(city,wish));

        Intent intent = new Intent(UserFinalForm.this, Gallery.class);
        startActivity(intent);
    }
}