package com.shashtra.datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/***************
 **   @author: Hariom Singh
 **  Date: 27/02/22
 *****************/
class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    public BinaryTree(int val) {
        root = new Node(val);
    }

    BinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree myTree = new BinaryTree(0);
        myTree.insert(1);
        myTree.insert(2);
        myTree.printTree();
        myTree.insert(3);
        myTree.insert(4);
        myTree.printTree();
    }

    void insert(int val) {
        Node new_node = new Node(val);
        if (root == null) {
            root = new_node;
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.left == null) {
                temp.left = new_node;
                break;
            } else
                q.add(temp.left);
            if (temp.right == null) {
                temp.right = new_node;
                break;
            } else
                q.add(temp.right);
        }
    }

    void printTree() {
        System.out.println("Inorder tree traversal:");
        inorder(root);
        System.out.println("\n======================");

    }

    private void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}
