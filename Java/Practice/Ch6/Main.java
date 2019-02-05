import java.io.*;

class Main{
	public static void main(String[] args){
		System.out.println("In Main");
		StringBuffer sb = new StringBuffer("abc");
		System.out.println(sb);
		sb.append("def");
		System.out.println(sb);
		sb.append("ghi").reverse();
		System.out.println(sb);
		
		StringBuffer sb1 = new StringBuffer("0123456789");
		sb1.delete(4,6);
		System.out.println(sb1);
		sb1.insert(4,"45");
		System.out.println(sb1);
		
		System.out.println("---------- Testing File Writer ----------");
		IO io = new IO();
		boolean isWritten = io.writeToFile();
		System.out.println("File Written Successfully");
		
		System.out.println("---------- Testing File Reader ----------");
		io.fileRead();
		
		System.out.println("\n---------- Testing Console Class ----------");
		Console c = System.console(); // #1: get a Console
		char[] pw;
		pw = c.readPassword("%s", "Enter Password: "); // #2: return a char[]
		for(char ch: pw)
		c.format("%c", ch); // #3: format output
		c.format("\n");
	}
}