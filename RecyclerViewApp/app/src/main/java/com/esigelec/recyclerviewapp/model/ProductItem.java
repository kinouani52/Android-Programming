package com.esigelec.recyclerviewapp.model;

public class ProductItem {
    private String name;
    private boolean needToBuy;

    public ProductItem(String name, boolean needToBuy) {
        this.name = name;
        this.needToBuy = needToBuy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNeedToBuy() {
        return needToBuy;
    }

    public void setNeedToBuy(boolean needToBuy) {
        this.needToBuy = needToBuy;
    }
}
