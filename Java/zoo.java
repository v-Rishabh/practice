public class zoo{
	// Field or Variable
	public static String out;
	
	// Driver method
	public static void main(String[] args){
		out = args[0];
		
		boolean result = isCorrect("Hello");
		
		String answer = (result == true)? "Input was correct -> Hello" : "Input was not Correct, Expected Input was Hello, Case sensitive";
		
		System.out.print(answer);
	}
	
	// Method for checking if the value is correct or not. TDD :p
	public static boolean isCorrect(String input){
		if(input.equals(out))
			return true;
		else
			return false;
	}
}
