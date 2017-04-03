import java.util.*;

@SuppressWarnings("unchecked") 
public class BST<E> extends AbstractSet<E> {

    protected Node<E> root;
    protected int size = 0;


    /**
     * Initializes this BST object to be empty, to contain only elements
     * of type E, to be ordered by the Comparable interface, and to
     * contain no duplicate elements.
     */ 
    public BST() {
        this.root = null;
        this.size = 0;
    }


    /**
     * Initializes this BST object to contain a shallow copy of a specified
     * BST object. The worstTime(n) is O(n), where n is the number of
     * elements in the specified BST object.
     *
     * @param otherTree - the specified BST object that this BST object
     *        will be assigned a shallow copy of.
     */
    public BST(BST<E> otherTree) {
        root = null;
        size = 0;
        for (E element : otherTree) {
            this.add(element);
        }
    }


    /**
     * Returns the size of this BST object.
     *
     * @return the size of this BST object.
     *
     */
    public int size() {
        return size;
    }

    /**
     * Returns an iterator positioned at the smallest element in this
     * BST object.
     *
     * @return an iterator positioned at the smallest element in this
     *         BST object.
     */
    public Iterator<E> iterator() {
        return new TreeIterator();
    }

    /**
     * Determines if there is at least one element in this BST object
     * that equals a specified element.  The worstTime(n) is O(n) and
     * averageTime(n) is O(log n).  Note that it is legal for the
     * specified element to be null.
     *
     * @param obj - the element sought in this BST object.
     *
     * @return true - if there is an element in this BST
     *         object that equals obj; otherwise, return false.
     *
     * @throws ClassCastException - if obj cannot be 
     *         compared to the elements in this BST object. 
     * @throws NullPointerException - if obj is null.
     */ 
    public boolean contains(Object obj) {
        if (getNode(obj) == null) {
            return false;
        }
        else {
            return true;
        }
    }
    

    /**
     * Ensures that this BST object contains a specified element.
     * The worstTime(n) is O(n) and averageTime(n) is O(log n).
     *
     * @param element - the element whose presence is ensured
     *        in this BST object.
     *
     * @return true - if this BST object changed as a result
     *         of this method call (that is, if element
     *         was actually inserted); otherwise, return false.
     *
     * @throws ClassCastException - if element cannot be compared
     *         to the elements already in this BST object.
     * @throws NullPointerException - if element is null.
     *
     */
    public boolean add(E element) {        
        if (root == null) {  // empty tree
            root = new Node<E>(element, null);
            size++;
            return true;
        }
        else {
            Node<E> temp = root;
            int comp;
            while (true) {
                comp = ((Comparable)element).compareTo(temp.element);
                if (comp == 0) return false;
                if (comp < 0) {
                    if (temp.left != null) {
                        temp = temp.left;
                    }
                    else {
                        temp.left = new Node<E>(element, temp);
                        size++;
                        return true;
                    }
                }
                else if (temp.right != null) {
                    temp = temp.right;
                }
                else {
                    temp.right = new Node<E>(element, temp);
                    size++;
                    return true;
                }
            } // while
        }
    }
    

    /**
     * Ensures that this BST object does not contain a specified element.
     * The worstTime(n) is O(n) and averageTime(n) is O(log n).
     *
     * @param obj - the object whose absence is ensured in this BST object.
     *
     * @return true - if this BST object changed as a result of this method
     *         call (that is, if obj was actually removed); otherwise,
     *         return false.
     *
     * @throws ClassCastException - if obj cannot be compared to the
     *         elements in this BST object. 
     * @throws NullPointerException - if obj is null.
     *
     */
    public boolean remove(Object obj) {
        Node<E> nd = getNode(obj);
        if (nd == null) {
            return false;
        }
        if (deleteNode(nd) == null) {
            return false;
        }
        return true;
    }

    
    /**
     * Finds the Node object that houses a specified element, if there is
     * such a Node. The worstTime(n) is O(n), and averageTime(n) is O(log n).
     *
     * @param obj - the element whose Node is sought.
     *
     * @return the Node object that houses obj - if there is such a Node;
     *         otherwise, return null.  
     *
     * @throws ClassCastException - if obj is not comparable to the elements
     *         already in this BST object.
     * @throws NullPointerException - if obj is null.
     *
     */
    protected Node<E> getNode(Object obj) {
        int comp;

        Node<E> nd = root;
        while (nd != null) {
            comp = ((Comparable)obj).compareTo(nd.element);
            if (comp == 0) {
                return nd;
            }
            else if (comp < 0) {
                nd = nd.left;
            }
            else {
                nd = nd.right;
            }
        }
        return null;
    }

    /**
     * Finds the successor of a specified Node object in this BST.
     * The worstTime(n) is O(n) and averageTime(n) is O(1).
     * Uses inorder traversal.
     *
     * @param nd - the Node object whose successor is to be found.
     *
     * @return the successor of nd, if nd has a successor;
     *         otherwise, return null.
     */
    protected Node<E> successor(Node<E> nd) {
        if (nd == null) {
            return null;
        }
        else if (nd.right != null) {
            // nd has a right child.  Successor is
            // leftmost Node in right subtree of nd.
            return findMinNode(nd.right);
        }
        else {
            // nd has no right child.  Go up the tree to the left as
            // far as possible, then go up to the right once.
            Node<E> s = nd.parent;
            Node<E> child = nd;
            while ((s != null) && (child == s.right)) {
                child = s;
                s = s.parent;
            }
            return s;
        }
    }

