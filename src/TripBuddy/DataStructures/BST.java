package TripBuddy.DataStructures;

public class BST<E extends Comparable<E>> {
    Node<E> root;

    public BST() {
        root = null;
    }

    public void generate(E[] values) {
        for (E value : values) {
            add(value);
        }
    }

    public void add(E value) {
        if (root == null) {
            root = new Node<>(value);
        } else {
            add(root, value);
        }
        System.out.println(value + " added in the tree");
    }

    private void add(Node<E> node, E value) {
        if (compareTo(node.data, value)) {
            if (node.left == null) {
                node.left = new Node<>(value);
            } else {
                add(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(value);
            } else {
                add(node.right, value);
            }
        }
    }

    boolean compareTo(E i, E j) {
        return i.compareTo(j) > 0;
    }

    public void remove(E value) {
        if (search(value)) {
            remove(root, null, value, true);
        } else {
            System.out.println("value not found");
        }
    }

    private void remove(Node<E> node, Node<E> parent, E value, boolean leftChild) {
        if (node == null) {
            return;
        }
        if (node.data.equals(value)) {
            if (parent == null) {
                if (node.left == null && node.right == null) {
                    root = null;
                } else if (node.left == null) {
                    root = node.right;
                } else if (node.right == null) {
                    root = node.left;
                } else {
                    Node<E> n = getNode(node.right);
                    n.left = node.left;
                    n.right = node.right;
                    root = n;
                }
            } else {
                if (node.left == null && node.right == null) {
                    if (leftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else if (node.left == null) {
                    if (leftChild) {
                        parent.left = node.right;
                    } else {
                        parent.right = node.right;
                    }
                } else if (node.right == null) {
                    if (leftChild) {
                        parent.left = node.left;
                    } else {
                        parent.right = node.left;
                    }
                } else {
                    Node<E> n = getNode(node.right);
                    n.left = node.left;
                    n.right = node.right;
                    if (leftChild) {
                        parent.left = n;
                    } else {
                        parent.right = n;
                    }
                }
            }
        } else if (compareTo(node.data, value)) {
            remove(node.left, node, value, true);
        } else {
            remove(node.right, node, value, false);
        }
    }

    private Node<E> getNode(Node<E> node) {
        //returns and deletes the smallest node to the right of the given node
        if (node.left == null) {
            remove(node.data);
            return node;
        } else {
            return getNode(node.left);
        }
    }

    public boolean search(E value) {
        if (root.data.equals(value)) {
            return true;
        } else if (compareTo(root.data, value)) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    private boolean search(Node<E> node, E value) {
        if (node == null) {
            return false;
        } else if (node.data.equals(value)) {
            return true;
        } else if (compareTo(node.data, value)) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    public String toString() {
        return toString(root, 0);
    }

    private String toString(Node<E> node, int level) {
        StringBuilder result = new StringBuilder();
        if (node == null) {
            return "";
        }

        result.append(toString(node.right, level + 1));
        if (level == 0) {
            result.append("|").append(node.data).append("|\n");
        } else {
            result.append("|\t\t".repeat(Math.max(0, level - 1)));
            result.append("|----->|").append(node.data).append("|\n");
        }
        result.append(toString(node.left, level + 1));

        return result.toString();
    }

    public static class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;

        Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}

