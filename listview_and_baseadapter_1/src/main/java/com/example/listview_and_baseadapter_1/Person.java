package com.example.listview_and_baseadapter_1;

//this increases readability, management and more instead of writing them in the separate fashion

class Person {
    private final int image;
    private final String title;
    private final String description;

    public Person(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
