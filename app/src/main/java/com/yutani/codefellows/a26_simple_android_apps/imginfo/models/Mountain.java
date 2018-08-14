package com.yutani.codefellows.a26_simple_android_apps.imginfo.models;

public class Mountain {
    public int imgId;
    public String name;
    public String elevation;
    public String description;

    public Mountain (int imgId, String name, String elevation, String description) {
        this.imgId = imgId;
        this.name = name;
        this.elevation = elevation;
        this.description = description;
    }
}
