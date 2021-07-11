package com.esigelec.agendaapp.model;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class DataModel {
    private static DataModel instance = new DataModel();
    private DataModel(){
        /*contactDetailsArrayList.add(new ContactDetails("mark",
                "22", "33"));
        contactDetailsArrayList.add(new ContactDetails("mark2",
                "22", "33"));
        contactDetailsArrayList.add(new ContactDetails("mark3",
                "22", "33"));
        contactDetailsArrayList.add(new ContactDetails("mark4",
                "22", "33"));*/
    }
    public static DataModel getInstance(){
        return instance;
    }
    public ArrayList<ContactDetails>contactDetailsArrayList =
            new ArrayList<>();

    public void loadToFile(Context context){
        try{
            InputStream inputStream = context.openFileInput("contacts.txt");
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            while((line = reader.readLine())!= null){
                String []info = line.split(";");
                contactDetailsArrayList.add(new ContactDetails(
                        info[0],info[1],info[2]
                ));
            }
            reader.close();
            streamReader.close();
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void saveToFile(Context context){
        try{
            OutputStream stream = context.openFileOutput(
                    "contacts.txt",
                    context.MODE_PRIVATE
            );
            OutputStreamWriter writer = new OutputStreamWriter(stream);
            for (ContactDetails c:contactDetailsArrayList) {
                writer.write(c.getName()+";"+
                        c.getAddress()+";"+
                        c.getPhone()+"\n");
            }
            writer.flush();
            writer.close();
            stream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
