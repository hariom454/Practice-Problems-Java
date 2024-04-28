package com.shashtra.concurrency.forkjoin;

import java.util.Random;

public class Problem {

  private final int[] list = new int[2000_000];

  public Problem() {
    Random generator = new Random(19580427);
    for (int i = 0; i < list.length; i++) {
      list[i] = generator.nextInt(500_000);
    }
  }

  public int[] getList() {
    return list;
  }
}
