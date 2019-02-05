import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexTest {

    public void regex() {
        Pattern p = Pattern.compile("3667");

        try {
            FileReader fr = new FileReader("MyFile.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            int i = 1;
            while ((str = br.readLine()) != null) {
                Matcher m = p.matcher(str);
                while (m.find()) {
                    System.out.println("Found in line number " + i + " at index " + m.start() + " to " + m.end());
                }
                i++;
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        regexTest rt = new regexTest();
        rt.regex();
    }
}