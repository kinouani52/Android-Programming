package com.esigelec.gallery.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.esigelec.gallery.R;
import com.esigelec.gallery.model.DataModel;
import com.esigelec.gallery.model.UserDetails;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
    }
    public void onLoginButtonClicked(View v){
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if(username.equalsIgnoreCase(DataModel.getInstance().userDetails.getUsername()) &&
        password.equals(DataModel.getInstance().userDetails.getPassword())){
            usernameEditText.setText("");
            passwordEditText.setText("");

            Intent intent = new Intent(MainActivity.this,
                    GalleryActivity.class);
            startActivity(intent);
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    MainActivity.this
            );
            builder.setTitle(R.string.error_title);
            builder.setMessage(R.string.error_msg);
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface,
                                    int i) {
                    usernameEditText.setText("");
                    passwordEditText.setText("");
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}