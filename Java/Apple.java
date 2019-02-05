import food.Fruit;

class Apple extends Fruit{
	
	public int setNutrient(){
		return 10;
	}
	
	public static int getNutrients(){
		// Calling Non Static method from static method.
		Apple a = new Apple();
		return a.setNutrient();
	}
	
	public static void main(String[] args){
		System.out.println("Nutrient Of Apple is "+getNutrients());
	}
	
}