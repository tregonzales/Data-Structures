//Tre Gonzales fgonzales19@cmc.edu input3 //Average Height of Leaf Nodes = 2.696990966796875
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BC {

	String [] list = new String[88375];
	BSTRec<String> spell = new BSTRec<String>();
	
	public BC(String input) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(input));
		for(int i=0; i<list.length; i++) {
			list[i]=scan.next();
		}
		
		buildTree(0, list.length-1);
	}
	public void buildTree(int from, int to) {
		if(from>to) {
			return;
		}
		else if (from==to) {
			spell.add(list[from]);
		}
		else {
		int mid = (from+to)/2;
		//System.out.println(list[mid]);
		spell.add(list[mid]);
		buildTree(from, mid-1);
		buildTree(mid+1, to);
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
		BC test = new BC("./words3.txt");
		System.out.println(test.SpellCheck("apple's"));
		System.out.println(test.SpellCheck("apple"));
		System.out.println(test.SpellCheck("lemonade"));
		System.out.println(test.SpellCheck("immedicableness"));
		System.out.println(test.numLeafNodes());
		System.out.println(test.sumHeight());
		System.out.println(test.averageHeight());
		
	}
}
