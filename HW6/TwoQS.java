//Tre Gonzales fgonzales19@cmc.edu
public class TwoQS<E> implements Stack<E> {
	private Queue<E> q1;
	private Queue<E> q2;
	
	public TwoQS() {
		q1=new QueueArray<E>();
		q2=new QueueArray<E>();
	}

	public void push(E element) { 
		q2=new QueueArray<E>(); //create new temporary queue
		q2.enqueue(element); //adds new element as front of queue
		while(!(q1.isEmpty())) {
			try {
				q2.enqueue(q1.dequeue()); //adds the rest of the q1's elements to new q2 in the same order
			} catch (EQException e) {
				
				e.printStackTrace();
			}
		}
		q1=q2;
	}

	public E pop() throws ESException {
		if(q1.isEmpty()) {
			throw new ESException();
		}
		E element=null;
		try {
			element = q1.dequeue(); //the push method keeps the most recently added element as the front (top) element, allowing the dequeue method to access and remove to top element of the stack
		} catch (EQException e) {
						e.printStackTrace();
		}
		return element;
	}

	public E top() throws ESException {
		if(q1.isEmpty()) {
			throw new ESException();
		}
		E element=null;
		try {
			element = q1.front(); //the top element of the stack is stored as the front element of q1 due to the push method
		} catch (EQException e) {
			
			e.printStackTrace();
		}
		return element;
	}

	public boolean isEmpty() {
		if(q1.isEmpty()) {
			return true;
	}
		else {
			return false;
		}
	}
	
	public int size() {
		return q1.size();
	}
	public String toString() {
		return q1.toString();
	}
	
	public static void main(String [] args) throws ESException {
		TwoQS<Integer> trial = new TwoQS<Integer>();
		trial.push(10);
		trial.push(7);
		trial.push(5);
		trial.push(0);
		System.out.println(trial);
		System.out.println(trial.top());
		System.out.println(trial.pop());
		System.out.println(trial);
		trial.push(67);
		trial.push(42);
		System.out.println(trial);
		System.out.println(trial.top());
		System.out.println(trial.pop());
		System.out.println(trial.isEmpty());
		System.out.println(trial);
		System.out.println(trial.size());
		
		
	}
	
}
