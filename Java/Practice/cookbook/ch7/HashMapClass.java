import java.util.*;

class HashMapClass{
	Map<Integer,String> hashMap = new HashMap<>();
	
	public void printHashMap(){
		
		hashMap.put(1,"One element");
		hashMap.put(2,"Two element");
		hashMap.put(3,"Three element");
		hashMap.put(4,"Four element");
		
		System.out.println("=== [HashMap] Simple For Each Method ===");
		for(Integer key : hashMap.keySet()){
			System.out.println("Key : "+key+"  | Value : "+hashMap.get(key));
		}
		
		System.out.println("=== [HashMap] Java 8's Lambda ForEach Method ===");
		hashMap.entrySet().forEach(mE -> System.out.println("Key = "+mE.getKey()+ " | Value = "+mE.getValue()));
		
		System.out.println("=== [HashMap] Iterator Method ===");
		Iterator i = hashMap.keySet().iterator();
		while(i.hasNext()){
			Object key = i.next();
			System.out.println("Key = "+key+ "| Value : "+hashMap.get(key));
		}
	}
}