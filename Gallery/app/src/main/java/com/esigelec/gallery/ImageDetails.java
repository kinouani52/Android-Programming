package com.esigelec.gallery;

public class ImageDetails {
    private String drawableName;
    private String title;
    private String comments;

    public ImageDetails(String title,String drawableName) {
        this.drawableName = drawableName;
        this.title = title;
        this.comments = "";
    }

    public String getDrawableName() {
        return drawableName;
    }

    public void setDrawableName(String drawableName) {
        this.drawableName = drawableName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
