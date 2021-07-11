package com.esigelec.recyclerviewapp.model;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class DataModel {
    private static DataModel instance = new DataModel();
    private DataModel(){

        /*productItems.add(new ProductItem("apple",true));
        productItems.add(new ProductItem("soap",true));
        productItems.add(new ProductItem("cake",false));
        productItems.add(new ProductItem("sugar",false));
*/
    }
    public static DataModel getInstance(){
        return instance;
    }
    public ArrayList<ProductItem> productItems = new ArrayList<>();

    public void loadFromFile(Context context){
        try{
            InputStream stream = context.openFileInput(
                    "productItems.txt");
            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(streamReader);

            String line;
            while ((line = reader.readLine())!= null){
                //Log.v("productItems",line);
                String[] aux = line.split(";");
                ProductItem p = new ProductItem(aux[0],
                        aux[1].equals("1")?true:false);
                Log.v("productItems", aux[1]+":"+p.getNeedToBuy());
                productItems.add(p);
            }

            reader.close();
            streamReader.close();
            stream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void saveFromFile(Context context){
        try{
            OutputStream stream = context.openFileOutput(
                    "productItems.txt",
                    Context.MODE_PRIVATE
            );
            OutputStreamWriter writer = new OutputStreamWriter(stream);
            for (ProductItem p:productItems) {
                writer.write(p.getName()+";"
                        +(p.getNeedToBuy()?"1":"0")+"\n");
            }

            writer.flush();
            writer.close();
            stream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
