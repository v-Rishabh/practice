import java.util.*;
import java.io.*;

public class runMovie {
    public static void main(String[] args) {
        ArrayList<Movie> al = new ArrayList<>();
        al.add(new Movie("Force Awakens", 8.3, 2015));
        al.add(new Movie("Star Wars", 8.7, 1977));
        al.add(new Movie("Empire Strikes Back", 8.8, 1980));
        al.add(new Movie("Return of the Jedi", 8.4, 1983));

        Collections.sort(al);
        System.out.println("===Sorted by Year===");
        for (Movie m : al) {
            System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear());
        }
        System.out.println("===Sorted by Rating===");
        RatingCompare rc = new RatingCompare();
        Collections.sort(al, rc);
        for (Movie m : al) {
            System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear());
        }
        System.out.println("===Sorted by Name===");
        NameCompare Ncom = new NameCompare();
        Collections.sort(al, Ncom);
        for (Movie m : al) {
            System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear());
        }
    }
}