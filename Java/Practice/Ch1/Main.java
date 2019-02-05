import packageA.program1;

class Main extends program1{
	public static void main(String[] args){
		System.out.println("In Main");
		// Accessing Non Static method from static method.
		//program1 p1 = new program1();
		String packageName = program1.getPackageName();
		System.out.println("Package Name is : "+packageName);
		System.out.println("{FROM ABSTRACT CLASS} ID = "+getID());
		
		Main ref = new Main();
		System.out.println("{FROM INTERFACE} Secret Key is : "+ref.getKey());
		
		String isAccessable = program1.accessModifierMethod();
		System.out.println(isAccessable);
	}
	public int setID(){
		return 10;
	}
	
	public static int getID(){
		Main mn = new Main();
		int ID = mn.setID();
		return ID;
	}
	
	public int getKey(){
		int Key = secretkey;
		return Key;
	}
}