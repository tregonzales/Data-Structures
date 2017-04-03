//Tre Gonzales fgonzales19@cmc.edu
// Note that this implementation is not complete to the
// Java's documentation.  It is meant to give you an idea on
// how you might implement one.

// This implementation uses a nested class to implement its iterator.
// The testing code (main) is also in the same file.
//
// See the one in the folder named 'non_nested' for an implementation
// where iterator is implemented as a separate class.  And main is also
// separated as a separate class.  We will not study that implementation in
// class.  I am merely providing an alternative just to show you how different
// it would be.  The inner class implementation is considered better.

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayList<E> {

    final private static int NOT_FOUND = -1;
    final private static int INITSIZE = 5;
    final private static int EXPANSIONFACTOR = 2;
    
    // elements.size() >= size
    private E[] elements;
    private int size;
    
    public ArrayList() {
        // Java does not allow an array of type E to be created
        // so must create an Object array and typecast
        elements = (E[])new Object[INITSIZE];
        size = 0;
    }

    public boolean add(E o) {
        if(elements.length==size)
        {
        	E[] elements2=(E[])new Object[elements.length*EXPANSIONFACTOR];
        	for(int i=0;i<size;i++) {
        		elements2[i]=elements[i];
        	}
        	elements=elements2;
        	elements[size]=o;
        	size++;
        	return true;
        }
        else
        	elements[size]=o;
        	size++;
        return true;
        }
    

    public boolean contains(E o) {
        return (indexOf(o) >= 0);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E)elements[index];
    }

    // Returns the index of o in elements or -1 if o is not found in elements.
    public int indexOf(E o) {
        for(int i=0;i<size;i++) {
        	if(elements[i].equals(o))
        		return i;
        }
        return -1;
    }

    public void set(int index, E o) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        elements[index] = o;
    }

    public boolean remove(Object o) {
        int pos = findPos(o);
        if (pos == NOT_FOUND) {
            return false;
        }
        else {
            remove(pos);
            return true;
        }
    }

    // Removes the element in the index position filling in the hole.
    // Returns the element being removed.
    public E remove(int index) {
        E o=elements[index];
        for(int i=index;i<size-1;i++) {
        	elements[i]=elements[i+1];
        }
        elements[size-1]=null;
        size--;
        return o;
    }

    private int findPos(Object o) {
        for (int i = 0; i < size(); i++) {
            if (o == null) {
                if (elements[i] == null) {
                    return i;
                }
            }
            else if (o.equals(elements[i])) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    public int size() {
        return size;
    }

    public Iterator<E> iterator () {
        return (new ArrayListIterator());
        // If you implemented ArrayListIterator as a separate class
        // rather than as an inner class, you would have to pass
        // the current ArrayList object, i.e., this, as an actual
        // argument as follows.  If you did that, then you would
        // have to modify ArrayListIterator class appropriately
        // as well.
        //
        // return (new ArrayListIterator(this));
    }

    private class ArrayListIterator implements Iterator<E> {

        private int cursor;
        //private E[] list;

        public ArrayListIterator() {
            cursor = 0;
        }
       /* public ArrayListIterator(ArrayList<E> alist) {
        	cursor=0;
        	alist.toArray();
        }*/

        public boolean hasNext() {
        	if(cursor<size) {
        		return true;
        	}
        	else {
        		return false;
        	}
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E o=elements[cursor];
            cursor++;
            return o;
            
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<Integer>();
        for (int i = 0; i < 11; i++) {
            ints.add(new Integer(i));  // This would certainly work
            // ints.add(i);  // This would work as well due to autoboxing
        }
            for (int i = 0; i < 11; i++)
            	System.out.println(ints.get(i));
        
        Iterator<Integer> itr = ints.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}