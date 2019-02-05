import java.io.*;

class Test{
	public static void main(String[] args) throws IOException{
		System.out.println("You passed as input -> "+args[0]);
		System.out.println("Enter Something");
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
         
        // Reading data using readLine 
        String name = reader.readLine(); 
  
        // Printing the read line 
        System.out.println(name); 
	}
}