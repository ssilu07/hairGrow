package com.royals.hairstylegirls.model;

public class HairStyle {

    private final String id;
    private final String image;

    public HairStyle(String id, String image) {
        this.id = id;
        this.image = image;
    }


    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

}
