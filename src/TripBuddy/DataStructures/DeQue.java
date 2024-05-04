package TripBuddy.DataStructures;

public class DeQue<E> extends Queue<E> {
    public void enqueueFront(E data) {
        queue.addFirst(data);
    }

    public void dequeueRear() {
        queue.removeLast();
    }
}
