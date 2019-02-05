import java.util.*;
import java.io.*;

public class Movie implements Comparable<Movie> {
    // Instance members
    private double rating;
    private String name;
    private int year;

    public int compareTo(Movie m) {
        return this.year - m.year;
    }

    Movie(String name, double rating, int year) {
        this.name = name;
        this.year = year;
        this.rating = rating;
    }

    // Getter and Setters for private data
    public double getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

}

/*
 * class main { public static void main(String[] args) {
 * System.out.println("Inner Class"); ArrayList<Movie> al = new ArrayList<>();
 * al.add(new Movie("Force Awakens", 8.3, 2015)); al.add(new Movie("Star Wars",
 * 8.7, 1977)); al.add(new Movie("Empire Strikes Back", 8.8, 1980)); al.add(new
 * Movie("Return of the Jedi", 8.4, 1983));
 * 
 * Collections.sort(al);
 * 
 * for (Movie m : al) { System.out.println(m.getName() + " " + m.getRating() +
 * " " + m.getYear()); } } }
 */