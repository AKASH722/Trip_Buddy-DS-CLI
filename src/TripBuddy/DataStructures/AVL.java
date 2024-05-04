package TripBuddy.DataStructures;

public class AVL<E extends Comparable<E>> {
    protected Node<E> root;
    private boolean isBalanced;

    /**
     * Constructor for AVL
     *
     * @param list List of elements to be added to the AVL
     */
    public AVL(ArrayList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    public AVL() {
        root = null;
    }

    /**
     * Searches for the given value in the AVL
     *
     * @param value Value to be searched
     * @return true if the value is found, false otherwise
     */
    public boolean search(E value) {
        return search(root, value);
    }

    private boolean search(Node<E> node, E value) {
        if (node == null) {
            return false;
        } else if (node.data.equals(value)) {
            return true;
        } else if (node.data.compareTo(value) > 0) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    /**
     * Adds the given value to the AVL
     *
     * @param value Value to be added
     */

    public void add(E value) {
        if (root == null) {
            root = new Node<>(value);
        } else {
            add(root, value);
        }

    }

    private void add(Node<E> node, E value) {
        if (node.data.compareTo(value) > 0) {
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
        calculateBalanceFactor(root);
        if (!isBalanced)
            balance(root, null, true);
    }

    /**
     * Removes the given value from the AVL
     *
     * @param value Value to be removed
     * @return The removed value
     */
    public E remove(E value) {
        return remove(value, true);
    }

    private E remove(E value, boolean balance) {
        E data = remove(root, null, value, true);
        if (balance) {
            calculateBalanceFactor(root);
            if (!isBalanced)
                balance(root, null, true);
        }
        return data;
    }

    private E remove(Node<E> node, Node<E> parent, E value, boolean leftChild) {
        if (node == null) {
            return null;
        } else if (node.data.equals(value)) {
            E data = node.data;
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
            return data;
        } else if (node.data.compareTo(value) > 0) {
            return remove(node.left, node, value, true);
        } else {
            return remove(node.right, node, value, false);
        }
    }

    /**
     * Returns the smallest node to the right of the given node
     *
     * @param node Node to be searched
     * @return The smallest node to the right of the given node
     */
    private Node<E> getNode(Node<E> node) {
        //returns and deletes the smallest node to the right of the given node
        if (node.left == null) {
            remove(node.data, false);
            return node;
        } else {
            return getNode(node.left);
        }
    }

    /**
     * Balances the AVL
     *
     * @param node      Node to be balanced
     * @param parent    Parent of the node
     * @param leftChild true if the node is a left child, false otherwise
     */
    private void balance(Node<E> node, Node<E> parent, boolean leftChild) {
        if (node == null) {
            return;
        }
        balance(node.left, node, true);
        balance(node.right, node, false);
        if (node.balFactor > 1) {
            if (node.left.balFactor >= 0) {
                //Right
                rotateRight(node, parent, leftChild);
            } else {
                //Left-Right
                rotateLeft(node.left, node, true);
                rotateRight(node, parent, leftChild);
            }
        } else if (node.balFactor < -1) {
            if (node.right.balFactor <= 0) {
                //Left
                rotateLeft(node, parent, leftChild);
            } else {
                //Right-Left
                rotateRight(node.right, node, false);
                rotateLeft(node, parent, leftChild);
            }
        }
        calculateBalanceFactor(root);
    }

    /**
     * Rotates the given node to the left
     *
     * @param node   Node to be rotated
     * @param parent Parent of the node
     * @param left   true if the node is a left child, false otherwise
     */
    private void rotateLeft(Node<E> node, Node<E> parent, boolean left) {
        Node<E> b = node.right;
        node.right = b.left;
        b.left = node;
        if (parent == null) {
            root = b;
        } else if (left) {
            parent.left = b;
        } else {
            parent.right = b;
        }
    }

    /**
     * Rotates the given node to the right
     *
     * @param node   Node to be rotated
     * @param parent Parent of the node
     * @param left   true if the node is a left child, false otherwise
     */
    private void rotateRight(Node<E> node, Node<E> parent, boolean left) {
        Node<E> b = node.left;
        node.left = b.right;
        b.right = node;
        if (parent == null) {
            root = b;
        } else if (left) {
            parent.left = b;
        } else {
            parent.right = b;
        }
    }

    /**
     * Calculates the balance factor of each node in the AVL
     *
     * @param node Node to be calculated
     */
    private void calculateBalanceFactor(Node<E> node) {
        if (node == null) {
            return;
        }
        node.balFactor = height(node.left) - height(node.right);
        if (node.balFactor > 1 || node.balFactor < -1) {
            isBalanced = false;
        }
        calculateBalanceFactor(node.left);
        calculateBalanceFactor(node.right);
    }

    /**
     * Returns the height of the given node
     *
     * @param node Node to be calculated
     * @return Height of the given node
     */
    private int height(Node<E> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
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
            result.append("|\t\t\t".repeat(Math.max(0, level - 1)));
            result.append("|---->|").append(node.data).append("|\n");
        }
        result.append(toString(node.left, level + 1));

        return result.toString();
    }

    /**
     * Node class for AVL
     *
     * @param <E> Type of data to be stored in the node
     */
    public static class Node<E> {
        public E data;
        public Node<E> left;
        public Node<E> right;
        int balFactor;

        Node(E data) {
            this.data = data;
            this.balFactor = 0;
            this.left = null;
            this.right = null;
        }
    }
}
