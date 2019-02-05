import java.util.*;
import java.io.*;

public class NameCompare implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        String movie1 = m1.getName();
        String movie2 = m2.getName();

        return movie1.compareTo(movie2);
    }
}