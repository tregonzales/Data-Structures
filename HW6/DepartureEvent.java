
public class DepartureEvent extends Event {
	
	private int depTime;
	
	public DepartureEvent(int x) {
		depTime=x;
	}
	
	public int time() {
		return depTime;
	}

	public boolean isArr() {
		return false;
	}

	public boolean isDep() {
		return true;
	}

}
