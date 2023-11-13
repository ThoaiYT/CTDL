package task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		// TODO
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		int index = 1;
		while (true) {
			line = reader.readLine();

			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, " ");

			while (tokens.hasMoreTokens()) {
				String word = tokens.nextToken();
				if (!tokens.hasMoreTokens()) {
					add(word, -index);
				}
				else add(word, index);
			}
			index++;
		}
		reader.close();
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		// TODO
		if (map.containsKey(word)) {
			ArrayList<Integer> list = map.get(word);
			list.add(position);
		}
		else {
			map.put(word,new ArrayList<Integer>() );
			add(word, position);
		}
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		// TODO
		Map<String,ArrayList<Integer>> dcfac = new TreeMap<String, ArrayList<Integer>>(map);
		for (Map.Entry<String, ArrayList<Integer>> m : dcfac.entrySet()) {
			System.out.print(m.getKey()+" "+pss(m.getValue()));
			System.out.println();
		}
	}
	public String pss(ArrayList<Integer> as) {
		String re="";
		for (Integer a : as) {
			re+=a+" ";
		}
		return re;
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		// TODO
		String d ="";
		int index =1;
		while (true) {
			
		}
		
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		String mostFrequent = null;
	    int maxCount = 0;

	    for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
	        int count = entry.getValue().size();

	        if (count > maxCount) {
	            maxCount = count;
	            mostFrequent = entry.getKey();
	        }
	    }

	    return mostFrequent;
	}
	public static void main(String[] args) throws IOException {
		TextAnalyzer asdad = new TextAnalyzer();
		asdad.load("data/fit.txt");
		System.out.println(asdad.map.size());
		System.out.println(asdad.mostFrequentWord());
		System.out.println("-----------------------------------");
		asdad.displayWords();
	}

}
