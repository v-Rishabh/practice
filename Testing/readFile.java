import java.io.*;
import java.util.*;

public class readFile {
    public void read() {
        try {
            FileReader fr = new FileReader("MyFile.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        readFile rf = new readFile();
        rf.read();
    }
}