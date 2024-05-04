package TripBuddy.DataStructures;

public class Stack<E> {
    LinkedList<E> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    public void push(E data) {
        stack.addFirst(data);
    }

    public E pop() {
        return stack.removeFirst();
    }

    public E peek() {
        if (stack.isEmpty())
            return null;
        return stack.head.data;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public String toString() {
        return stack.toString();
    }
}
