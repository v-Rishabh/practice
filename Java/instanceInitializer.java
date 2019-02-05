public class instanceInitializer{
	// Field or Variable | Precedence Order: 1
	private String name = "fluffy";
	
	// Instance Initializer | Precedence Order: 2
	// Once all the fields and instance initializers have run, Java returns to the constructor.
	{ System.out.println("Setting Field");}
	
	// Constructor | Precedence Order: 3
	public instanceInitializer(){
		name = "Oscar";
		System.out.println("Setting Constructor");
	}
	
	// Method | Precedence Order: 4
	public static void main(String[] args){
		// Initialization : Constructor is called.
		instanceInitializer I_initializer = new instanceInitializer();
		
		System.out.println(I_initializer.name);
	}
	
}