package serge.kinouani.galllery;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {
      ImageView mainImagelabel;
    ImageView mainImageView;
   String[] images = new String[]{"africanrenaissance","eiffel", "liberty","mandela"};
    String[] labels = new String[]{"african","eiffel_tower", "liberty_statue","mandela_nelson"};
    int selectedImage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mainImageView = findViewById(R.id.imageViewgallery);
        mainImagelabel = findViewById(R.id.imageViewLabelling);
    }


    public void previousImageClicked(View v){

        if(selectedImage == 4){
            selectedImage = selectedImage - 1;
        }
        else if(selectedImage==3){
            selectedImage =selectedImage - 1;
        }
        else if(selectedImage==2){
            selectedImage =selectedImage - 1;
        }
        else if(selectedImage==1){
            selectedImage =selectedImage - 1;
        }
        else {
            selectedImage = 0;
        }
        Drawable drawable = getResources().getDrawable(
                getResources().getIdentifier(images[selectedImage],
                        "drawable",
                        getPackageName())
        );
        Drawable drawable2 = getResources().getDrawable(
                getResources().getIdentifier(labels[selectedImage],
                        "drawable",
                        getPackageName())
        );
        mainImageView.setImageDrawable(drawable);
        mainImagelabel.setImageDrawable(drawable2);

    }



    public void nextImageClicked(View v){
        if(selectedImage == 0){
            selectedImage = selectedImage + 1;
        }
        else if(selectedImage==1){
            selectedImage =selectedImage + 1;
        }
        else if(selectedImage==2){
            selectedImage =selectedImage + 1;
        }
        else if(selectedImage==3){
            selectedImage =selectedImage + 1;
        }
        else {
            selectedImage = 4;
        }
        Drawable drawable = getResources().getDrawable(
                getResources().getIdentifier(images[selectedImage ],
                        "drawable",
                        getPackageName())
        );

        Drawable drawable2 = getResources().getDrawable(
                getResources().getIdentifier(labels[selectedImage],
                        "drawable",
                        getPackageName())
        );
        mainImageView.setImageDrawable(drawable);
        mainImagelabel.setImageDrawable(drawable2);


    }


}