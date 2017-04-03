
//Tre Gonzales fgonzales19@cmc.edu    waitTime=departure time that just happened + arrivalTime of next customer
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BankSim {
	private static int currentTime;
	private static double waitTime = 0;
	private double customers = 0;
	private static EventList events = new EventList();
	private static LinkedList<ArrivalEvent> bankQ = new LinkedList<ArrivalEvent>();
	private String input;
	private Scanner scan;

	public BankSim(String in) throws FileNotFoundException {
		input = in;
		scan = new Scanner(new File(input));
	}

	// Performs the simulation.
	public double simulate() {
		if (scan.hasNext()) {
			ArrivalEvent a = new ArrivalEvent(Integer.parseInt(scan.next()), Integer.parseInt(scan.next()));
			currentTime = a.time();
			events.insert(a);
		}
		while (!events.isEmpty()) {
			if (events.peekFirst().isArr()) {
				processArrival();
				customers++;
			} else {
				processDeparture();

			}
		}
		System.out.println(customers);
		return waitTime / customers;
	}

	// Processes an arrival event
	public void processArrival() {
		ArrivalEvent a = (ArrivalEvent) events.pop(); //retrieve and remove arrival event from event list
		boolean atFront = bankQ.isEmpty(); // Present queue status
		bankQ.add(a);

		if (atFront) {
			// The line was empty, so new customer is at front of line
			// and begins transaction immediately
			events.insert(new DepartureEvent(currentTime + a.getTranTime()));

		}
		if (scan.hasNext()) {
			Event e = new ArrivalEvent(Integer.parseInt(scan.next()), Integer.parseInt(scan.next()));
			events.insert(e);
		}
	}

	// Processes a departure event
	public static void processDeparture() {
		int a = events.pop().time(); // gets departure time of person that was
										// just helped
		// Update the line by deleting the front customer
		bankQ.pop();
		currentTime = a; //current time = last departure time

		if (!bankQ.isEmpty()) {
			ArrivalEvent ae = bankQ.peekFirst(); // create temp variable of
													// customer at front of line
													// to be helped
			events.insert(new DepartureEvent(currentTime + ae.getTranTime()));
			int b = ae.time(); // get arrival time of person about to be helped
			waitTime += a - b; // waitTime=departure of person ahead of customer-arrival time of customer
			currentTime = currentTime + ae.getTranTime();
		}

	}

}
