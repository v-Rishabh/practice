import java.io.*;
import java.util.*;

public class RatingCompare implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        double r1 = m1.getRating();
        double r2 = m2.getRating();
        if (r1 < r2) {
            return -1;
        }
        if (r1 > r2) {
            return 1;
        } else {
            return 0;
        }
    }
}