package com.example.firebaselist;

public class Movie {
    String name, genre, url;
    int year, length;
    float rating;

    public Movie(){}

    public Movie(String name, String genre, String url, int year, int length, float rating) {
        this.name = name;
        this.genre = genre;
        this.url = url;
        this.year = year;
        this.length = length;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }


    public String getGenre() {
        return genre;
    }


    public String getUrl() {
        return url;
    }


    public int getYear() {
        return year;
    }


    public int getLength() {
        return length;
    }


    public float getRating() {
        return rating;
    }

}
