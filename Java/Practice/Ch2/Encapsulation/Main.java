
class Main{
	public static void main(String[] args){
		System.out.println("----------Testing Encapsulation----------");
		Program p = new Program();
		p.setID(10);
		int ID = p.getID();
		System.out.println("ID : "+ID);
		// ZIP was set using Instantiation block
		int ZIP = p.getZIP();
		System.out.println("ZIP : "+ZIP);
		// Below code will lead to compile time ERROR. [Encapsulation Example]
		//p.ZIP = 201005;
		
		// Testing Polymorphism
		System.out.println("----------Testing Polymorphism----------");
		
		// GameTwo class does not have displayShape() method.
		GameTwo gt = new GameTwo();
		gt.displayShape();
		
		// GameOne class have displayShape() method.[Overriding]
		GameOne go = new GameOne();
		go.displayShape();
		
		// Polymorphism
		System.out.println("----------Passing Subclass object as argument to Superclass reference----------");
		doShape(go);
		doShape(gt);
		
		
		// Instance of test
		System.out.println("----------Testing InstanceOf----------");
		if(gt instanceof Object)
			System.out.println("GameOne is Instance of object");
		
		// Overloading test
		System.out.println("----------Testing Operator Overloading----------");
		int resI = go.add(2,4);
		System.out.println("Result for 2 + 4 is : "+resI);
		float resF = go.add(2.3f,5.7f);
		System.out.println("Result for 2.3 + 5.7 is : "+resF);
		
		// Reference variable Casting
		System.out.println("----------Testing Reference variable Casting----------");
		GameShape gs = new GameOne();
		
		if(gs instanceof GameOne){
			System.out.println("Running Without Down-casting as this method is available in GameShape");
			gs.displayShape();
			// Down-casting [From Generic Class to more Specific Class.]
			GameOne gOne = (GameOne)gs;
			int refI = gOne.add(2,4);
			System.out.println("Down-casting [GameOne gOne = (GameOne)gs; int refI = gOne.add(2,4);]");
			System.out.println("[This (add) method only available in GameOne] Result for 2 + 2 is : "+resI);
		}
		
		// Up-casting [From more Specific class to Generic Class.]
		System.out.println("Up-casting");
		GameOne g1 = new GameOne();
		GameShape gShape = (GameShape)g1;
		gShape.displayShape();
		// Compiler Error : Cannot Find Symbol
		/*
			int result = gShape.add(2,4);
			System.out.println("Result for 2 + 4 is : "+result);
		*/
		
		// Using Static Variables
		System.out.println("----------Testing Static Variable----------");
		int instanceCount = g1.getInstanceCount();
		System.out.println("Instance Count : "+instanceCount);
	}
	
	/* The key point is that the doShapes() method is declared with a GameShape
		argument but can be passed any subtype (in this example, a subclass) of GameShape.
		The method can then invoke any method of GameShape, without any concern
		for the actual runtime class type of the object passed to the method. */
		
	public static void doShape(GameShape shape){
		shape.displayShape();
	}
}