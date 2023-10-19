import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
 */
public class LinkedList {

    /**
     * Constructs an empty linked list.
     */
    private Node first;

    public LinkedList() {
        this.first = null;
    };

    /**
     * Returns the first element in the linked list.
     * 
     * @return the first element in the linked list
     */
    public Object getFirst() {
        if (this.first == null)
            throw new NoSuchElementException();

        return this.first.data;
    }

    /**
     * Removes the first element in the linked list.
     * 
     * @return the removed element
     */

    public void addFirst(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.n
    }

    /**
     * Adds an element to the front of the linked list.
     * 
     * @param element the element to add
     */

    /**
     * Returns an iterator for iterating through this list.
     * 
     * @return an iterator for iterating through this list
     */

    // Class Node
    static class Node {
        public object Data;
        public Node next;
    }

    class LinkedListIterator // implements ListIterator
    {
        // private data
        private Node position;
        private Node previous;
        private boolean isAfterNext;

        /**
         * Constructs an iterator that points to the front
         * of the linked list.
         */

        /**
         * Moves the iterator past the next element.
         * 
         * @return the traversed element
         */

        /**
         * Tests if there is an element after the iterator position.
         * 
         * @return true if there is an element after the iterator position
         */
        public boolean hasNext() {
            return (position == null) ? false : (first != null);
        }

        /**
         * Adds an element before the iterator position
         * and moves the iterator past the inserted element.
         * 
         * @param element the element to add
         */

        /**
         * Removes the last traversed element. This method may
         * only be called after a call to the next() method.
         */

        /**
         * Sets the last traversed element to a different value.
         * 
         * @param element the element to set
         */

    }// LinkedListIterator
}// LinkedList
