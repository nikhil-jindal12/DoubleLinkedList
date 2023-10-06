public class DoubleLinkedList<T> {
    private DLNode<T> head;
    private DLNode<T>tail;

    public DoubleLinkedList() {
        head = tail = null;
    }

    public DLNode<T> getHead() {
        return head;
    }

    public void setHead(DLNode<T> head) {
        this.head = head;
    }

    public DLNode<T> getTail() {
        return tail;
    }

    public void setTail(DLNode<T> tail) {
        this.tail = tail;
    }

    public void add(DLNode<T> node) {
        if (head == null) {
            head = tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
    }

    public void remove(DLNode<T> node) {
        if (node.getNext() != null) {
            if (node == head) {
                head = node.getNext();
            } else if (tail == node) {
                tail = node.getPrev();
            } else {
                node.getNext().setPrev(node.getPrev());
                node.getPrev().setNext(node.getNext());
            }
        }
    }

    public void successorSwap(DLNode<T> node) {
        DLNode<T> current = head;
        while (current != node || current.getNext() != null) {
            current = current.getNext();
        }

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

