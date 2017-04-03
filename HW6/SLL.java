/**
//Tre Gonzales fgonzales19@cmc.edu
 
* The beginnings of a singly linked list implementation
 * (does not conform to Java's List<E> interface yet).
 */

import java.util.*;

@SuppressWarnings("unchecked") 
public class SLL<E> extends AbstractCollection<E> implements List<E> {

    // Just keep track of the head to keep things simple
    private SNode<E> head;
    private SNode<E> tail;
  
    /**
     * Initializes this SLL object to be empty, with elements to be of type E.
     */
    public SLL() {
    	head = null;
        tail = null;
        
    }
    
    /**
     *  Determines if this SLL object has no elements.
     *
     *  @return true -  if this SLL object has no elements; otherwise, false.  
     */
    //O(1)
    public boolean isEmpty () {
        return head == null;
    }
  
  
    /**
     *  Adds a specified element to the front of this SLL object.
     *  @param e - the element to be prepended.
     *  @return true.
     */
    //O(1)
    public boolean add (E e) {
    	SNode<E> temp = new SNode<E>(e);
    	if(head==null) {
    		head=temp;
    		tail=temp;
    		return true;
    }
    	else if(head==tail) {
    		tail=temp;
    		head.next=temp;
    		return true;
    	}
    	else {
    		tail.next=temp;
    		tail=temp;
    		return true;
    	}
    }
  
  
    /**
     *  Returns a SLLIterator object to iterate over this SLL object.
     */ 
    public Iterator<E> iterator() {
        return new SLLIterator();
    }
  
  
    /**  
     *  Determines the number of elements in this SLL object.
     *  The worstTime(n) is O(n).
     *  @return the number of elements.
     */
    //O(n)
    public int size() {
    	return sizeAux(0,head);
    }
    
    public int sizeAux(int count, SNode<E> current) {
    	if(current==null) {
    		return count;
    	}
    	else {
    		return sizeAux(count+1, current.next);
    	}
    }
  
  
    /** 
     *  Determines if this SLL object contains a specified
     *  element. The worstTime(n) is O(n).
     *  @param element - the specified element being sought.
     *  @return true - if this SLL object contains element; otherwise, false.
     *          Returns true if and only if this list contains at least
     *          one element e such that (o==null ? e==null : o.equals(e)). 
     */
    //O(n)
    public boolean contains (Object element) {
    	if(element==null) {
    		return containsAux1(head, element);
    	}
    	else {
    		return containsAux2(head, element);
    	}
    }
    
    //O(n)
    public boolean containsAux1(SNode<E> curr, Object element) {
    	
    	if(curr != null) {
    		if(curr.element==null) {
    			return true;
    		}
    		curr=curr.next;
    		return containsAux1(curr, element);
    	}
    	return false;
    	
    }
    //O(n)
    public boolean containsAux2(SNode<E> curr, Object element) {
    	
    	if(curr != null) {
    		if(element.equals(curr.element)) {
    			return true;
    		}
    		curr=curr.next;
    		return containsAux2(curr, element);
    	}
    	return false;
    	
    }
    
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }  
 
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }
//O(n)
    public int indexOf(Object o) {
            	return indexAux(o, head, 0);
    }
    //O(n)
    public int indexAux(Object o, SNode curr, int count) {
    	if(count==this.size()) {
    		return -1;
    	}
    	if(curr.element==o) {
    		return count;
    	}
    	else {
    		return indexAux(o, curr.next, count+1);
    	}
    }
            
        
        
    

    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    } 

    //O(n)
    public E set(int index, E element) {
    	  	 if (index < 0 || index >= size()) {
    	         throw new IndexOutOfBoundsException("index: " + index);
    	     }
    	     int count = 0;
    	     SNode<E> current = head;
    	     while (count != index) {
    	         current = current.next;
    	         count++;
    	     }
    	     E oldelement=current.element;
    	     current.element=element;
    	     return oldelement;
    }

    	
    		
    	
    
    
   
