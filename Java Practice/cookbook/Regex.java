import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Character;

public class Regex{
	String a;
	{System.out.println("Regex Class Initialized");}
	
	public void checkFirst(){
		String pattern = "^Q[aeiou]\\d+\\.";
		String[] input = {"Q777. is the next flight. It is on time.","Quack, Quack, Quack!","Qu9958. is the next flight, Qu9958. It is on time."};
		Pattern p = Pattern.compile(pattern);
		
		for(String in : input){
			System.out.println("====== REGEX lookingAt() method ======");
			// lookingAt() method : Used to match starting of string.
			boolean found = p.matcher(in).lookingAt();
			
			System.out.println("'"+pattern+"'"+(found ? " matches '" : " dosen't match '")+ in + "'");
			
			// matches method : searches for pattern in complete string.
			/*if (in.matches(pattern)) {
				System.out.println(in + " matches \"" + pattern + "\"");
			} 
			else {
				System.out.println("NO MATCH FOR "+pattern+" in " +in);
			}*/
			
			System.out.println("====== REGEX find() method ======");
			// find() method :
			Matcher m = p.matcher(in);//Pattern.compile(pattern).matcher(in);
			if(m.find()){
				//System.out.println(in + " matches Pattern");
				System.out.println("'"+pattern+"'"+" <= matches '"+ in.substring(m.start(0),m.end(0))+"' in line "+in);
				
				System.out.println("====== REGEX replace method's ======");
				
				System.out.println("ReplaceAll: " + m.replaceAll("SUSPICIOUS FLIGHT NUMBER!!"));
				
				m.reset();
				
				StringBuffer sb = new StringBuffer();
				System.out.print("Append methods: ");
				while (m.find()) {
					// Copy to before first match,
					// plus the word "007"
					m.appendReplacement(sb, "007");
				}
				m.appendTail(sb); // copy remainder
				System.out.println(sb.toString());
			}
			else{
				System.out.println("No Match Found");
			}
			
			// Printing all occurrences of a pattern in string.
			while (m.find()) {
				// Simplest method:
				// System.out.println(m.group(0));
				// Get the starting position of the text
				int start = m.start(0);
				// Get ending position
				int end = m.end(0);
				// Print whatever matched.
				// Use CharacterIterator.substring(offset, end);
				System.out.println(in.substring(start, end));
			}
		}		
	}
}