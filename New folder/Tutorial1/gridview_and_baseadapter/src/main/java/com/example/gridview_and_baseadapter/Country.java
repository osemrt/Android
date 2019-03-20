package com.example.gridview_and_baseadapter;

public class Country {
    private final int imageId;
    private final String countryName;

    public Country(int imageId, String countryName) {
        this.imageId = imageId;
        this.countryName = countryName;
    }

    public int getImageId() {
        return imageId;
    }

    public String getCountryName() {
        return countryName;
    }
}
