package com.shashtra.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearch {

  public static void main(String[] args) {
    List<Integer> arr = Arrays.asList(1, 2, 4, 8, 10, 15);

    System.out.println("index: " + Collections.binarySearch(arr, 0));
    System.out.println("index: " + Collections.binarySearch(arr, 1));
    System.out.println("index: " + Collections.binarySearch(arr, 8));
    System.out.println("index: " + Collections.binarySearch(arr, 9));
    System.out.println("index: " + Collections.binarySearch(arr, 15));
    System.out.println("index: " + Collections.binarySearch(arr, 16));

    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{1,2});

  }

}
