package de.dhbwka.java.exercise.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinaryTree<T extends Comparable<T>> {
    private Node root;

    private class Node {
        private final T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }
    }

    public boolean add(T newValue) {
        if (root == null) {
            root = new Node(newValue);
            return true;
        } else {
            return addRecursive(root, newValue);
        }
    }

    private boolean addRecursive(Node current, T newValue) {
        if (newValue.equals(current.value)) {
            return false; // Value already exists in the tree
        }

        if (newValue.compareTo(current.value) < 0) {
            if (current.left == null) {
                current.left = new Node(newValue);
                return true;
            } else {
                return addRecursive(current.left, newValue);
            }
        } else {
            if (current.right == null) {
                current.right = new Node(newValue);
                return true;
            } else {
                return addRecursive(current.right, newValue);
            }
        }
    }

    public T getValue() {
        if (root == null) {
            return null;
        }
        return root.value;
    }

    public List<T> traverse() {
        List<T> result = new ArrayList<>();
        traverseRecursive(root, result);
        return result;
    }

    private void traverseRecursive(Node current, List<T> result) {
        if (current != null) {
            traverseRecursive(current.left, result);
            result.add(current.value);
            traverseRecursive(current.right, result);
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        // Füge 10 Zufallszahlen ein
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(100);
            System.out.println("Einfügen: " + randomNumber + ", Erfolg: " + tree.add(randomNumber));
        }

        // Traversiere den Baum
        List<Integer> values = tree.traverse();

        // Gib die Werte auf der Konsole aus
        System.out.println("Traversierung:");
        for (int value : values) {
            System.out.println(value);
        }
    }
}