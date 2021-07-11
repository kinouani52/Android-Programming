package serge.kinouani.worldgallery.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import serge.kinouani.worldgallery.R;
import serge.kinouani.worldgallery.model.CardData;
import serge.kinouani.worldgallery.model.DataModel;

public class CardDataAdapter extends  RecyclerView.Adapter<CardDataAdapter.ViewHolder>{

public class ViewHolder extends RecyclerView.ViewHolder{
    ImageView itemImageView;
    TextView itemTextView;
    public ViewHolder(View itemView){
        super(itemView);
        itemImageView = itemView.
                findViewById(R.id.itemImageView);
        itemTextView = itemView.
                findViewById(R.id.itemTextView);
    }
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
   View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_recycler,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardData cardData =  DataModel.getInstance().cardDataArrayList.get(position);

  holder.itemImageView.setImageResource(cardData.getDrawableId());
  holder.itemTextView.setText(cardData.getTitle());
    }

    @Override
    public int getItemCount() {
        return DataModel.getInstance().cardDataArrayList.size();
    }




}
