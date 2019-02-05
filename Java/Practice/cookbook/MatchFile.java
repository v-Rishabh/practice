import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Character;
import java.io.*;

class MatchFile{
	
	public void matchExpFromFile(){
		// The RE pattern
		Pattern patt = Pattern.compile("p\\w+=.*");
		try{
			// Read the file
			File file = new File("data.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line;
			while((line = br.readLine()) != null){
				// For each match in the line, extract and print it.
				Matcher m = patt.matcher(line);
				while (m.find()) {
					// Simplest method:
					// System.out.println(m.group(0));
					// Get the starting position of the text
					int start = m.start(0);
					// Get ending position
					int end = m.end(0);
					// Print whatever matched.
					// Use CharacterIterator.substring(offset, end);
					System.out.println("Found "+line.substring(start, end));
				}
			}
			br.close();
		}
		catch(IOException e){}
	}
}