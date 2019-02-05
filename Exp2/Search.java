import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Math;

class Search{
	private SortedMap<String,Double> tMap = new TreeMap<>();
	private Stack<String> st = new Stack<>();
	
	public void search(HashMap<String,String> data, String query){
		
		String stringToSearch = query;
		for (Map.Entry<String,String> entry : data.entrySet()) {

			String fileData = entry.getValue();
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
						break;
					}
				}
				pat = pat.concat(" ");
			}
			
			pat = pat.trim();
			
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
						newCount--;
						break outerLoop;
					}
				}
			}
			int result = 0;
			if(count >= newCount){
				result = count;
			}
			else{
				result = newCount;
			}

			double percentageMatch = (result * 100);
			percentageMatch = (Math.round(percentageMatch/patternLen));
			
			tMap.put(entry.getKey(),percentageMatch);
			
			}
	}
	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
    Comparator<K> valueComparator = new Comparator<K>() {
      public int compare(K k1, K k2) {
        int compare = map.get(k1).compareTo(map.get(k2));
        if (compare == 0) 
          return 1;
        else 
          return compare;
      }
    };
 
    Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
    sortedByValues.putAll(map);
    return sortedByValues;
   }
	
	
	public void rank(){
		Map sortedMap = sortByValues(tMap);
		// Get a set of the entries on the sorted map
		Set set = sortedMap.entrySet();
	 
		// Get an iterator
		Iterator i = set.iterator();
	 
		// Display elements
		while(i.hasNext()) {
		  Map.Entry me = (Map.Entry)i.next();
		  //System.out.print(me.getKey() + ": ");
		  String Key = me.getKey().toString();
		  //System.out.println("Matching Percentage : "+Key.substring(Key.lastIndexOf("\\") + 1).trim()+":"+me.getValue());
		  String sortedData = "Matching Percentage : "+Key.substring(Key.lastIndexOf("\\") + 1).trim()+":"+me.getValue();
		  st.push(sortedData);
		}
		
		// print sorted data
		while(!st.isEmpty()){
			System.out.println(st.pop());
		}
	}
}