package serge.kinouani.guessgame.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import serge.kinouani.guessgame.R;

public class MainActivity extends AppCompatActivity {
    EditText Name;
    EditText Password;
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=findViewById(R.id.usernameEditText);
        Password=findViewById(R.id.passwordEditText);
        Login=findViewById(R.id.loginButton);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,game.class);
                startActivity(intent);
            }
        });
    }
}