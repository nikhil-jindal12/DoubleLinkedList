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

        if (current.getNext() != null && current.getNext().getNext() != null) {
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
            current.setNext(current.getNext().getNext());
            current.setPrev(current.getNext().getPrev());
            current.getNext().setPrev(current);
            current.getPrev().setNext(current);
        } else {
            
        }
    }
    
}

