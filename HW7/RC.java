//Tre Gonzales fgonzales19@cmc.edu input3 Average Height of Leaf Nodes: ≈3
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RC {

	String [] list = new String[88375];
	BSTRec<String> spell = new BSTRec<String>();
	
	public RC(String input) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(input));
		for(int i=0; i<list.length; i++) {
			list[i]=scan.next();
		}
		
		buildTree();
	}
	public void buildTree() {
		int count=0;
		for(int i=0;i<list.length;i++) {
			int num = (int)(Math.random()*list.length);
			if(list[num].equals("notword")) {
				i--;
			}
			else {
				//System.out.println(list[num]);
				spell.add(list[num]);
				list[num]="notword";
				
			}
		}
	}
	public boolean SpellCheck(String s) {
		if(spell.contains(s)) {
			return true;
		}
		else {
			return false;
		}
	}
		public double averageHeight() {
			return spell.averageHeight();
		}
		
		public double numLeafNodes() {
			return spell.numNodes(spell.root);
		}
		public double sumHeight() {
			return spell.heightNodes(spell.root);
		}
	
	
	public static void main(String [] args) throws FileNotFoundException {
		RC test = new RC("./words3.txt");
		System.out.println(test.SpellCheck("apple's"));
		System.out.println(test.SpellCheck("apple"));
		System.out.println(test.SpellCheck("lemonade"));
		System.out.println(test.SpellCheck("immedicableness"));
		System.out.println(test.numLeafNodes());
		System.out.println(test.sumHeight());
		System.out.println(test.averageHeight());
		
		
	}
}
