package com.shashtra.datastructure.avl;

public class AvlTree {

  private static int getHeight(AvlNode node) {
    if (node == null) {
      return 0;
    }
    return node.height;
  }

  private static int getBalanceFactor(AvlNode node) {
    if (node == null) {
      return 0;
    }
    //0 - if balanced
    //>1 - if left heavy
    //<-1 - if right heavy
    return getHeight(node.left) - getHeight(node.right);
  }

  static AvlNode leftRotate(AvlNode A) {
    AvlNode B = A.right;
    AvlNode t2 = B.left;

    B.left = A;
    A.right = t2;

    A.height = 1 + Math.max(getHeight(A.left), getHeight(A.right));
    B.height = 1 + Math.max(getHeight(B.left), getHeight(B.right));

    return B;
  }

  static AvlNode rightRotate(AvlNode A) {

    AvlNode B = A.left;
    AvlNode t2 = B.right;
    B.right = A;
    A.left = t2;

    A.height = 1 + Math.max(getHeight(A.left), getHeight(A.right));
    B.height = 1 + Math.max(getHeight(B.left), getHeight(B.right));

    return B;
  }

  private static AvlNode insert(AvlNode root, int val) {
    if (root == null) {
      return new AvlNode(val);
    }

    if (val > root.val) {
      root.right = insert(root.right, val);
    } else {
      root.left = insert(root.left, val);
    }
    root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

    int balanceFactor = getBalanceFactor(root);
    //right rotation if left left heavy
    //left right rotation if left right heavy
    if (balanceFactor > 1) {
      //new node is inserted in left side -> left heavy
      if (val < root.left.val) {
        return rightRotate(root);
      } else if (val > root.left.val) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
      }
    }
    //left rotation if right right heavy
    //right left rotation if right left heavy
    else if (balanceFactor < -1) {
      if (val > root.right.val) {
        return leftRotate(root);
      } else if (val < root.right.val) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
      }

    }
    return root;
  }

  private static void preOrder(AvlNode node) {
    if (node == null) {
      return;
    }
    System.out.print(node.val + " ");
    preOrder(node.left);
    preOrder(node.right);
  }

  private static boolean search(AvlNode root, int val) {
    if (root == null) {
      return false;
    }

    AvlNode temp = root;
    while (temp != null) {
      if (temp.val == val) {
        return true;
      }
      if (val > temp.val) {
        temp = temp.right;
      } else {
        temp = temp.left;
      }
    }
    return false;
  }

  public static void main(String[] args) {

    AvlNode root = null;
    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 30);
    root = insert(root, 40);
    root = insert(root, 50);
    root = insert(root, 25);

    preOrder(root);
    System.out.println();
    System.out.println("Key: " + 30 + " is present? " + search(root, 30));
    System.out.println("Key: " + 60 + " is present? " + search(root, 60));

    root = insert(root, 60);
    root = insert(root, 80);
    root = insert(root, 90);
    preOrder(root);
    System.out.println();
    System.out.println("Key: " + 60 + " is present? " + search(root, 60));


  }

}
