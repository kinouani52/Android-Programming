package serge.kinouani.worldgallery.controller;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import serge.kinouani.worldgallery.R;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    EditText email;
    EditText Password;
    Button Login;
    Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        email =findViewById(R.id.LoginEmailEditText);
        Password =findViewById(R.id.LoginPasswordEditText);
        Login =findViewById(R.id.loginButton);
        Register = findViewById(R.id.registerButton);






        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, serge.kinouani.worldgallery.controller.Register.class);
                startActivity(intent);
            }
        });





        Login.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                String userEmail =  email.getText().toString();
                String password = Password.getText().toString();
                if (TextUtils.isEmpty(userEmail)) {
                    Toast.makeText(getApplicationContext(), "Enter Email Id", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(userEmail,password)
                        .addOnCompleteListener(MainActivity.this,
                                new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful()){
                                            firebaseUser = firebaseAuth.getCurrentUser();
                                            Intent intent = new Intent(MainActivity.this, serge.kinouani.worldgallery.controller.Gallery.class);
                                            startActivity(intent);

                                            Toast.makeText(MainActivity.this,"Logged in", Toast.LENGTH_LONG).show();
                                        }else{
                                            Toast.makeText(MainActivity.this,"Authentication Failed", Toast.LENGTH_LONG).show();

                                            Log.e("FIREBASEAUTH",
                                                    "LogError:"
                                                            +task.getException().toString());
                                        }
                                    }
                                });






            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser != null){
            Intent intent = new Intent(MainActivity.this, serge.kinouani.worldgallery.controller.Gallery.class);
            startActivity(intent);
        }
    }
}