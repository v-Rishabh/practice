/**
 * Schibsted Coding Challenge.
 * Submitted By : Rishabh Verma
 * Date : 05-Feb-2019
 */
package schibsted;

import java.util.*;
import java.io.*;

/**
 * This is Main Class which will run all the classes. While running main class
 * pass path of directory as argument where all the text file's are present.
 */
public class App {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        try {
            getFileName gfn = new getFileName(args[0]);
            al = gfn.returnNames();

            ReadFile rf = new ReadFile(al);
            rf.readAllFiles();

            HashMap<String, String> data = rf.getData();
            System.out.println("Enter phrase to search");
            String query = null;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                // Reading data using readLine
                query = reader.readLine();
            } catch (IOException ex) {
                System.out.println("IO Error Encountered");
            }

            Search startProcess = new Search();
            startProcess.search(data, query);
            startProcess.rank();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: No path was provided as argument.");
            System.exit(0);
        }
    }
}
