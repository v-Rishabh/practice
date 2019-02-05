import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws IOException{
        ArrayList<String> al = new ArrayList<>();
		SortedMap<String,Double> tMap = new TreeMap<>();
        getFileName gfn = new getFileName("E://Rishabh//practice-master//practice-master//Exp2//Inputs");
        al = gfn.returnNames();

        ReadFile rf = new ReadFile(al);
        rf.readAllFiles();

        HashMap<String,String> data = rf.getData();
		System.out.println("Enter phrase to search");
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
         
        // Reading data using readLine 
        String query = reader.readLine();
		Search startProcess = new Search();
		startProcess.search(data,query);
		startProcess.rank();

    }
}