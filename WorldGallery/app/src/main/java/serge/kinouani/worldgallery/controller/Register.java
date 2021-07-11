package serge.kinouani.worldgallery.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import serge.kinouani.worldgallery.R;

public class Register extends AppCompatActivity {

    private static final String TAG ="" ;
    EditText email;
    EditText Password;
    Button Send;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.userEmailEditText);
        Password = findViewById(R.id.userPasswordEditText);
        Send = findViewById(R.id.sendButton);





    Send.setOnClickListener(new View.OnClickListener() {
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
            firebaseAuth.createUserWithEmailAndPassword(userEmail,password)
                    .addOnCompleteListener(Register.this,
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Log.d(TAG, "createUserWithEmail:success");
                                        firebaseUser = firebaseAuth.getCurrentUser();

                                        Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(Register.this, serge.kinouani.worldgallery.controller.Gallery.class);
                                        startActivity(intent);
                                    }else{
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(Register.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

        }
    });



    }






    }