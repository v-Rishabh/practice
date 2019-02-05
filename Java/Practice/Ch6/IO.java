import java.io.*;

class IO{
	public boolean writeToFile(){
		try{
			File file = new File("MyFile.txt");
			FileWriter fw = new FileWriter(file);
			fw.write("Hey there! i am using whatsapp.");
			fw.flush();
			fw.close();
		}
		catch(IOException e){}
		
		return true;
	}
	
	public void fileRead(){
		try{
			char[] in = new char[100];
			File file = new File("MyFile.txt");
			FileReader fr = new FileReader(file);
			int size = fr.read(in);
			System.out.println("Size of Char Array is : "+size);
			for(char c : in){
				System.out.print(c);
			}
			fr.close();
		}
		catch(IOException e){}
	}
}