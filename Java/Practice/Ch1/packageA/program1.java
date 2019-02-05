package packageA;
/*
	Class Access Modifier 
		Public | Protected | Private
	Class Modifier (NonAccess)
		final | abstract | strictfp
	Method Access modifier
		public | protected | private | final
*/
interface IFoo{
	public static final int secretkey = 999;
	int getKey();
}

public abstract class program1 implements IFoo{
	public static String getPackageName(){
		return "packageA";
	}
	public abstract int setID();
	
	protected static String accessModifierMethod(){
		return "You can access this method";
	}
}
