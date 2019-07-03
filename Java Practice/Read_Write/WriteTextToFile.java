import java.io.*;
import java.lang.*;

public class WriteTextToFile {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("doc.txt");
            PrintWriter pw = new PrintWriter(fw);

            pw.println("This is Line One.");
            pw.println("This is line two.");

            pw.close();
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }
}