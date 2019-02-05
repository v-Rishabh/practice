import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadAllLineTest{
    public static void main(String[] args){
        StringBuilder fileData = new StringBuilder();;
        try{
            FileReader fr = new FileReader("C://Users//risha//Desktop//Exp2//Inputs//file1.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            while((line = br.readLine()) != null){
                fileData.append(line);
            }
            br.close();

        }
        catch(IOException e){
            System.out.println(e.toString());
        }

        String stringToSearch = "file1 Line 2. y";
        System.out.println("Complete Data -> "+fileData.toString());
        String[] myData = stringToSearch.split(" ");
        int patternLen = myData.length;
        int count = 0;
        String pat = "";
        for(String str : myData){
            System.out.println("Current str = "+str);
            pat = pat.concat(str.toString());
            System.out.println("Current pat = ["+pat+"]");
            Pattern p = Pattern.compile(pat);
            Matcher m = p.matcher(fileData);
            if (m.find()) {
                if(str.length() > count){
                    count += 1;
                    System.out.println("Found "+pat);
                }
            }
            pat = pat.concat(" ");
        }
        System.out.println("Total Count "+ count);

        /*Pattern p = Pattern.compile("file1 Line 2");
        Matcher m = p.matcher(fileData);
        while (m.find()) {
            System.out.println("Pattern '"+p +"' found from " + m.start() + " to " + (m.end() - 1));
        }*/ 
    }
}