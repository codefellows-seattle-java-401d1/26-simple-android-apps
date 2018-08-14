package com.example.imagedisplay.models;

import android.graphics.drawable.Drawable;

public class Gallery {
    public String name;
    public int ID;
    public String description;

    public Gallery(String name, int ID, String description){
        this.name = name;
        this.ID = ID;
        this.description = description;
    }
}
