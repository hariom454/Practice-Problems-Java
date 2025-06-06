package com.shashtra.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerExample {

  private static final List<Integer> buffer = new ArrayList<>();
  private static final int CAPACITY = 10;
  private static final Object lock = new Object();

  static void producer() throws InterruptedException {
    synchronized (lock) {
      System.out.println("buffer producer size: " + buffer.size());
      while (buffer.size() == CAPACITY) {
        System.out.println("Buffer is full, waiting for it to get empty!");
        lock.wait();
      }
      int item = new Random().nextInt(100);
      System.out.println("adding item: " + item);
      buffer.add(item);
      lock.notifyAll();
    }
  }

  static void consumer() throws InterruptedException {
    synchronized (lock) {
      System.out.println("Buffer consumer size: " + buffer.size());
      while (buffer.isEmpty()) {
        System.out.println("Buffer is empty! waiting for items");
        lock.wait();
      }
      Integer item = buffer.removeLast();
      System.out.println("Remove item: " + item);
      lock.notifyAll();
    }

  }

  public static void main(String[] args) throws InterruptedException {

    try (ExecutorService executors = Executors.newVirtualThreadPerTaskExecutor()) {
      for (int i = 0; i < 100_000; i++) {
        executors.submit(() -> {
          try {
            producer();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        });

        executors.submit(() -> {
          try {
            consumer();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        });

      }

    }


  }

}
