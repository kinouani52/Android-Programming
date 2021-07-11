package serge.kinouani.worldgallery.model;

public class CardData {

    private String title;
    private String detail;
    private int drawableId;

    public  String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public  int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public CardData(String title, String detail, int drawableId) {
        this.title = title;
        this.detail = detail;
        this.drawableId = drawableId;
    }
}
