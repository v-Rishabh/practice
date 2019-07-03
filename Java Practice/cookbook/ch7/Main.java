import java.util.*;

class Main{
	public static void main(String[] args){
		System.out.println("----------- Array List --------------");
		ArrayListClass ALC = new ArrayListClass();
		ALC.printArrayList();
		System.out.println("----------- Linked List -----------");
		LinkedListClass LLC = new LinkedListClass();
		LLC.printLinkedList();
		System.out.println("----------- Hash Map -----------");
		HashMapClass HMC = new HashMapClass();
		HMC.printHashMap();
		System.out.println("\n");
		System.out.println("----------- Sorting Using Comparable -----------");
		Employee[] empArr = new Employee[4];
		empArr[0] = new Employee(10, "Mikey", 25, 10000);
		empArr[1] = new Employee(20, "Arun", 29, 20000);
		empArr[2] = new Employee(5, "Lisa", 35, 5000);
		empArr[3] = new Employee(1, "Pankaj", 32, 50000);
		
		ArrayList<Employee> al = new ArrayList<>();
		al.add(empArr[0]);
		al.add(empArr[1]);
		al.add(empArr[2]);
		al.add(empArr[3]);
		
		Arrays.sort(empArr);
		System.out.println("Comparable Sorting of Employees based on ID :\n"+Arrays.toString(empArr));
		
		System.out.println("----------- Sorting Using Comparator -----------");
		
		Collections.sort(al, new AgeComparator());
		System.out.println("Comparator Sorting of Employees based on age:\n"+al);
		
		
		System.out.println("\n----------- Tree Set -----------");
		TreeSetTest TST = new TreeSetTest();
		TST.printTree();
		
	}
}