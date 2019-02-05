class Main{
	public static void main(String[] args){
		System.out.println("In Main");
		System.out.println("---------- Testing Unlabeled break/continue statements ----------");
		System.out.println("---------- Labeled Break ----------");
		boolean var = true;
		loop:
		for(int i=0; i<10; i++){
			while(i<10){
				System.out.println("Hello "+i);
				if(var)
					break loop;
			}
			System.out.println("from For loop "+i);
		}
		
		System.out.println("---------- Unlabeled Break ----------");
		for(int i=0; i<10; i++){
			while(i<10){
				if(var)
					break;
				System.out.println("Hello "+i);
			}
			System.out.println("from For loop "+i);
		}
		
		System.out.println("---------- Unlabeled Continue ----------");
		outer:
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				System.out.println("Hello");
				continue outer;
			} // end of inner loop
			System.out.println("outer"); // Never prints
		}
		System.out.println("Good-Bye");
		
		
		System.out.println("---------- Testing for loops ----------");
		for (int i = 0,j = 0; (i<10) && (j<10); i++, j++) {
			System.out.println("i is " + i + " j is " +j);
		}
		
		int b = 3;
		for (int a = 1; b != 1; System.out.println("iterate")) {
			b = b - a;
		}
		
		System.out.println("---------- Testing for enhanced for loops ----------");
		int[] a = {1,21,3,5};
		for(int i : a){
			System.out.print(i + " ");
		}
		
		System.out.println("\n---------- Testing Assertions ----------");
		int res = doStuff(10,5);
		System.out.println(res);
	}
	
	// Assertion methods
	public static int doStuff(int x , int y){
		assert (y > x): "Y is "+y+" X is "+x;
		int sub = y - x;
		return sub;
	}
}