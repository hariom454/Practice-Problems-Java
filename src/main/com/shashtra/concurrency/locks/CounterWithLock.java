package com.shashtra.concurrency.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class CounterWithLock {

  private static int counter = 0;
  private static final ReentrantLock lock = new ReentrantLock();

  public static void main(String[] args) throws InterruptedException {

    Runnable task = () -> {
      lock.lock();
      try {
        counter++;
      } finally {
        lock.unlock();
      }
    };
    List<Thread> res = new ArrayList<>();
    for (int i = 0; i < 100_000; i++) {
      res.add(Thread.ofVirtual().start(task));
    }
    for (Thread thread : res) {
      thread.join();
    }

    System.out.println("Counter with lock (pessimistic locking): " + counter);
  }

}
