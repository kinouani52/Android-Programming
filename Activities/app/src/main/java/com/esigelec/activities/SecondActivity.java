package com.esigelec.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView secondTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        secondTextView = findViewById(R.id.secondTextView);

        setTitle("Second Actitivy");
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String s = extras.getString("data");
            secondTextView.setText(s);
        }
    }

    public void goToThirdButtonPressed(View v){
        Intent intent = new Intent(SecondActivity.this,
                ThirdActivity.class);
        //startActivity(intent);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                String s = data.getStringExtra("data");
                secondTextView.setText(s);
            }
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(
                SecondActivity.this);
        alert.setTitle("Attention!!!");
        alert.setMessage("Do you really want to go back?");
        alert.setPositiveButton(android.R.string.yes,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface,
                                        int i) {
                        finish();
                    }
                });
        alert.setNegativeButton(android.R.string.no,null);
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}