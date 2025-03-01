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

    // test mirror functionality
    Node tempRoot = bst.insert(null, 4);
    tempRoot = bst.insert(tempRoot, 2);
    tempRoot = bst.insert(tempRoot, 1);
    tempRoot = bst.insert(tempRoot, 3);
    tempRoot = bst.insert(tempRoot, 5);

    System.out.println("Initial tree inorder traversal: ");
    bst.printTree(tempRoot);
    System.out.println();

    bst.doubleTree(tempRoot);
    System.out.println("tree after double root: ");
    bst.printTree(tempRoot);
    System.out.println();

    System.out.println(
        "Structurally distinct trees: for n = " + 2 + " count is: " + bst.countTrees(2));
    System.out.println(
        "Structurally distinct trees: for n = " + 3 + " count is: " + bst.countTrees(3));
    System.out.println(
        "Structurally distinct trees: for n = " + 4 + " count is: " + bst.countTrees(4));
    System.out.println(
        "Structurally distinct trees: for n = " + 8 + " count is: " + bst.countTrees(8));

    System.out.println("isBST1: " + bst.isBST1(root));
    System.out.println("isBST1: " + bst.isBST1(tempRoot));

    System.out.println("isBST2: " + bst.isBST2(root));
    System.out.println("isBST2: " + bst.isBST2(tempRoot));

    bst.mirror(tempRoot);
    System.out.println("Mirror tree inorder traversal: ");
    bst.printTree(tempRoot);
    System.out.println();

    System.out.println("is BST after mirror?: " + bst.isBST2(tempRoot));


  }

}
