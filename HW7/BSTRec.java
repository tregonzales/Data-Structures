//Tre Gonzales fgonzales19@cmc.edu

// The methods in BST.java given on the course web are implemented as
// iterative.  This one implements most of them as recursive methods.

import java.util.*;

public class BSTRec<E> {

    protected Node<E> root;
    protected int size;
    private Stack<Node<E>> s = new Stack<Node<E>>();

    public BSTRec() {
        root=null;
        size=0;
    }

    // Used for debugging (see main)
    public Node<E> getRoot() {
        return root;
    }
    
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public void clear() {
        root = null;
        size = 0;
    }

    
    public Iterator<E> iterator() {
        return new TreeIterator();
    }

    /* Returns true if obj is an element in the current BSTRec object;
     * false otherwise.
     */
    //O(log n)
    public boolean contains(Object obj)  {
        return containsAux(root, obj);
    }
    
	private boolean containsAux(Node<E> nd, Object obj) {
		int comp=((Comparable)(E)obj).compareTo(nd.element);
    	if(comp==0) {
    		return true;
    	}
    	else if(comp>0) {
    		if(nd.right==null) {
    			return false;
    		}
    		else {
    		return containsAux(nd.right, obj);
    		}
    	}
    	else {
    		if(nd.left==null) {
    			return false;
    		}
    		else {
    		return containsAux(nd.left, obj);
    		}
    	}

		
	}
    	
    		
    


    /**
     * Ensures that this BST object contains a specified element.
     * The worstTime(n) is O(n) and averageTime(n) is O(log n).
     *
     * @param element: the element whose presence is ensured in this BST object.
     *
     * @return true: if this BST object changed as a result of this method call
     *         (that is, if element was actually inserted); otherwise, false.
     */
	//O(log n)
    public boolean add(E element) {
        if (root == null) {
            root = new Node<E>(element, null);
            size++;
            return true;
        }
        else {
            return addAux(root, element);
        }
    }
    private boolean addAux(Node<E> curr, E element) {
    	int comp=((Comparable)element).compareTo(curr.element);
    	if(comp>0) {
    		if(curr.right==null) {
    			curr.right = new Node<E>(element, null);
    			curr.right.parent=curr;
    			size++;
    			return true;
    		}
    		else {
    			addAux(curr.right, element);
    		}
    	}
    	else if(comp<0) {
    		if(curr.left==null) {
    			curr.left = new Node<E>(element, null);
    			curr.left.parent=curr;
    			size++;
    			return true;
    		}
    		else {
    			addAux(curr.left, element);
    		}
    	}
    		return false;
    	
    }
  
    /* Returns the node containing minimum element rooted at nd.
     */
    //O(log n)
    private Node<E> getMin (Node<E> nd) {
    	if(root==null) {
    		throw new NoSuchElementException();
    	}
    		if(nd == null) {
    			return null;
    		}
    		while(nd.left!=null) {
    			nd=nd.left;
    		}	
    		return nd;
    }
  
    /* Post: If, before this call, this BST object contained an element equal
     *       to o, then an element equal to o has been removed from this BST
     *       object.
     */
    //O(log n)
    public void remove (Object o) {
        root = removeAux(root, o);
        size--;
    }
    private Node<E> removeAux(Node<E> curr, Object o) {
    	int comp=((Comparable)(E)o).compareTo(curr.element);
    	if(root==null) {
    		return null;
    	}
    	else if(comp<0) {
    		curr.left=removeAux(curr.left, o);
    	}
    	else if(comp>0) {
    		curr.right=removeAux(curr.right, o);
    	}
    	else {
    		if(curr.right==null) {
    			return curr.left;
    		}
    		else if(curr.left==null) {
    			return curr.right;
    		}
    		else {
    			curr.element = (getMin(curr.right)).element;
    			curr.right=removeAux(curr.right, curr.element);		
    		}
    	}
    	return curr;
   
    	
    }


