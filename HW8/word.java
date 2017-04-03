//Tre Gonzales fgonzales19@cmc.edu
public class word {
	
	private String word;
	private String file;
	private int line;
	private int column;
	
	public word(String word, String file, int line, int column) {
		this.word=word;
		this.file=file;
		this.line=line;
		this.column=column;
	}
	
	public String word() {
		return word;
	}
	
	public String toString() {
		return word+": "+file+" "+line+" "+column;
	}
}
