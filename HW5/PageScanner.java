//Tre Gonzales fgonzales19@cmc.edu
import java.util.Iterator;
import java.io.*;
import java.util.*;

public class PageScanner {
	private ArrayList<String> list=new ArrayList<String>();;
	private ArrayList<String> common=new ArrayList<String>();
	private String input;
	private String text;
	
	public PageScanner(String filename) throws IOException {
		input=filename;	
		Scanner scan=new Scanner(new File("./common.txt"));
		while(scan.hasNext()) {
			common.add(scan.next()); 	//create ArrayList of common words
		}
		
		text = new Scanner(new File(input)).useDelimiter("/Z").next(); //make file into one string
		
		while(text.contains("<")||text.contains(">")) {
		text=text.substring(0, text.indexOf("<"))+text.substring(text.indexOf(">")+1); //remove HTML
		}
			
		text=text.toLowerCase();
		
		String[] words=text.split("[ ,.;:?!\n\f\r\t\"]+"); //split file into array of strings
		
		FileWriter fw = new FileWriter(input + "out");
        PrintWriter pw = new PrintWriter(fw);
		for(int i=0;i<words.length;i++) {  				//sorts keywords into arraylist
			if(!(common.contains(words[i]))) {
				list.add(words[i]);
				pw.println(words[i]);	//prints words into output file
				
			}
		}
				
				pw.close(); fw.close(); scan.close();
			
		}
	
	public Iterator<String> iterator() {
		return list.iterator();
	}
	
	public static void main(String [] args) throws IOException {
		PageScanner test1=new PageScanner("./test1.txt");
		Iterator<String> itr1=test1.iterator();
		while(itr1.hasNext()) {
			System.out.println(itr1.next());
		}
			System.out.println("");
		
			PageScanner test2=new PageScanner("./test2.txt");
			Iterator<String> itr2=test2.iterator();
			while(itr2.hasNext()) {
				System.out.println(itr2.next());
		}
			System.out.println("");
			
			PageScanner test3=new PageScanner("./test3.txt");
			Iterator<String> itr3=test3.iterator();
			while(itr3.hasNext()) {
				System.out.println(itr3.next());
		
		}
	}
	
}

	
	
	

	
	
	



		
	

