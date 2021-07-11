package com.esigelec.gallery.model;

import java.util.ArrayList;

public class DataModel {
    private static DataModel instance =
            new DataModel();

    public ArrayList<ImageDetails> images;
    public int imagesIndex;
    public UserDetails userDetails;

    private DataModel(){
        imagesIndex = 0;
        userDetails = new UserDetails("mjoselli",
                "1234");
        images = new ArrayList<>();
        images.add(new ImageDetails("Sponge Bob",
                "spongebob"));
        images.add(new ImageDetails("Patric Star",
                "patrick"));
        images.add(new ImageDetails("Squidward Tentacles",
                "squid"));
        images.add(new ImageDetails("Mr. Krabs",
                "krabs"));
    }
    public static DataModel getInstance(){
        return instance;
    }
    public ArrayList<String> getImagesStrings(){
        ArrayList<String>titles = new ArrayList<>();
        for (ImageDetails i:images) {
            titles.add(i.getTitle());
        }
        return titles;
    }
}
