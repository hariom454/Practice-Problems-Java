package com.shashtra.concurrency.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OptimisticLockingExample {

  private static AtomicInteger counter = new AtomicInteger(0);
  private static int version = 0;

  public static void main(String[] args) throws InterruptedException {
    List<Thread> threads = new ArrayList<>();
    Runnable task = () -> {
      int localCounter;
      do {
        //fetch the current value of counter
        localCounter = counter.get();
      }
      //this will set the value to counter to +1, only if counter is not modified by other thread
      //if so, it will try to fetch the counter again and repeat the process till it succeeds
      while (!counter.compareAndSet(localCounter, localCounter + 1));
    };
    for (int i = 0; i < 100_000; i++) {
      threads.add(Thread.ofPlatform().start(task));
    }
    for (Thread thread : threads) {
      thread.join();
    }
    System.out.println("Counter value after optimistic locking: " + counter);
  }

}
