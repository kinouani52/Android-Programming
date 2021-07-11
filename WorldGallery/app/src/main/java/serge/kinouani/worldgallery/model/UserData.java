package serge.kinouani.worldgallery.model;

public class UserData {
    String currentCity,preference;

    public UserData( String currentCity,String preference) {


        this.currentCity= currentCity;
        this.preference= preference;


}
    public UserData() {
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getPreference() {
        return preference;
    }

    public void setEmail(String preference) {
        this.preference = preference ;
    }


}