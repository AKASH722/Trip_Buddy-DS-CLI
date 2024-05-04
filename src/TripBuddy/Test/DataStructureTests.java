package TripBuddy.Test;

import TripBuddy.DataStructures.*;

public class DataStructureTests {

    public static void main(String[] args) {
        testLinkedList();
        testQueue();
        testStack();
        testHashtable();
        testBST();
        testAVLTree();
        testArrayList();
    }

    private static void testLinkedList() {
        System.out.println("Testing LinkedList:");

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        System.out.println("LinkedList: " + linkedList);

        int removedFirst = linkedList.removeFirst();
        System.out.println("Removed First: " + removedFirst);
        System.out.println("LinkedList after removing first: " + linkedList);
    }

    private static void testQueue() {
        System.out.println("\nTesting Queue:");

        Queue<String> queue = new Queue<>();
        queue.enqueue("Alice");
        queue.enqueue("Bob");
        queue.enqueue("Charlie");

        System.out.println("Queue: " + queue);

        String front = queue.getFront();
        System.out.println("Front of the Queue: " + front);

        String dequeued = queue.dequeue();
        System.out.println("Dequeued: " + dequeued);
        System.out.println("Queue after dequeuing: " + queue);
    }

    private static void testStack() {
        System.out.println("\nTesting Stack:");

        Stack<Double> stack = new Stack<>();
        stack.push(3.14);
        stack.push(2.71);
        stack.push(1.0);

        System.out.println("Stack: " + stack);

        Double popped = stack.pop();
        System.out.println("Popped: " + popped);

        Double peeked = stack.peek();
        System.out.println("Peeked: " + peeked);
        System.out.println("Stack after popping and peeking: " + stack);
    }

    private static void testHashtable() {
        System.out.println("\nTesting Hashtable:");

        Hashtable<String, Integer> hashtable = new Hashtable<>(10);
        hashtable.put("one", 1);
        hashtable.put("two", 2);
        hashtable.put("three", 3);
        hashtable.put("three", 4);

        System.out.println("Hashtable: " + hashtable);

        Integer value = hashtable.get("two");
        System.out.println("Value associated with key 'two': " + value);
    }

    private static void testBST() {
        System.out.println("\nTesting Binary Search Tree (BST):");

        BST<Integer> bst = new BST<>();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);

        System.out.println("BST:\n" + bst);
        System.out.println("Searching for value 7: " + bst.search(7));
    }

    private static void testAVLTree() {
        System.out.println("\nTesting AVL Tree:");

        AVL<Integer> avlTree = new AVL<>();
        avlTree.add(10);
        avlTree.add(20);
        avlTree.add(30);
        avlTree.add(40);
        avlTree.add(50);
        avlTree.add(25);
        avlTree.add(1);
        avlTree.add(0);

        System.out.println("AVL Tree:\n" + avlTree);

        System.out.println("Removing 0 from AVL Tree");
        avlTree.remove(0);

        System.out.println("AVL Tree after removal:\n" + avlTree);
    }

    private static void testArrayList() {
        System.out.println("\nTesting ArrayList:");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Alice");
        arrayList.add("Bob");
        arrayList.add("Charlie");

        System.out.println("ArrayList: " + arrayList);

        String removed = arrayList.remove(1);
        System.out.println("Removed element at index 1: " + removed);
        System.out.println("ArrayList after removal: " + arrayList);
    }
}
