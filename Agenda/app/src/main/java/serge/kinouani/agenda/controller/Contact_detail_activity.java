package serge.kinouani.agenda.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import serge.kinouani.agenda.R;
import serge.kinouani.agenda.model.Data_model;
import serge.kinouani.agenda.model.edit_contact;

public class Contact_detail_activity extends AppCompatActivity {
Button saveButton;
EditText nameEditText,addressEditText,phoneEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail_activity);
        saveButton = findViewById(R.id.saveButton);
        nameEditText = findViewById(R.id.nameEditText);
        addressEditText = findViewById(R.id.addressEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
    }
    public void saveButton(View view){
         String name = nameEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String phone = phoneEditText.getText().toString();


        Data_model.getInstance().edit_contactArrayList.add(new edit_contact(name,address,phone));

finish();
    }
}