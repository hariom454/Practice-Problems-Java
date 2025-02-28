package com.shashtra.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

  public BinarySearchTree() {
  }

  /**
   * Insert given value at appropriate place in given binary search tree
   *
   * @param root root node of the bst
   * @param val  new value to be insert in bst
   * @return root node
   */
  Node insert(Node root, int val) {
    if (root == null) {
      return new Node(val);
    }

    if (root.val > val) {
      root.left = insert(root.left, val);
    } else {
      root.right = insert(root.right, val);
    }
    return root;
  }

  /**
   * Lookup target value in given tree
   *
   * @param root   root of the binary search tree
   * @param target value to be searched in tree
   * @return true if target is present, else false
   */
  boolean search(Node root, int target) {
    if (root == null) {
      return false;
    }
    if (root.val == target) {
      return true;
    }
    if (root.val > target) {
      return search(root.left, target);
    }
    return search(root.right, target);
  }

  /**
   * Get the size of the binary tree
   *
   * @param root root node of the tree
   * @return total elements in binary tree
   */
  int size(Node root) {
    if (root == null) {
      return 0;
    }
    return 1 + size(root.left) + size(root.right);
  }

  /**
   * maxDepth" -- the number of nodes along the longest path from the root node down to the farthest
   * leaf node
   *
   * @param root root node of the binary tree
   * @return max depth from root node
   */
  int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    int leftSubtreeDepth = maxDepth(root.left);
    int rightSubtreeDepth = maxDepth(root.right);
    return 1 + Math.max(leftSubtreeDepth, rightSubtreeDepth);
  }

  /**
   * Given a non-empty binary search tree (an ordered binary tree), return the minimum data value
   * found in that tree.
   *
   * @param root root node of the bst
   * @return min value present in bst.
   */
  int minValue(Node root) {
    //edge case: when tree is empty
    if (root == null) {
      return Integer.MIN_VALUE;
    }
    //left farthest node be the minimum value in bst
    if (root.left != null) {
      return minValue(root.left);
    }
    return root.val;
  }

  /**
   * Given a binary search tree (aka an "ordered binary tree"), iterate over the nodes to print them
   * out in increasing order
   *
   * @param root root of the bst
   */
  void printTree(Node root) {
    if (root == null) {
      return;
    }
    printTree(root.left);
    System.out.print(root.val + " ");
    printTree(root.right);
  }

  /**
   * Given a binary tree, print out the nodes of the tree according to a bottom-up "postorder"
   * traversal
   *
   * @param root
   */
  void printPostorder(Node root) {
    if (root == null) {
      return;
    }
    printPostorder(root.left);
    printPostorder(root.right);
    System.out.println(root.val + " ");
  }

  /**
   * Given a binary tree and a sum, return true if the tree has a root-to-leaf path such that adding
   * up all the values along the path equals the given sum. Return false if no such path can be
   * found
   *
   * @param root root node of the tree
   * @param sum  require path sum
   * @return true if there exists a path with given sum. else, false
   */
  boolean hasPathSum(Node root, int sum) {
    if (root == null && sum == 0) {
      return true;
    }
    if (root == null) {
      return false;
    }
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
  }

  private void printPathUtils(Node root, List<Node> path, List<List<Node>> allPaths) {
    if (root == null) {
      return; //no need to add any paths
    }
    path.add(root);

    if (root.left == null || root.right == null) {
      allPaths.add(path);
    }
    if (root.left != null) {
      printPathUtils(root.left, new ArrayList<>(path), allPaths);
    }
    if (root.right != null) {
      printPathUtils(root.right, new ArrayList<>(path), allPaths);
    }

  }

  void printPaths(Node root) {
    List<List<Node>> allPaths = new ArrayList<>();
    printPathUtils(root, new ArrayList<>(), allPaths);
    allPaths.forEach(path -> {
      path.forEach(node -> {
        System.out.print(node.val + " -> ");
      });
      System.out.println("null");
    });
  }

}
