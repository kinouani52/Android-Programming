package com.esigelec.gallery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    UserDetails userDetails = new UserDetails("mjoselli",
            "1234");
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
        if(username.equalsIgnoreCase(userDetails.getUsername()) &&
        password.equals(userDetails.getPassword())){
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