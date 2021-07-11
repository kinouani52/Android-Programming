package com.esigelec.agendaapp.controller;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esigelec.agendaapp.R;
import com.esigelec.agendaapp.model.ContactDetails;
import com.esigelec.agendaapp.model.DataModel;

public class ContactsAdapter
        extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private static ClickListener clickListener;

    public void setOnItemClickListener(ClickListener clickListener) {
        ContactsAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView itemNameTextView;
        TextView itemPhoneTextView;

        public ViewHolder(View itemView){
            super(itemView);

            itemNameTextView = itemView.findViewById(
                    R.id.itemNameTextView);
            itemPhoneTextView = itemView.findViewById(
                    R.id.itemPhoneTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClick(getAdapterPosition(), view);

                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    clickListener.onItemLongClick(getAdapterPosition(), view);
                    return true;
                }
            });
        }



    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                         int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(
                R.layout.item_contact_recycler_view,
                parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return DataModel.getInstance().contactDetailsArrayList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactDetails contact = DataModel.getInstance().
                contactDetailsArrayList.get(position);
        holder.itemNameTextView.setText(contact.getName());
        holder.itemPhoneTextView.setText(contact.getPhone());
    }
}
