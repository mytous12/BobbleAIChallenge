package com.company;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class Tree implements Serializable {
    private static final long serialVersionUID = 10L;
    private Node root;

    static class Node implements Serializable {
        String data;
        Node left;
        Node right;

        public Node(String data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    void insert(String data) {
        root = insert(root, data);
    }

    private Node insert(Node root, String data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (root.data.compareTo(data) > 0) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }

        preOrder(root.left);
        System.out.println(root.data);
        preOrder(root.right);
    }

    void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }
}
