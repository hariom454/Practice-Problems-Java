package com.shashtra.threads;

public class MyRunnable implements Runnable {

  private final long count;

  public MyRunnable(long count) {
    this.count = count;
  }

  @Override
  public void run() {

    long sum = 0;
    for (int i = 1; i < count; i++) {
      sum += i;
    }
    System.out.println("Sum: " + sum);
  }
}
