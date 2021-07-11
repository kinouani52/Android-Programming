package com.esigelec.agendaapp.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;

import com.esigelec.agendaapp.R;
import com.esigelec.agendaapp.model.ContactDetails;
import com.esigelec.agendaapp.model.DataModel;

public class DetailActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText addressEditText;
    EditText phoneEditText;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        nameEditText = findViewById(R.id.nameEditText);
        addressEditText = findViewById(R.id.addressEditText);
        phoneEditText = findViewById(R.id.phoneEditText);


        Bundle extras = getIntent().getExtras();
        index = extras.getInt("index");
        if(index != -1){
            ContactDetails details = DataModel.getInstance().
                    contactDetailsArrayList.get(index);
            nameEditText.setText(details.getName());
            addressEditText.setText(details.getAddress());
            phoneEditText.setText(details.getPhone());
        }
    }

    @Override
    public void onBackPressed() {
        String name = nameEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String phone = phoneEditText.getText().toString();

        if(name.length() > 1 &&
        address.length() > 1 &&
        phone.length() > 1){
            if(index == -1) {
                DataModel.getInstance().contactDetailsArrayList
                        .add(new ContactDetails(name, address, phone));
            }else{
                ContactDetails details = DataModel.getInstance().
                        contactDetailsArrayList.get(index);
                details.setName(name);
                details.setAddress(address);
                details.setPhone(phone);
            }
            DataModel.getInstance().saveToFile(
                    DetailActivity.this);
            finish();
        }else{
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(
                    DetailActivity.this);
            alertBuilder.setTitle("Attention");
            alertBuilder.setMessage("Some of the fields are incorrect. " +
                    "Do you really want to exit");
            alertBuilder.setNegativeButton(android.R.string.cancel,
                    null);
            alertBuilder.setPositiveButton(android.R.string.ok,
                    new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            AlertDialog dialog = alertBuilder.create();
            dialog.show();
        }

    }
}