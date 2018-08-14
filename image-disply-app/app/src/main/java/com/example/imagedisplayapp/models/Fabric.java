package com.example.imagedisplayapp.models;

import android.graphics.drawable.Drawable;

public class Fabric {
    public String name;
    public String catagory;
    public String type;
    public int drawableId;
    public String description;

    public Fabric(String name, String catagory, String type, int drawableId, String description) {
        this.name = name;
        this.catagory = catagory;
        this.type = type;
        this.drawableId = drawableId;
        this.description = description;

    }
}
