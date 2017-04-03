import java.util.*;
public class EventList {
LinkedList<Event> events;
	public EventList() {
		 events = new LinkedList<Event>();
	}

	// Determines whether an event list is empty.
	boolean isEmpty() {
		if(events.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}

	// Inserts anEvent into an event list so that events are ordered by
	// time.  If an arrival event and a departure event have the same
	// time, the arrival event precedes the departure event.
	void insert(Event anEvent) {
		if(events.isEmpty()) {
			events.add(anEvent);
		}
		else if(events.peekFirst().time()<anEvent.time()) {
			events.add(anEvent);
		}
		else {
			events.add(0, anEvent);
		}
	}

	// Deletes the first event from an event list.
	 Event delete() {
		return events.remove();
	}

	// Retrieves the first event in an event list.
	Event retrieve() {
		return events.getFirst();
	}
	
	Event peekFirst() {
		return events.peek();
	}
	
	Event pop() {
		return events.pop();
	}

}
