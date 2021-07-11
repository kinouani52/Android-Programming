package serge.kinouani.agenda.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import serge.kinouani.agenda.R;
import serge.kinouani.agenda.model.Data_model;
import serge.kinouani.agenda.model.edit_contact;

public class ContactsAdapter extends RecyclerView.Adapter <ContactsAdapter.ViewHolder>{
    private static ClickListener clickListener;

    public void setOnItemClickListener(ClickListener clickListener) {
        ContactsAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }

  public class ViewHolder extends RecyclerView.ViewHolder {
      TextView itemNameTextView,itemPhoneTextView;
      public ViewHolder(View itemView){
          super(itemView);
          itemNameTextView= itemView.findViewById(R.id.itemNameTextView);
          itemPhoneTextView= itemView.findViewById(R.id.itemPhoneTextView);

          itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  clickListener.onItemClick(getAdapterPosition(), view);
              }
          });
          itemView.setOnLongClickListener(new View.OnLongClickListener(){

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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(
                R.layout.item_contact_recycleview,
                parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return Data_model.getInstance().edit_contactArrayList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        edit_contact contact = Data_model.getInstance().edit_contactArrayList.get(position);
      holder.itemNameTextView.setText(contact.getContact_name());
      holder.itemPhoneTextView.setText(contact.getContact_phone());
    }
}
