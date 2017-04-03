//Tre Gonzales fgonzales19@cmc.edu
import java.io.FileNotFoundException;

public class UseBankSim {
	
	public static void main (String [] args) throws FileNotFoundException {
		BankSim plzGod = new BankSim("./bank.txt");
		double plz = plzGod.simulate();
		System.out.println(plz);
	}

}