    // find the minimum node starting from a give node
    private Node<E> findMinNode(Node<E> nd) {
        if (nd == null)
            return null;
        while (nd.left != null) {
            nd = nd.left;
        }
        return nd;
    }

    /**
     * Deletes the element in a specified Node object from this BST.
     * 
     * @param p - the Node object whose element is to be deleted from
     *        this BST object.
     *
     * @return the Node object that was actually deleted from this BST object. 
     */
    protected Node<E> deleteNode(Node<E> p) {
        if (p == null) {
            return null;
        }
        // If p has two children, replace p's element with p's successor's
        // element, then make p reference that successor.
        if ((p.left != null) && (p.right != null)) {
            // p had two children
            Node<E> s = successor(p);
            p.element = s.element;
            p = s;  // p will be returned as the return value
        }

        // At this point, p has either 0 or 1 child.
        Node<E> replacement;
        
        if (p.left != null) {
            replacement = p.left;
        }
        else {
            replacement = p.right;
        }

        // If p has at least one child, link replacement to p.parent.
        if (replacement != null) {
            replacement.parent = p.parent;
            if (p.parent == null) {
                root = replacement;
            }
            else if (p == p.parent.left) {
                p.parent.left  = replacement;
            }
            else {
                p.parent.right = replacement;
            }
        }
        else if (p.parent == null) {
            root = null;
        }
        else { // p has a parent but no children
            if (p == p.parent.left)
                p.parent.left = null;
            else
                p.parent.right = null;        
        }
        size--;
        return p;
    }



    /********************************************
     * Some extra useful methods . . .
     */
    
    // Pictorial representation of a BST, using inorder traversal.
    public void display() {
        System.out.println("\nDisplay. . .");
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
        if (root != null) {
            // Use a linked list as a queue...
            Queue<Node> queue = new LinkedList<Node>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                Node<E> front = queue.poll();
                System.out.println(front.element);
                if (front.left != null) {
                    queue.offer(front.left);
                }
                if (front.right != null) {
                    queue.offer(front.right);
                }
            }
        }
        System.out.println();
    }
    

    /********************************************
     * Inner classes
     */
    
    protected class TreeIterator implements Iterator<E> {

        protected Node<E> lastReturned = null;
        protected Node<E> next = null;

        /**
         * Positions this TreeIterator to the smallest element, according
         * to the Comparable interface, in the BST object.  The worstTime(n)
         * is O(n) and averageTime(n) is O(log n).
         */
        protected TreeIterator() {
            next = root;
            if (next != null) {
                while (next.left != null) {
                    next = next.left;
                }
            }
        }

        /**
         * Determines if there are still some elements, in the BST object
         * this TreeIterator object is iterating over, that have not been
         * accessed by this TreeIterator object.
         *
         * @return true - if there are still some elements that have not
         *         been accessed by this TreeIterator object; otherwise,
         *         return false.
         */ 
        public boolean hasNext() {
            return next != null;
        }

        /**
         * Returns the element in the Node this TreeIterator object was
         * positioned at before this call, and advances this TreeIterator
         * object.  The worstTime(n) is O(n) and averageTime(n) is constant.
         *
         * @return the element this TreeIterator object was positioned at
         *         before this call.
         *
         * @throws NoSuchElementException - if this TreeIterator object
         *         was not positioned at an Node before this call.
         */
        public E next() {
            if (next == null) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = successor(next);
            return lastReturned.element;
        }

        /**
         * Removes the element returned by the most recent call to this
         * TreeIterator object's next() method.  The worstTime(n) is O(n)
         * and averageTime(n) is O(1).
         *
         * @throws IllegalStateException - if this TreeIterator's next()
         *         method was not called before this call, or if this 
         *         TreeIterator's remove() method was called between the
         *         call to the next() method and this call.
         */ 
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            if (lastReturned.left != null && lastReturned.right != null) {
                next = lastReturned;//set next to the right place(lastReturned)
                                    //before deleteNode makes current value of
                                    //next an orphan
            }
            deleteNode(lastReturned);
            lastReturned = null;  // to preclude a subsequent call to remove()
                                  // before a call to next().
        }
    } // class TreeIterator


    protected static class Node<E> {
        protected E element;
        protected Node<E> left;
        protected Node<E> right;
        protected Node<E> parent;

        /**
         * Initializes this Node object.
         *
         * This default constructor is defined for the sake of subclasses
         * of the BST class.        
         */
        public Node() {
            this.element = null;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        /**
         * initializes this Node object from element and parent.
         *
         */        
        public Node(E element, Node<E> parent) {
            this.element = element;
            this.left = null;
            this.right = null;
            this.parent = parent;
        }
    } // class Node

}