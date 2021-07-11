package serge.kinouani.agenda.model;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Data_model {
    private static Data_model instance = new Data_model();
    private Data_model(){

    }

    public static Data_model getInstance() {
        return instance;
    }

    public ArrayList<edit_contact> edit_contactArrayList = new ArrayList<>();
    public void loadToFile(Context context){
        try{
            InputStream inputStream = context.openFileInput("contacts.txt");
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            while((line = reader.readLine())!= null){
                String []info = line.split(";");
               edit_contactArrayList.add(new edit_contact(
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
            for (edit_contact c:edit_contactArrayList) {
                writer.write(c.getContact_name()+";"+
                        c.getContact_address()+";"+
                        c.getContact_phone()+"\n");
            }
            writer.flush();
            writer.close();
            stream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
