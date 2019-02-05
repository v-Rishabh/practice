class Main{
	public static void main(String[] args){
		System.out.println("In Main");
		System.out.println("----------Testing Overloading [Widening VS Boxing] ----------");
		int i = 5;
		Program p = new Program();
		p.add(i);
		System.out.println("----------Testing Wrapper Class Methods of Primitives ----------");
		// Integer.valueOf("101011",2); Number, Base 
		Integer i1 = Integer.valueOf("101011",2);
		System.out.println("Wrapper Class Of int "+i1);
		Integer i2 = new Integer(42); // make a new wrapper object
		byte b = i2.byteValue();
		System.out.println("Conversion of int to byte "+i2);
		double d1 = Double.parseDouble("3.14");
		System.out.println("String to Double "+d1);
		System.out.println("----------Testing Autoboxing ----------");
		
		System.out.println("---------- [Manual Boxing and Unboxing] ----------");
		// Make a new Integer
		Integer i3 = new Integer(567);
		// unwrap it
		int x = i3.intValue();
		// Do processing on value
		x++;
		// re-wrap it
		i3 = new Integer(x);
		// print it
		System.out.println("Value of 567 after adding 1 to it : "+i3);
		
		System.out.println("---------- [Autoboxing] ----------");
		Integer i4 = new Integer(567);
		i4++;
		System.out.println("Value of 567 after adding 1 to it : "+i4);
	}
}