//O(n)
    public E get(int index) {
      
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        int count = 0;
        SNode<E> current = head;
        while (count != index) {
            current = current.next;
            count++;
        }
        return current.element;
    }

    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }
//O(n)
    public Object[] toArray() { 
        Object[] array=new Object[this.size()];
        SNode<E> curr=head;
        int count=0;
        while(curr!=null) {
        	array[count]=curr.element;
        	count++;
        	curr=curr.next;
        }
        return array;
    }
  
    public <E>E[] toArray(E[] a) { 
        throw new UnsupportedOperationException(); 
    }
    //O(n)
    public boolean remove(Object o) { 
        if (head == null) {  // the list is empty
            return false;
        }
        else if (head.element == o) { // first node?
            head = head.next;         // Note that == is used here
            return true;
        }
        else {  // what we want to remove may be in the rest of the list
            for (SNode curr = head; curr.next != null; curr = curr.next) {
            	if(curr.next==tail && tail.element==o) {
            		tail=curr;
            		curr.next=null;
            		return true;
            	}
            	else if (curr.next.element == o) {
                    curr.next = curr.next.next;
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean containsAll(Collection<?> c) { 
        throw new UnsupportedOperationException(); 
    }
    
    public boolean removeAll(Collection<?> c) { 
        throw new UnsupportedOperationException(); 
    }
  
    public boolean retainAll(Collection<?> c) { 
        throw new UnsupportedOperationException(); 
    }
  
    public List<E> subList(int fromIndex, int toIndex) { 
        throw new UnsupportedOperationException(); 
    }

    public void clear() {
        head = null;
    }
  
    public boolean equals(Object obj) { 
        throw new UnsupportedOperationException(); 
    }
    
    public int hashCode() { 
        throw new UnsupportedOperationException(); 
    }
  
    public String toString() {
        String toReturn = "";
        for (SNode curr = head; curr != null; curr = curr.next) {
            toReturn = toReturn + " " + curr.element;
        }
        return toReturn;
    }

    // The iterator: a non-static inner class because it accesses
    // the outer class' instance fields
    private class SLLIterator implements Iterator<E> {

        private SNode<E> cursor;
    
        // The iterator has been initialized.
        protected SLLIterator() {
            cursor = tail;
        }
    
        /** 
         *  Returns the element this Iterator object was (before this
         *  call) positioned at, and advances this Iterator object.
         *  @return - the element this Iterator object was positioned at.
         *  @throws NoSuchElementException if this Iterator object was
         *          not positioned at an element before this call.
         */                            
        @Override
        public E next() {
        	if(cursor!=null){
            E theElement = cursor.element;
            cursor = cursor.next;
            return theElement;
        	}
        	return null;
        }
        
        /**
         *  Determines if this Iterator object is positioned at an
         *  element in this Collection.
         *  @return true - if this Iterator object is positioned at an
         *          element; false otherwise.                        
         */                   
        @Override
        public boolean hasNext() {       
            return cursor != null;
        }
        
        /**
         *  Removes the element returned by the most recent call to next().
         *  The behavior of this Iterator object is unspecified if the
         *  underlying collection is modified ( while this iteration is in
         *  progress) other than by calling this remove() method.
         *  @throws IllegalStateException - if next() had not been called
         *  before this call to remove(), or if there had been an intervening
         *  call to remove() between the most recent call to next() and this 
         *  call.
         **/
        @Override
        public void remove() { 
            throw new UnsupportedOperationException(); 
        }
        
    } // class SLLIterator
    

    // Node for singly linked list.
    // Static because it doesn't access any state in the outer class.
    private static class SNode<E> {
        private E element;        // element and next are visible to
        private SNode<E> next;    // outer class even when private

        SNode(E data) {
            element = data;
            next = null;
        }
    }

}