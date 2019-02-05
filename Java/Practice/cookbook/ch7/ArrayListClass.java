import java.util.*;

class ArrayListClass{
	ArrayList<String> al = new ArrayList<String>();
	
	public void printArrayList(){
		
		al.add("One");
		al.add("Two");
		al.add("Three");
		al.add("Four");
		
		System.out.println("=== Iterator Method ===");
		int j = 0;
		Iterator i = al.iterator();
		while(i.hasNext()){
			Object o = i.next();
			System.out.println("Element " + j++ + " = " + o);
		}
		
		System.out.println("=== Simple For Each Method ===");
		for(String element : al){
			System.out.println(element);
		}
		
		System.out.println("=== Java 8's Lambda Method ===");
		al.forEach(s -> System.out.println(s));
	}
}