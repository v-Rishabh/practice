import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main{
    public static void main(String[] args){
        ArrayList<String> al = new ArrayList<>();
        getFileName gfn = new getFileName("C://Users//risha//Desktop//Exp//Inputs");
        al = gfn.returnNames();

        ReadFile rf = new ReadFile(al);
        rf.readAllFiles();

        HashMap<String,ArrayList<String>> data = rf.getData();

        //data.forEach((X,Y)->{System.out.println(X+" "+Y);});

        //System.out.println(data.get(al.get(0)));

        Pattern p = Pattern.compile("file1 Line 2");
        
        for(String entry : data.get(al.get(0))){
            Matcher m = p.matcher(entry);
            //System.out.println(entry);
            while (m.find()) {
                System.out.println("Pattern '"+p +"' found from " + m.start() + " to " + (m.end() - 1));
            }
        }
    }
}