import java.io.*;

public class Program{
	public static void main(String[] args){
		try{
			boolean newFIle = false;
			File file = new File("MyFile.txt");
			System.out.println("Is file already exist? "+file.exists());
			// Create File
			newFIle = file.createNewFile();
			System.out.println("Is file Created? "+newFIle);
			System.out.println("Does the file we created exists now? "+file.exists());
		}
		catch(IOException e){
		}
	}
}