import java.util.*;
import java.util.TreeSet; 

public class TreeSetTest{
	TreeSet<String> treeSet = new TreeSet<>();
	
	public void printTree(){
		treeSet.add("B");
		treeSet.add("Z");
		treeSet.add("M");
		treeSet.add("N");
		treeSet.add("E");
		treeSet.add("P");
		
		System.out.println("Our Tree Contains : "+treeSet.size()+ " elements.");
		System.out.println("Lowest Alphabetical order element is : "+treeSet.first());
		
		System.out.println("------- Sorted Tree -------");
		treeSet.forEach(name -> System.out.println(name));
		
		System.out.println("------- Elements Greater than (M) -------");
		System.out.println(treeSet.tailSet("M").toArray().length-1 +" elements higher than \"M\""); 
	}
}