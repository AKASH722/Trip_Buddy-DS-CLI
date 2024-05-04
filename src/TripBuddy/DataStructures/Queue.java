package TripBuddy.DataStructures;

public class Queue<E> {
    LinkedList<E> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    public void enqueue(E data) {
        queue.addLast(data);
    }

    public E dequeue() {
        return queue.removeFirst();
    }

    public E getFront() {
        if (queue.isEmpty())
            return null;
        return queue.head.data;
    }

    public E getRear() {
        if (queue.isEmpty())
            return null;
        return queue.tail.data;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public String toString() {
        return queue.toString();
    }
}
