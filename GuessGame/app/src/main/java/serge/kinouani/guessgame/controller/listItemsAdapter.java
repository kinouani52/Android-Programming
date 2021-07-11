package serge.kinouani.guessgame.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import serge.kinouani.guessgame.R;
import serge.kinouani.guessgame.model.list_items;

public class listItemsAdapter extends RecyclerView.Adapter<listItemsAdapter.ViewHolder>{
    private ArrayList<list_items> itemList;
    public class ViewHolder extends RecyclerView.ViewHolder {
     public   Button answer1;
      public  Button answer2;
      public   TextView question;
     public   ImageView statusImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            answer1= itemView.findViewById(R.id.answer_button1);
            answer2 = itemView.findViewById(R.id.answer_button2);
            question= itemView.findViewById(R.id.textView);
            statusImage = itemView.findViewById(R.id.imageView);
        }
    }
    public listItemsAdapter(ArrayList<list_items> itemsList) {
        itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(
                R.layout.list_item,
                parent,false
        );
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        list_items currentItem = itemList.get(position);

        holder.statusImage.setImageResource(currentItem.getImageFile());
        holder.answer1.setText(currentItem.getAnswer1());
        holder.answer2.setText(currentItem.getAnswer2());
        holder.question.setText(currentItem.getQuestion());
    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
