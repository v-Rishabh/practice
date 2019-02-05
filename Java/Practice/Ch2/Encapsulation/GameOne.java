class GameOne extends GameShape{
	
	private static int instanceCount = 0;
	{instanceCount++;}
	
	// Overriding
	public void displayShape(){
		System.out.println("Displaying Shape of GameOne Class");
	}
	
	public int add(int a, int b){
		return a + b;
	}
	// Overloading
	public float add(float a, float b){
		return a + b;
	}
	
	public int getInstanceCount(){
		return instanceCount;
	}
}