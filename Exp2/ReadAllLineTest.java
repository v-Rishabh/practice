import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadAllLineTest{
    public static void main(String[] args){
        StringBuilder fileData = new StringBuilder();;
        try{
            FileReader fr = new FileReader("E://Rishabh//practice-master//practice-master//Exp2//Inputs//file1.txt");
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

        String stringToSearch = "this Line two";
        System.out.println("Complete Data -> "+fileData.toString());
        String[] myData = stringToSearch.split(" ");
        int patternLen = myData.length;
        int count = 0;
        String pat = "";
        for(String str : myData){
            System.out.println("Current str = "+str);
            pat = pat.concat(str.toString());
            System.out.println("Current pat = ["+pat+"]");
            Pattern p = Pattern.compile(pat.trim());
            Matcher m = p.matcher(fileData);
            while (m.find()) {
                if(str.length() >= count){
                    count += 1;
                    System.out.println("Found "+pat);
					break;
                }
            }
            pat = pat.concat(" ");
        }
        System.out.println("Total Count "+ count);
		System.out.println("Array Split length "+ patternLen);
		
		pat = pat.trim();
		//String[] newSplit = pat.split(" ",2);
		//System.out.println("Spliting on first space and keeping rest of string -> "+ newSplit[0]+" ,"+newSplit[1]);
		
		// Now Search from start
		int newCount = patternLen;
		outerLoop:
		for(int i=0; i<patternLen-1; i++){
			String[] newPattern = pat.split(" ",2);
			pat = newPattern[1];
			System.out.println(pat);
			Pattern p = Pattern.compile(pat);
            Matcher m = p.matcher(fileData);
            while (m.find()) {
				System.out.println("Found "+pat);
                newCount--;
				break outerLoop;
            }
		}
		int result = 0;
		if(count > newCount){
			System.out.println("Count = "+ count);
			result = count;
		}
		else{
			System.out.println("newCount = "+ newCount);
			result = newCount;
		}

		double percentageMatch = (result * 100);
		percentageMatch = percentageMatch/patternLen;
		System.out.println("Match Percentage is = "+percentageMatch);
        /*Pattern p = Pattern.compile("file1 Line 2");
        Matcher m = p.matcher(fileData);
        while (m.find()) {
            System.out.println("Pattern '"+p +"' found from " + m.start() + " to " + (m.end() - 1));
        }*/ 
    }
}