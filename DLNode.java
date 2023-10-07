/**
 * Class that contains the implementation of a doubly linked list node
 * @author Nikhil Jindal
 */
public class DLNode <T> {
    
    // instance field that holds the element in the node
    private T element;

    // instance field that holds a pointer to the next node
    private DLNode<T> next;
    
    // instance field that holds a pointer to the previous node
    private DLNode<T> prev;

    /**
     * Constructor for DLNode
     * @param element  the element to be stored in the node
     * @param next  the pointer to the next node
     * @param prev  the pointer to the previous node
     */
    public DLNode(T element, DLNode<T> next, DLNode<T> prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    /**
     * Returns the element stored in the node
     * @return the element stored in the node
     */
    public T getElement() {
        return element;
    }

    /**
     * Sets the element stored in the node
     * @param element  the element to be stored in the node
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Returns the pointer to the next node
     * @return the pointer to the next node
     */
    public DLNode<T> getNext() {
        return next;
    }

    /**
     * Sets the pointer to the next node
     * @param next  the pointer to the next node
     */
    public void setNext(DLNode<T> next) {
        this.next = next;
    }

    /**
     * Returns the pointer to the previous node
     * @return the pointer to the previous node
     */
    public DLNode<T> getPrev() {
        return prev;
    }

    /**
     * Sets the pointer to the previous node
     * @param prev  the pointer to the previous node
     */
    public void setPrev(DLNode<T> prev) {
        this.prev = prev;
    }

}
