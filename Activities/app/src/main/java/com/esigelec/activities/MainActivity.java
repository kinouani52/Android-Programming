package com.esigelec.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    EditText dataEditText;
    ImageView mainImageView;
    Switch visibilitySwitch;

    String images[] = new String[]{"spongebob","patrick"};
    int selectedImage = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataEditText = findViewById(R.id.dataEditText);
        mainImageView = findViewById(R.id.mainImageView);
        visibilitySwitch = findViewById(R.id.visibilitySwitch);
        visibilitySwitch.setChecked(true);
        visibilitySwitch.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton,
                                         boolean b) {
                if(b == true){
                    mainImageView.setVisibility(View.VISIBLE);
                }else{
                    mainImageView.setVisibility(View.INVISIBLE);
                }
            }
        });

        setTitle("First Activity");
    }
    public void sendButtonClicked(View v){
        Intent intent = new Intent(MainActivity.this,
                SecondActivity.class);
        intent.putExtra("data",dataEditText.getText().toString());
        //intent.putExtra("name","Mark");
        startActivity(intent);
    }

    public void changeImageButtonClicked(View v){
        if(selectedImage == 1){
            selectedImage = 0;
        }else{
            selectedImage = 1;
        }
        Drawable drawable = getResources().getDrawable(
                getResources().getIdentifier(images[selectedImage],
                        "drawable",
                        getPackageName())
        );
        mainImageView.setImageDrawable(drawable);

    }

}