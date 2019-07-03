import java.io.*;
import java.lang.*;

public class ReadTextFile {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("doc.txt");
            BufferedReader br = new BufferedReader(fr);

            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }
}