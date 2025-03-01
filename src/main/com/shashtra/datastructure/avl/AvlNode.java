package com.shashtra.datastructure.avl;

public class AvlNode {

  int val;
  int height;
  AvlNode left, right;

  public AvlNode(int val) {
    this.val = val;
    left = right = null;
    height = 1;
  }

}
