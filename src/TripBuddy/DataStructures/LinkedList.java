package TripBuddy.DataStructures;

public class LinkedList<E> {

    Node<E> head;
    Node<E> tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public Node<E> getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    /**
     * Adds the given data to the end of the linked list
     *
     * @param data Data to be added
     */
    public void addLast(E data) {
        if (head == null) {
            head = new Node<>(data);
            tail = head;
        } else {
            tail.next = new Node<>(data);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Adds the given data to the beginning of the linked list
     *
     * @param data Data to be added
     */
    public void addFirst(E data) {
        if (head == null) {
            head = new Node<>(data);
            tail = head;
        } else {
            Node<E> temp = new Node<>(data);
            temp.next = head;
            head = temp;
        }
        size++;
    }

    /**
     * Removes the first element from the linked list
     *
     * @return The removed element
     */
    public E removeFirst() {
        if (head == null) {
            return null;
        } else {
            E data = head.data;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            size--;
            return data;
        }
    }

    /**
     * Removes the last element from the linked list
     *
     * @return The removed element
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        E data = tail.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node<E> temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
        }
        size--;
        return data;
    }

    /**
     * Removes the element at the given index
     *
     * @param data Data to be removed
     */
    public void remove(E data) {
        if (!isEmpty()) {
            if (head.data == data) {
                removeFirst();
                return;
            }
            Node<E> temp = head;
            while (temp.next != null) {
                if (temp.next.data.equals(data)) {
                    temp.next = temp.next.next;
                    size--;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> temp = head;
        while (temp != null) {
            sb.append(temp.data);
            temp = temp.next;
            if (temp != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Node class for the linked list
     *
     * @param <E> Type of data to be stored in the node
     */
    public static class Node<E> {
        public E data;
        public Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
