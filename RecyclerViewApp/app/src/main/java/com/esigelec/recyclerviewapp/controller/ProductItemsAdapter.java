package com.esigelec.recyclerviewapp.controller;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esigelec.recyclerviewapp.R;
import com.esigelec.recyclerviewapp.model.DataModel;
import com.esigelec.recyclerviewapp.model.ProductItem;

public class ProductItemsAdapter extends
        RecyclerView.Adapter<ProductItemsAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameItemTextView;
        CheckBox needBuyItemcheckBox;
        public ViewHolder(View itemView){
            super(itemView);
            nameItemTextView = itemView.
                    findViewById(R.id.nameItemTextView);
            needBuyItemcheckBox = itemView.
                    findViewById(R.id.needBuyItemcheckBox);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(
                R.layout.recycle_item_content,
                parent,false
        );
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductItem productItem = DataModel.getInstance().
                productItems.get(position);
        holder.nameItemTextView.setText(productItem.getName());
        holder.needBuyItemcheckBox.setChecked(productItem.getNeedToBuy());
        Log.v("productItems","nameItemTextView("+position+"):"
                + productItem.getName());
    }

    @Override
    public int getItemCount() {
        Log.v("productItems","size:"
                + DataModel.getInstance().productItems.size());
        return DataModel.getInstance().productItems.size();
    }


}
