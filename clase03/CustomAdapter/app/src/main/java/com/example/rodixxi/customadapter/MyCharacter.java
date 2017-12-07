package com.example.rodixxi.customadapter;

/**
 * Created by rodixxi on 23/11/17.
 */

class MyCharacter {
    int image;
    String name;

    public MyCharacter(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
