import java.util.*;

class LinkedListClass{
	LinkedList<String> ll = new LinkedList<>();
	
	public void printLinkedList(){
		
		ll.add("One element");
		ll.add("Two element");
		ll.add("Three element");
		ll.add("Four element");
		
		System.out.println("=== Iterator Method ===");
		int j = 0;
		ListIterator i = ll.listIterator();
		while(i.hasNext()){
			Object o = i.next();
			System.out.println("Element " + j++ + " = " + o);
		}
		
		System.out.println("=== Simple For Each Method ===");
		for(String element : ll){
			System.out.println(element);
		}
		
		System.out.println("=== Java 8's Lambda Method ===");
		ll.forEach(s -> System.out.println(s));
		
		System.out.println("=== Linked List Methods ===");
		System.out.println("Index of [Three element] in list = "+ll.indexOf("Three element"));
		System.out.println("Is list empty? "+ll.isEmpty());
		
		System.out.println("=== Linked List Traversing from backwards Methods ===");
		while(i.hasPrevious()){
			Object o = i.previous();
			System.out.println("Element " + j-- + " = " + o);
		}
	}
}