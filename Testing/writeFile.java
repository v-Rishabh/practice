import java.util.*;
import java.io.*;

public class writeFile {
    public void write() {
        try {
            FileWriter fw = new FileWriter("MyFile.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.println("9958783667");
            pw.println("9971158548");
            pw.println("366798712181843667");
            pw.println("9631316824");

            pw.close();
            fw.close();
            System.out.println("Write Successful");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        writeFile wf = new writeFile();
        wf.write();
    }
}