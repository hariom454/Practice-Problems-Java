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
      return Integer.MAX_VALUE;
    }
    //left farthest node be the minimum value in bst
    if (root.left != null) {
      return minValue(root.left);
    }
    return root.val;
  }

  /**
   * Given a non-empty binary search tree (an ordered binary tree), return the maximum data value
   * found in that tree.
   *
   * @param root root node of the bst
   * @return max value present in bst.
   */
  int maxValue(Node root) {
    //edge case: when tree is empty
    if (root == null) {
      return Integer.MIN_VALUE;
    }
    //left farthest node be the minimum value in bst
    if (root.right != null) {
      return maxValue(root.right);
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
    if (root == null) {
      return sum == 0;
    }
    int target = sum - root.val;
    return hasPathSum(root.left, target) || hasPathSum(root.right, target);
  }

  private void printPathUtils(Node root, List<Node> path, List<List<Node>> allPaths) {
    if (root == null) {
      return; //no need to add any paths
    }
    path.add(root);

    if (root.left == null && root.right == null) {
      allPaths.add(path);
    }
    printPathUtils(root.left, new ArrayList<>(path), allPaths);
    printPathUtils(root.right, new ArrayList<>(path), allPaths);
  }

  /**
   * Given a binary tree, print out all of its root-to-leaf paths as defined above
   *
   * @param root root node of the tree
   */
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

  /**
   * Change a tree so that the roles of the left and right pointers are swapped at every node
   *
   * @param root root node of the bst
   */
  void mirror(Node root) {
    if (root == null) {
      return;
    }
    mirror(root.left);
    mirror(root.right);

    Node temp = root.left;
    root.left = root.right;
    root.right = temp;
  }

  /**
   * For each node in a binary search tree, create a new duplicate node, and insert the duplicate as
   * the left child of the original node
   *
   * @param root root node of the tree
   */
  void doubleTree(Node root) {
    if (root == null) {
      return;
    }

    doubleTree(root.left);
    doubleTree(root.right);

    Node temp = root.left;
    root.left = new Node(root.val);
    root.left.left = temp;

  }

  /**
   * Given two binary trees, return true if they are structurally identical -- they are made of
   * nodes with the same values arranged in the same way
   *
   * @param root1 root node of first tree
   * @param root2 root node of second tree
   * @return true, if both the trees have identical structure and value. false otherwise
   */
  boolean sameTree(Node root1, Node root2) {
    if (root1 == root2) {
      return true;
    }
    if (root1 == null || root2 == null) {
      return false;
    }

    if (root1.val != root2.val) {
      return false;
    }
    return sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);

  }

  int getDistinctTree(int n, int[] dp) {
    int tot = 0;
    for (int i = 1; i <= n; i++) {
      tot += dp[i - 1] * dp[n - i];
    }
    return tot;
  }

  /**
   * given the number of distinct values, computes the number of structurally unique binary search
   * trees that store those values
   *
   * @param n find structurally distinct bst for given n
   * @return distinct structurally trees
   */
  int countTrees(int n) {
    if (n <= 1) {
      return 1;
    }
    int[] dp = new int[n + 1];
    dp[0] = dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = getDistinctTree(i, dp);
    }
    return dp[n];
  }

  boolean isBST1(Node root) {
    if (root == null) {
      return true;
    }
    if (root.left != null && maxValue(root.left) > root.val) {
      return false;
    }
    if (root.right != null && minValue(root.right) <= root.val) {
      return false;
    }

    return isBST1(root.left) && isBST1(root.right);
  }

  private boolean isBSTUtil(Node root, int min, int max) {
    if (root == null) {
      return true;
    }
    if (root.val < min || root.val > max) {
      return false;
    }
    return isBSTUtil(root.left, min, root.val) && isBSTUtil(root.right, root.val + 1, max);
  }

  boolean isBST2(Node root) {
    return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

}
