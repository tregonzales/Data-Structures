/**
 * This implementation does not conform to Java's documentation.
 * It will still be complete enough to give you an idea as to what it
 * takes to implement one.
 *
 * Note: This implementation is different from the one described in the
 *       lecture slides.  This one uses java.util.LinkedList in each
 *       bucket of the table.
 */
//Tre Gonzales fgonzales19@cmc.edu
import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")

public class MyHashMap {

    private transient LinkedList table[];
    private int initCapacity;
    private int size;

    public MyHashMap(int initialCapacity) {
        size = 0;
        initCapacity = initialCapacity;
        table = new LinkedList[initCapacity];

        // Initialize each bucket with an empty LinkedList.
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<Entry>();
        }
    }

    public int myHashCode(Object o) {
        return Math.abs(o.hashCode()) % initCapacity;
    }

    public void clear() {
        for(int i=0; i<table.length; i++) {
        	table[i].clear();
        }
    }

    public boolean containsKey(Object key) {
        int hcode = myHashCode(key);
        LinkedList list = table[hcode];
        ListIterator itr = list.listIterator(0);
        while (itr.hasNext()) {
            Entry e = (Entry)itr.next();
            if ((e.key).equals(key)) {
                return true;
            }
        }
        return false;
    }
    
    //O(n)
    public boolean containsValue(Object value) {
    	for(int i=0; i<table.length; i++) {
    		if(!table[i].isEmpty()) {
    			for(int j=0; j<table[i].size(); j++) {
    				Entry e = (Entry) table[i].get(j);
    				if(e.value.equals(value)) {
    					return true;
    				}
    			}
    		}
    	} 		
    	return false;
    }
    	
    
    //O(1)
    public Object put(Object key, Object value) {
    	Entry e = new Entry(key, value);
    	if(this.containsKey(key)) {
    	int hcode = myHashCode(key); 
    			for(int j=0; j<table[hcode].size(); j++) {
    				e = (Entry) table[hcode].get(j);
    				if(e.key.equals(key)) {
    					e.value=value;
    					return e;
    				}
    			}
    	
    	}
    	else {
    		int hcode = myHashCode(key); 
        	table[hcode].add(e);
        	size++;
        	return e;
    	}
    	
    	
    	return e;
    	
}

    public Object get(Object key) {
    	int hcode = myHashCode(key); 
    			for(int j=0; j<table[hcode].size(); j++) {
    				Entry e = (Entry) table[hcode].get(j);
    				if(e.key.equals(key)) {
    					return e;
    				}
    			}
    		
    	
    	return null;
    }
    
    //O(1)
    public Object remove(Object key) {
        int hcode = myHashCode(key);
        LinkedList list = table[hcode];
        ListIterator itr = list.listIterator(0);
        while (itr.hasNext()) {
            Entry e = (Entry)itr.next();
            if ((e.key).equals(key)) {
                if (list.remove(e)) {
                    size--;
                    return e.value;
                }
                else {
                    return null;
                }
            }
        }
        return null;
    }

    public boolean isEmpty() {
    	if(size==0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public int size() {
        return size;
    }

    public Iterator iterator() {
        return new MyHashMapIterator();
    }

    public void display() {
        LinkedList list;
        ListIterator itr;
        for (int i = 0; i < table.length; i++) {
            list = table[i];
            itr = list.listIterator(0);
            System.out.print("Bucket " + i + ": ");
            while (itr.hasNext()) {
                Entry e = (Entry)itr.next();
                System.out.print(e.key + ":" + e.value + "  ");
            }
            System.out.println();
        }
    }

    private static class Entry {
        Object key;
        Object value;
        
        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
        public String toString() {
        	return key+" "+value;
        }
    }

    private class MyHashMapIterator implements Iterator {
    	LinkedList next;
    	int i=0;
        // Complete this constructor
        public MyHashMapIterator() {
        	next = table[i];
        }

        // Complete this method
        public boolean hasNext() {
            if(i!=size) {
            	return true;
            }
            else {
            	return false;
            }
        }

        // Complete this method
        public Object next() {
        	if(next!=null) {
        	LinkedList temp=next;
        	i++;
        	next = table[i];
        	return temp;
        	}
        	else if(next==table[size-1]) {
        		i++;
        		return next;
        	}
        	return null;
        }

        // This one is optional, i.e., you are not required to complete it.
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
    }  // class MyHashMapIterator

    

    public static void main(String[] args) {
        MyHashMap hm = new MyHashMap(7);

        String econ = "Econ";
        
        String k1 = new String("apple");
        String v1 = new String("appleVal");
        System.out.println("1. size = " + hm.size());
        System.out.println(hm.put(k1, v1));
        System.out.println("2. size = " + hm.size());
        System.out.println(hm.put(k1, v1));
        System.out.println("3. size = " + hm.size());

        System.out.println(hm.put("CS", "11"));
        System.out.println(hm.put("CS", "22"));
        System.out.println(hm.put(econ, "23"));
        System.out.println(hm.put("Chem", "33"));
        System.out.println(hm.put("Bio", "44"));
        System.out.println(hm.put("Math", "55"));
        System.out.println(hm.put("Math", "77"));

        hm.display();
        
        System.out.println("");
        Iterator itr = hm.iterator();
        while(itr.hasNext()) {
        	System.out.println(itr.next());
        }
        System.out.println("");
        
        System.out.println("4. size = " + hm.size());

        System.out.println("before remove Bio " + hm.get("Bio"));
        hm.remove("Bio");
        System.out.println("after remove  Bio " + hm.get("Bio"));

        System.out.println("5. size = " + hm.size());

        System.out.println("containsKey Bio = " + hm.containsKey("Bio"));
        System.out.println("containsKey Math = " + hm.containsKey("Math"));

        System.out.println("containsValue 44 = " + hm.containsValue("44"));
        System.out.println("containsValue 77 = " + hm.containsValue("77"));

        System.out.println("6. size = " + hm.size());
        System.out.println("hm is empty (T or F) " + hm.isEmpty());
        hm.clear();
        System.out.println("7. size = " + hm.size());
        System.out.println("hm is empty (T or F) " + hm.isEmpty());
    }
}