//Tre Gonzales fgonzales19@cmc.edu
public class ArrivalEvent extends Event {

	private int arrTime;
	private int tranTime;
	
	public int time() {
		return arrTime;
	}
	
	public int getTranTime() {
		return tranTime;
	}
	
	public ArrivalEvent(int x, int y) {
		arrTime=x;
		tranTime=y;
	}

	public boolean isArr() {
		return true;
	}
	
	public boolean isDep() {
		return false;
	}
}
