import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Math;

class Search {
	private SortedMap<String, Double> tMap = new TreeMap<>();
	private Stack<String> st = new Stack<>();

	public void search(HashMap<String, String> data, String query) {

		String stringToSearch = query;
		for (Map.Entry<String, String> entry : data.entrySet()) {

			String fileData = entry.getValue();
			String[] queryArray = stringToSearch.split(" ");
			int patternLen = queryArray.length;
			int matchByAppendCount = 0;
			String patternToSearch = "";

			// Match Pattern by appending word to string.
			for (String currentElement : queryArray) {
				patternToSearch = patternToSearch.concat(currentElement.toString());
				Pattern p = Pattern.compile(patternToSearch.trim(), Pattern.CASE_INSENSITIVE);
				Matcher m = p.matcher(fileData);
				while (m.find()) {
					if (queryArray.length >= matchByAppendCount) {
						matchByAppendCount += 1;
						System.out.println("Found " + patternToSearch);
						break;
					}
				}
				patternToSearch = patternToSearch.concat(" ");
			}

			// Remove any additional space.
			patternToSearch = patternToSearch.trim();

			// Match pattern while removing word from start of string.
			int matchByRemoveCount = 0;
			// if (matchByAppendCount != patternLen) {
			outerLoop: for (int i = 0; i < patternLen - 1; i++) {
				String[] newPattern = patternToSearch.split(" ", 2);
				patternToSearch = newPattern[1];
				Pattern p1 = Pattern.compile(patternToSearch, Pattern.CASE_INSENSITIVE);
				Matcher m = p1.matcher(fileData);
				while (m.find()) {
					matchByRemoveCount++;
					System.out.println("Found " + patternToSearch);
					break outerLoop;
				}
				// matchByRemoveCount--;
			}
			// }

			// Get total count of matching words.
			int totalCountOfWordsMatched = 0;
			if (matchByAppendCount >= matchByRemoveCount) {
				totalCountOfWordsMatched = matchByAppendCount;
			} else {
				totalCountOfWordsMatched = matchByRemoveCount;
			}
			System.out.println(matchByAppendCount + " " + matchByRemoveCount);

			// Calculate %age
			double percentageMatch = (totalCountOfWordsMatched * 100);
			percentageMatch = (Math.round(percentageMatch / patternLen));

			// Add entry in map
			tMap.put(entry.getKey(), percentageMatch);

		}
	}

	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = map.get(k1).compareTo(map.get(k2));
				if (compare == 0)
					return 1;
				else
					return compare;
			}
		};

		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}

	public void rank() {
		Map sortedMap = sortByValues(tMap);
		// Get a set of the entries on the sorted map
		Set set = sortedMap.entrySet();

		// Get an iterator
		Iterator i = set.iterator();

		// Display elements
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			String Key = me.getKey().toString();
			String sortedData = "Matching Percentage : " + Key.substring(Key.lastIndexOf("\\") + 1).trim() + ":"
					+ me.getValue();
			st.push(sortedData);
		}

		// Print ordered result
		while (!st.isEmpty()) {
			System.out.println(st.pop());
		}
	}

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		getFileName gfn = new getFileName("C://Users//risha//Desktop//Schibsted//CodingChallenge//src//TestFiles");
		al = gfn.returnNames();
		ReadFile rf = new ReadFile(al);
		rf.readAllFiles();
		HashMap<String, String> data = rf.getData();
		String query = "blue moon";
		Search startProcess = new Search();
		startProcess.search(data, query);
		startProcess.rank();
	}
}