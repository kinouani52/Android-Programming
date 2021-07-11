package serge.kinouani.worldgallery.model;

import java.util.ArrayList;

import serge.kinouani.worldgallery.R;

public class DataModel {
    private final static DataModel instance = new DataModel();
    private DataModel(){
            cardDataArrayList.add(new  CardData("eiffel","Paris", R.drawable.eiffel));
        cardDataArrayList.add(new  CardData("Renaissance africaine","Dakar", R.drawable.africanrenaissance));
        cardDataArrayList.add(new  CardData("Liberté","New York", R.drawable.liberty));
        cardDataArrayList.add(new  CardData("Nelson Mandela","Pretoria", R.drawable.mandela));
        cardDataArrayList.add(new  CardData("Arc de Triomphe","Paris", R.drawable.arc));
        cardDataArrayList.add(new  CardData("Christ the Redeemer","Rio", R.drawable.christtheredeemer));
        cardDataArrayList.add(new  CardData("El mina Castle","Cape coast", R.drawable.elmina));
        cardDataArrayList.add(new  CardData("Site de Gorée","Gorée", R.drawable.goree));
        cardDataArrayList.add(new  CardData("Monument de la Réunification","Cameroon", R.drawable.monument_reunification));
        cardDataArrayList.add(new  CardData("Taj Mahal","Inde", R.drawable.tajmahal));
        cardDataArrayList.add(new  CardData("National Heros","Burkina Faso", R.drawable.herosnationaux));
        cardDataArrayList.add(new  CardData("Hare Khrishna","Durban", R.drawable.harekhrishnadurban));
        cardDataArrayList.add(new  CardData("Mosquée Hassan 2","Morocco", R.drawable.mosquehassan2));
        cardDataArrayList.add(new  CardData("Musée Pierre S de Brazza","Brazzaville", R.drawable.savorgnon));
        cardDataArrayList.add(new  CardData("Tour d'Afrique","Burkina", R.drawable.tourdafrique));

    }
    public static DataModel getInstance(){

        return instance;
    }
   public ArrayList<CardData>  cardDataArrayList = new ArrayList<>();
}
