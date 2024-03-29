package com.vitaapp.backend.tesis.domain;

import java.util.List;

public class Pictogram {
    private Integer pictogramId;
    private String name;
    private String imageUrl;
    private Integer subcategoryId;
    private String color;
    private List<ImagePictogram> images;


    public List<ImagePictogram> getImages() {
        return images;
    }

    public void setImages(List<ImagePictogram> images) {
        this.images = images;
    }

    public Integer getPictogramId() {
        return pictogramId;
    }

    public void setPictogramId(Integer pictogramId) {
        this.pictogramId = pictogramId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