    /**
     * Post: if nd has a successor, that successor Node has been
     *       returned.  Otherwise, null has been returned.
     */
    protected Node<E> successor(Node<E> nd) {
        if (nd == null) {
            return null;
        }
        else if (nd.right != null) {
            // successor is leftmost Node in right subtree of nd
            Node<E> p = nd.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        else {
            // go up the tree to the left as far as possible, then go up
            // to the right once.
            Node<E> p = nd.parent;
            Node<E> ch = nd;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }


    /********************************************
     * Some extra useful methods . . .
     */

    // Pictorial representation of a BST, using in order traversal.
    public void display() {
        displayAux(root, 0);
    }
    private void displayAux(Node<E> nd, int level) {
        if (nd != null) {
            displayAux(nd.left, level + 1);
            for (int i = 0; i <= level; i++) {
                System.out.print("   ");
            }
            System.out.println(nd.element);
            displayAux(nd.right, level + 1);
        }
    }


    // Using breadth-first traversal...
    public void levelOrderPrint() {
        System.out.println("\nLevel-order print. . .");
        Queue<Node<E>> q = new LinkedList<Node<E>>();
        q.add(root);
        while(!q.isEmpty()) {
        	Node<E> n = q.poll();
        	System.out.print(n+" ");
        	if(n.left!=null&&n.right!=null) {
        		q.add(n.left);
        		q.add(n.right);
        	}
        	else if(n.left!=null) {
        		q.add(n.left);
        	}
        	else if(n.right!=null) {
        		q.add(n.right);
        	}
        }
    }
    
    public double numNodes(Node<E> nd) { //returns the number of leaf nodes in the tree
   	 if(nd == null)  {     
   		    return 0;
   	 }
   	 else if(nd.left==null && nd.right==null) {
   		    return 1;            
   		  }
   		  else {
   		    return numNodes(nd.left) + numNodes(nd.right); 
   		  }
   		}

    
    public double heightNodes(Node<E> nd) { //returns the sum of all the leaf nodes heights
    	 if(nd == null)  {     
    		    return 0;
    	 }
    	 else if(nd.left==null && nd.right==null) {
    		    return 1;            
    		  }
    		  else {
    		    return 1 + heightNodes(nd.left) + heightNodes(nd.right); 
    		  }
    		}
    
    
    public double averageHeight() { //returns average height of leaf nodes
    	if(root==null) {
    		return -1.0;
    	}
    	else {
    		return heightNodes(root)/numNodes(root);
    	}
    }
    
   
    	
    
    public int sumUp() {
    	return sumUpAux(root);
    	}
    
    	private int sumUpAux(Node<E> nd) {
    		if(nd.left==null && nd.right==null) {
    			return (Integer)nd.element;
    		}
    		else if(nd.left!=null && nd.right!=null) {
    			nd.element = (E) new Integer ((Integer)nd.element + sumUpAux(nd.left) + sumUpAux(nd.right));
    			return (Integer)nd.element;
    		}
    		else if(nd.left!=null) {
    			nd.element = (E) new Integer((Integer)nd.element + sumUpAux(nd.left));
    			return (Integer)nd.element;
    		}
    		else if(nd.right!=null) {
    			nd.element = (E) new Integer((Integer)nd.element + sumUpAux(nd.right));
    			return (Integer)nd.element;
    		}
    		return (Integer)root.element;
    	
    	}
    

    /********************************************
     * Inner classes
     */
    
    protected static class Node<E> {
        E element;
        Node<E> left = null;
        Node<E> right = null;
        Node<E> parent;

        // Post: this Node has been initialized from element and parent.
        Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
        public String toString() {
            return "" + element;
        }
    }
    
    protected class TreeIterator implements Iterator<E> {

        protected Node<E> lastReturned = null;
        protected Node<E> next;
       
    
        // Post: next has been initialized to the smallest
        //       Node in this BSTRec.
        public TreeIterator() {
            next=getMin(root);
        }


        // Post: true has been returned if this TreeIterator
        //       is not positioned beyond the end of the
        //       binary search tree.  Otherwise, false
        //       has been returned.
        public boolean hasNext() {
            return next!=null;
        }


        // Post: the next element in the binary search tree
        //       has been returned.
        public E next() {
        	if(next!=null) {
        		
        	 E theElement = next.element;
             next = successor(next);
           //  System.out.println(next.element);
             return theElement;
        	}
        	return null;
        }

        
        // Pre:  the element that was last returned by this
        //       TreeIterator is still in the BinSearchTree. 
        // Post: the element last returned by this TreeIterator
        //       has been removed from the binary search tree.
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    public static void main(String[] args) {
        BSTRec<Integer> t1 = new BSTRec<Integer>();
        int i1 = 33; int i2 = 22; int i3 = 11; int i4 = 48;
        int i5 = 40; int i6 = 30; int i7 = 28;
        t1.add(i1);
        t1.add(i2);
        t1.add(i3);
        t1.add(i4);
        t1.add(i5);
        t1.add(i6);
        t1.add(i7);
        t1.display();

        System.out.println("size = " + t1.size());
        System.out.println("contains(28) = " + t1.contains(28));
        System.out.println("contains(i6) = " + t1.contains(i6));
        System.out.println("contains(46) = " + t1.contains(46));
        
        Node<Integer> min = t1.getMin(t1.getRoot());
        System.out.println("min = " + min);

        System.out.println("\nWith an iterator: . . . . . . . . . . .");
        Iterator<Integer> itr = t1.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        } 
    
        t1.display();
        System.out.println("\nremove: . . . . . . . . . . .");
        t1.remove(33);
        System.out.println("after 33 has been removed");
        t1.display();
        t1.remove(30);
        System.out.println("after 30 has been removed");
        t1.display();
        t1.remove(28);
        System.out.println("after 28 has been removed");
        t1.display();
        
        System.out.println("size = " + t1.size());

        t1.clear();
        System.out.println("after clear, size = " + t1.size());
        
        t1.add(i1);
        t1.add(i2);
        t1.add(i3);
        t1.add(i4);
        t1.add(i5);
        t1.add(i6);
        t1.add(i7);
        t1.display();
        System.out.println("\nlevelOrderPrint: . . . . . . . . . . .");
        t1.levelOrderPrint();
        System.out.println("size = " + t1.size());
        t1.display();
        System.out.println("sumUp and new display: ");
        System.out.println(t1.sumUp());
        t1.display();
        System.out.println(t1.numNodes(t1.root));
        System.out.println(t1.heightNodes(t1.root));
        System.out.println(t1.averageHeight());
    }
}