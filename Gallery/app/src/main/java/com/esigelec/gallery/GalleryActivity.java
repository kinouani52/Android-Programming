package com.esigelec.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {
    ArrayList<ImageDetails>images;
    TextView titleTextView;
    ImageView mainImageView;
    TextView indexTextView;
    EditText commentsEditText;
    ImageButton leftImageButton;
    ImageButton rightImageButton;
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        titleTextView = findViewById(R.id.titleTextView);
        mainImageView = findViewById(R.id.mainImageView);
        indexTextView = findViewById(R.id.indexTextView);
        commentsEditText = findViewById(R.id.commentsEditText);
        leftImageButton = findViewById(R.id.leftImageButton);
        rightImageButton = findViewById(R.id.rightImageButton);

        createImageDataset();
        updateImageDetails();
    }

    void createImageDataset(){
        images = new ArrayList<>();
        images.add(new ImageDetails("Sponge Bob",
                "spongebob"));
        images.add(new ImageDetails("Patric Star",
                "patrick"));
        images.add(new ImageDetails("Squidward Tentacles",
                "squid"));
        images.add(new ImageDetails("Mr. Krabs",
                "krabs"));
    }
    public void onRightButtonClicked(View v){
        saveComment();
        index++;
        updateImageDetails();
    }
    public void onLeftButtonClicked(View v){
        saveComment();
        index--;
        updateImageDetails();
    }
    void saveComment(){
        String aux = commentsEditText.getText().toString();
        ImageDetails details = images.get(index);
        details.setComments(aux);
    }
    void updateImageDetails(){

        if(index <= 0){
            index = 0;
            leftImageButton.setVisibility(View.INVISIBLE);
        }else{
            leftImageButton.setVisibility(View.VISIBLE);
        }
        if(index >= (images.size()-1)){
            index = (images.size()-1);
            rightImageButton.setVisibility(View.INVISIBLE);
        }else{
            rightImageButton.setVisibility(View.VISIBLE);
        }
        ImageDetails details = images.get(index);
        titleTextView.setText(details.getTitle());
        mainImageView.setImageDrawable(getImageDrawable(
                details.getDrawableName()));
        commentsEditText.setText(details.getComments());
        indexTextView.setText(""+(index+1)+"/"+images.size());
    }
    Drawable getImageDrawable(String name){
        Drawable drawable = getResources().getDrawable(
                getResources().getIdentifier(name,
                        "drawable",
                        getPackageName())
        );
        return drawable;
    }
}