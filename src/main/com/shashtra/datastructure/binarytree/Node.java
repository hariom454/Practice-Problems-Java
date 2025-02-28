package com.shashtra.datastructure.binarytree;

/**
 * Tree Node: each node in tree contains a value and pointer to left and right child
 */
public class Node {

  int val;
  Node left, right;

  public Node(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }

}
