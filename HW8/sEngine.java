//Tre Gonzales fgonzales19@cmc.edu
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class sEngine {
	private BST<String> cw = new BST<String>(); //common words
	private static BST<String> files = new BST<String>(); //files already processed
	private HashMap<String, ArrayList<word>> words = new HashMap<String, ArrayList<word>>(); 
	
	
	public sEngine() throws FileNotFoundException {
		Scanner common = new Scanner(new File("./common.in"));
		while (common.hasNext()) {
			cw.add(common.next());
		}
		processFile("./root.hml");

	}

	public void processFile(String filename) throws FileNotFoundException {
		files.add(filename);
		Scanner scan = new Scanner(new File(filename));
		int lineCount = 0;
		int column;
		while (scan.hasNextLine()) {
			lineCount++;
			column=0;
			String s = scan.nextLine();
			s=s.toLowerCase();
			String[] line = s.split(" ");
			for (int i = 0; i < line.length; i++) {
				if (cw.contains(line[i])) {
					column=column+line[i].length()+1;
				}
				else if(line[i].contains("<")) {
					String a = line[i].replaceAll("[^a-zA-Z]", ""); 
					a=a+".hml";
					if(!files.contains(a)) {
						column=column+line[i].length()+1;
						processFile(a);	
					}
				}
				else {
					String a = line[i].replaceAll("[^a-zA-Z]", ""); 
					if(words.containsKey(a)) {
						words.get(a).add(new word(a, filename, lineCount, column));
					}
					else {
					words.put(a, new ArrayList<word>());
					words.get(a).add(new word(a, filename, lineCount, column));
					}
					column=column+line[i].length()+1;
				}
			}
		}
	}
	
	public void search(String s){
		ArrayList<word> search = words.get(s);
		for(int i=0;i<search.size();i++) {
			if(search.get(i).word().equals(s)) {
				System.out.println(search.get(i));
			}
			
		}
	}
	public static void main (String [] args) throws FileNotFoundException {
		sEngine plz = new sEngine();
		plz.search("computer");
		plz.search("company");
	}
}
