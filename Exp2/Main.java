import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Math;

class Main{
	public static <K, V extends Comparable<V>> Map<K, V> 
    sortByValues(final Map<K, V> map) {
    Comparator<K> valueComparator = 
             new Comparator<K>() {
      public int compare(K k1, K k2) {
        int compare = 
              map.get(k1).compareTo(map.get(k2));
        if (compare == 0) 
          return 1;
        else 
          return compare;
      }
    };
 
    Map<K, V> sortedByValues = 
      new TreeMap<K, V>(valueComparator);
    sortedByValues.putAll(map);
    return sortedByValues;
  }
    public static void main(String[] args){
        ArrayList<String> al = new ArrayList<>();
		SortedMap<String,Double> tMap = new TreeMap<>();
        getFileName gfn = new getFileName("E://Rishabh//practice-master//practice-master//Exp2//Inputs");
        al = gfn.returnNames();

        ReadFile rf = new ReadFile(al);
        rf.readAllFiles();

        HashMap<String,String> data = rf.getData();

        //data.forEach((X,Y)->{System.out.println(X+" "+Y);});
		//String val = al.get(0);
		//System.out.println("value "+val);
        //System.out.println(data.get(al.get(0)));

        //Pattern p = Pattern.compile("file1 Line 2");
        
        /*for(String entry : data.get(val)){
            Matcher m = p.matcher(entry);
            //System.out.println(entry);
            while (m.find()) {
                System.out.println("Pattern '"+p +"' found from " + m.start() + " to " + (m.end() - 1));
            }
        }*/
		String stringToSearch = "file1 Line two";
		for (Map.Entry<String,String> entry : data.entrySet()) {
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
			String fileData = entry.getValue();
			System.out.println("Current File data -> "+fileData.toString());
			String[] myData = stringToSearch.split(" ");
			int patternLen = myData.length;
			int count = 0;
			String pat = "";
			for(String str : myData){
				pat = pat.concat(str.toString());
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
			if(count != patternLen){
				
				outerLoop:
				for(int i=0; i<patternLen-1; i++){
					String[] newPattern = pat.split(" ",2);
					pat = newPattern[1];
					Pattern p1 = Pattern.compile(pat);
					Matcher m = p1.matcher(fileData);
					while (m.find()) {
						System.out.println("Found "+pat);
						newCount--;
						break outerLoop;
					}
				}
			}
			int result = 0;
			if(count >= newCount){
				System.out.println("Count = "+ count);
				result = count;
			}
			else{
				System.out.println("newCount = "+ newCount);
				result = newCount;
			}

			double percentageMatch = (result * 100);
			percentageMatch = (Math.round(percentageMatch/patternLen));
			System.out.println("Match Percentage is = "+percentageMatch);
			
			tMap.put(entry.getKey(),percentageMatch);
			
			}
			
			Map sortedMap = sortByValues(tMap);
 
			// Get a set of the entries on the sorted map
			Set set = sortedMap.entrySet();
		 
			// Get an iterator
			Iterator i = set.iterator();
		 
			// Display elements
			while(i.hasNext()) {
			  Map.Entry me = (Map.Entry)i.next();
			  System.out.print(me.getKey() + ": ");
			  System.out.println(me.getValue());
			}
    }
}