package com.shashtra.algorithm;

import static java.util.Collections.swap;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

  private static List<List<Integer>> ans = new ArrayList<>();

  public static void getAllPermutations(List<Integer> a, int n, int start) {
    if (start == n) {
      printArray(a, n);
      ans.add(a);
      return;
    }
    for (int i = start; i < n; i++) {
      swap(a, start, i);
      getAllPermutations(a, n, start + 1);
      swap(a, start, i);
    }
  }

  static void printArray(List<Integer> a, int n) {
    for (int i = 0; i < n; i++) {
      System.out.print(a.get(i) + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    List<Integer> a = new ArrayList<>();
    a.add(1);
    a.add(2);
    a.add(3);
    a.add(4);
    getAllPermutations(a, a.size(), 0);

  }

}
