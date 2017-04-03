// An array implementation

public class StackArray<E> implements Stack<E> {

    private static final int EXPANSION_FACTOR = 2;
    private static final int DEFAULT_CAPACITY = 4;

    private E[] data;
    private int tos;   // Top of Stack


    public StackArray() {
        data = (E[])new Object[DEFAULT_CAPACITY];
        tos = -1;
    }

    // Copy constructor
    public StackArray(StackArray<E> otherStack) {
        final int CAPACITY = (int)(otherStack.size() * EXPANSION_FACTOR);
        data = (E[])new Object[CAPACITY];
        tos = otherStack.tos;
        System.arraycopy(otherStack.data, 0, data, 0, otherStack.size());
    }

    public boolean isEmpty() {
        return (tos == -1);
    }

    public void push(E element) {
        if (tos + 1 == data.length) {
            expandArray(EXPANSION_FACTOR);
        }
        tos++;
        data[tos] = element;
    }

    public E top() throws ESException {
        if (tos == -1) {
            throw new ESException();
        }
        return data[tos];
    }
  
    public E pop() throws ESException {
        if (tos == -1) {
            throw new ESException();
        }
        tos--;
        return data[tos + 1];  // this is interesting
    }                          // what if you are worried about garbage?
  
    // Note: tos is not affected by this, but it is
    // still used as an index in the new array.
    public void expandArray(int n) {
        System.out.println("Expanding the stack array ...");
        int newSize = n * data.length;
        E[] temp = (E[])new Object[newSize];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
  
    public int size () {
        return tos + 1;
    }

    public String toString () {
        String toReturn = "";
        for (int i = 0; i <= tos; i++) {
            toReturn = toReturn + " " + data[i];
        }
        return toReturn;
    }
  
}


