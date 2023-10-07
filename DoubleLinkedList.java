/**
 * Class that implements a double linked list (DLL)
 * @author Nikhil Jindal
 */
public class DoubleLinkedList<T> {
    
    // an instance field representing the head of the DLL
    private DLNode<T> head;

    // an instance field representing the tail of the DLL
    private DLNode<T>tail;

    // constructor
    public DoubleLinkedList() {
        head = tail = null;
    }

    /**
     * Returns the head of the DLL
     * @return head of the DLL
     */
    public DLNode<T> getHead() {
        return head;
    }

    /**
     * Sets the head of the DLL
     * @param head head of the DLL
     */
    public void setHead(DLNode<T> head) {
        this.head = head;
    }

    /**
     * Returns the tail of the DLL
     * @return tail of the DLL
     */
    public DLNode<T> getTail() {
        return tail;
    }

    /**
     * Sets the tail of the DLL
     * @param tail  tail of the DLL
     */
    public void setTail(DLNode<T> tail) {
        this.tail = tail;
    }

    /**
     * Adds a node to the end of the DLL
     * @param node  node to be added
     */
    public void add(DLNode<T> node) {
        
        if (head == null) {
            // if the list is empty
            head = tail = node;
        } else {
            // if the list is not empty
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
    }

    /**
     * Removes a node from the DLL
     * @param node  node to be removed
     */
    public void remove(DLNode<T> node) {
        if (node.getNext() != null) {
            if (node == head) {
                // if the node is the head of the list
                head = node.getNext();
            } else if (tail == node) {
                // if the node is the tail of the list
                tail = node.getPrev();
            } else {
                // if the node is in the middle of the list
                node.getNext().setPrev(node.getPrev());
                node.getPrev().setNext(node.getNext());
            }
        }
    }

    /**
     * Swaps the successor of a node with the current node
     * @param node  node whose successor is to be swapped
     */
    public void successorSwap(DLNode<T> node) {
        
        // find the node that is inputted
        DLNode<T> current = head;
        while (current != node || current.getNext() != null) {
            current = current.getNext();
        }

        // swap the successor of the current node
        if (current.getPrev() != null && current.getNext() != null && current.getNext().getNext() != null) {
            // with nodes before, after, and two after the current node
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
            current.setNext(current.getNext().getNext());
            current.setPrev(current.getNext().getPrev());
            current.getNext().setPrev(current);
            current.getPrev().setNext(current);
        } else if (current.getNext() != null && current.getNext() == getTail()) {
            // with successor node being the tail
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
            current.getNext().setNext(current);
            current.setPrev(current.getNext());
            current.setNext(null);
            setTail(current);
        } else if (current.getNext() != null && current == getHead() && current.getNext() == getTail()) {
            // with current node being the head and successor node being the tail
            current.setPrev(current.getNext());
            current.getNext().setNext(current);
            current.getNext().setPrev(null);
            current.setNext(null);
            setTail(current);
            setHead(current.getPrev());
        } else if (current.getNext() != null && current == getHead()) {
            // with current node being the head and at least one node in between the head and the tail
            current.setPrev(current.getNext());
            current.setNext(current.getNext().getNext());
            current.getNext().setPrev(current);
            current.getPrev().setNext(current);
            current.getPrev().setPrev(null);
            setHead(current.getPrev());
        }

    }
    
}

