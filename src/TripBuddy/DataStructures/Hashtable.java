package TripBuddy.DataStructures;

public class Hashtable<K, V> {
    private final Node<K, V>[] hashtable;
    private int size;

    /**
     * Constructor for Hashtable
     *
     * @param size Size of the hashtable
     */
    @SuppressWarnings("unchecked")
    public Hashtable(int size) {
        hashtable = new Node[size];
    }

    /**
     * Returns the size of the hashtable
     *
     * @return Size of the hashtable
     */
    public int getSize() {
        return size;
    }

    /**
     * Adds the given key-value pair to the hashtable
     *
     * @param key   Key
     * @param value Value
     */
    public void put(K key, V value) {
        int index = getIndex(key);

        Node<K, V> current = hashtable[index];
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Node<K, V> newNode = new Node<>(key, value);
        if (hashtable[index] == null) {
            hashtable[index] = newNode;
        } else {
            current = hashtable[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Returns the value corresponding to the given key
     *
     * @param key Key
     * @return Value corresponding to the given key  or null if the key is not found
     */
    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> current = hashtable[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    /**
     * Checks if the given key is present in the hashtable
     *
     * @param key Key
     * @return true if the key is present, false otherwise
     */
    public boolean contains(K key) {
        int index = getIndex(key);
        Node<K, V> current = hashtable[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Removes the given key-value pair from the hashtable
     *
     * @param key Key
     * @return Value corresponding to the given key or null if the key is not found
     */
    public V remove(K key) {
        int index = getIndex(key);
        Node<K, V> current = hashtable[index];
        Node<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                V value = current.value;
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    hashtable[index] = current.next;
                }
                size--;
                return value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Node<K, V> node : hashtable) {
            Node<K, V> current = node;
            while (current != null) {
                sb.append(current).append(" , ");
                current = current.next;
            }
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2); // Remove trailing comma and space
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * Returns the index of the given key
     *
     * @param key Key
     * @return Index of the given key
     */
    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % hashtable.length;
    }

    /**
     * Node class for Hashtable
     *
     * @param <K> Type of key
     * @param <V> Type of value
     */
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public String toString() {
            return "[" + key + ", " + value + "]";
        }
    }
}
