import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<String> al = new ArrayList<>();
		SortedMap<String, Double> tMap = new TreeMap<>();
		getFileName gfn = new getFileName("C://Users//risha//Desktop//Schibsted//CodingChallenge//src//TestFiles");
		try {
			// getFileName gfn = new getFileName(args[0]);
			al = gfn.returnNames();

			ReadFile rf = new ReadFile(al);
			rf.readAllFiles();

			HashMap<String, String> data = rf.getData();
			System.out.println("Enter phrase to search");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			// Reading data using readLine
			String query = reader.readLine();
			Search startProcess = new Search();
			startProcess.search(data, query);
			startProcess.rank();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR: No path was provided as argument.");
			System.exit(0);
		}
		catch(Exception ex){
			System.err.println(ex.toString());
		}

	}
}