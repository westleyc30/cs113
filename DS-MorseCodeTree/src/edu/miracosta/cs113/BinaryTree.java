package edu.miracosta.cs113;

import java.io.Serializable;

public class BinaryTree<E> implements Serializable{
    protected static class Node<E> implements Serializable {
        // Data Fields
        /** The information stored in this node. */
        protected E data;
        /** Reference to the left child */
        protected Node<E> left;
        protected Node<E> right;

        /** Construct a node with the given data and no children.
         * @param data The data to store in this node
         */
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
        // Methods
        public String toString() {
            return data.toString();
        }
    }

    // Data Field
    protected Node<E> root;

    // Constructors
    public BinaryTree() {
        root = null;
    }

    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        root = new Node<>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }

        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

}
