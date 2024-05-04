package TripBuddy.DataStructures.Modified;

import TripBuddy.DataStructures.AVL;
import TripBuddy.DataStructures.ArrayList;
import TripBuddy.Records.Cruises;

public class AVL_cruises extends AVL<Cruises> {
    public AVL_cruises(ArrayList<Cruises> cruises) {
        super(cruises);
    }

    public Cruises searchByName(String name) {
        return searchByName(root, name);
    }

    private Cruises searchByName(Node<Cruises> node, String name) {
        if (node == null) {
            return null;
        } else if (node.data.getName().equalsIgnoreCase(name)) {
            return node.data;
        } else if (node.data.getName().compareTo(name) > 0) {
            return searchByName(node.left, name);
        } else {
            return searchByName(node.right, name);
        }
    }

    @Override
    public String toString() {
        return toString(root, 0);
    }

    private String toString(Node<Cruises> node, int level) {
        StringBuilder result = new StringBuilder();
        if (node == null) {
            return "";
        }

        result.append(toString(node.right, level + 1));
        if (level == 0) {
            result.append("|").append(node.data.getName()).append("|\n");
        } else {
            result.append("|\t\t\t".repeat(Math.max(0, level - 1)));
            result.append("|---->|").append(node.data.getName()).append("|\n");
        }
        result.append(toString(node.left, level + 1));

        return result.toString();
    }
}
