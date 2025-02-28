package com.shashtra.datastructure.binarytree;

public class BstTester {

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    //create tree with node 2, 1, 3
    Node root = bst.insert(null, 2);
    root = bst.insert(root, 1);
    root = bst.insert(root, 3);

    bst.printTree(root);
    //search for 3, 4
    System.out.printf("\nSearch for %s and result is: %b\n", 3, bst.search(root, 3));
    System.out.printf("Search for %s and result is: %b\n", 4, bst.search(root, 4));

    bst.printPaths(root);

  }

}
