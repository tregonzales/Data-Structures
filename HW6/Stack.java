
public interface Stack<E> {

    // Adds element to the top of the stack
    public void push(E element);

    // Removes and returns the top element of the stack.
    // Raises an exception if the stack is empty and
    // pop is attempted
    public E pop() throws ESException;

    // Returns the top element of the stack.  It does
    // not remove the element from the stack, it only peeks
    // at the top element.  Raises an exception if the stack
    // is empty and top is attempted
    public E top() throws ESException;

    // Tests to see if the stack is empty.
    public boolean isEmpty();

    public int size();

}

