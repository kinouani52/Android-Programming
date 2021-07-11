package com.esigelec.gallery.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.esigelec.gallery.R;
import com.esigelec.gallery.model.DataModel;
import com.esigelec.gallery.model.ImageDetails;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    TextView titleTextView;
    ImageView mainImageView;
    TextView indexTextView;
    EditText commentsEditText;
    ImageButton leftImageButton;
    ImageButton rightImageButton;
    ListView imagesListView;

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
        imagesListView = findViewById(R.id.imagesListView);

        updateImageDetails();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                GalleryActivity.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                DataModel.getInstance().getImagesStrings()
        );
        imagesListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        imagesListView.setSelector(android.R.color.darker_gray);
        imagesListView.setAdapter(adapter);
        imagesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long l) {
                DataModel.getInstance().imagesIndex = i;
                updateImageDetails();
            }
        });
    }

    public void onRightButtonClicked(View v){
        saveComment();
        DataModel.getInstance().imagesIndex++;
        updateImageDetails();
    }
    public void onLeftButtonClicked(View v){
        saveComment();
        DataModel.getInstance().imagesIndex--;
        updateImageDetails();
    }
    void saveComment(){
        String aux = commentsEditText.getText().toString();
        ImageDetails details = DataModel.getInstance().images.get(
                DataModel.getInstance().imagesIndex);
        details.setComments(aux);
    }
    void updateImageDetails(){

        if(DataModel.getInstance().imagesIndex <= 0){
            DataModel.getInstance().imagesIndex = 0;
            leftImageButton.setVisibility(View.INVISIBLE);
        }else{
            leftImageButton.setVisibility(View.VISIBLE);
        }
        if(DataModel.getInstance().imagesIndex >=
                (DataModel.getInstance().images.size()-1)){
            DataModel.getInstance().imagesIndex =
                    (DataModel.getInstance().images.size()-1);
            rightImageButton.setVisibility(View.INVISIBLE);
        }else{
            rightImageButton.setVisibility(View.VISIBLE);
        }
        ImageDetails details = DataModel.getInstance().images.get(
                DataModel.getInstance().imagesIndex);
        titleTextView.setText(details.getTitle());
        mainImageView.setImageDrawable(getImageDrawable(
                details.getDrawableName()));
        mainImageView.setContentDescription(details.getTitle());
        commentsEditText.setText(details.getComments());
        indexTextView.setText(""+
                (DataModel.getInstance().imagesIndex+1)+"/"+
                DataModel.getInstance().images.size());
        imagesListView.requestFocusFromTouch();
        imagesListView.setSelection(DataModel.getInstance().imagesIndex);

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