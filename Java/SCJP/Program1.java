import java.io.*;

public class Program1{
	public static void main(String[] args){
		char[] in = new char[50];
		int size = 0;
		try{
			File file = new File("fileWrite.txt");
			FileWriter fw = new FileWriter(file);
			fw.write("Rishabh\nhas\nwritten\nthis");
			fw.flush();
			fw.close();
			
			// Now read the written file
			FileReader fr = new FileReader(file);
			size = fr.read(in);
			System.out.println("Size is : "+size);
			for(char c : in){
				System.out.print(c);
			}
			fr.close();
			
			
		}
		catch(IOException e){
		}
	}
}