package com.shashtra.concurrency.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CounterWithoutLock {

  private static int counter = 0;

  public static void main(String[] args) throws InterruptedException {
    Runnable task = () -> {
      counter++;
    };

    try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {

      for (int i = 0; i < 100_000; i++) {
        executorService.submit(task);
      }
      //just testing auto closable behaviour and processed tasks
      //System.out.println("Premature Counter without lock: " + counter);

    }
    System.out.println("Counter without lock: " + counter);
  }

}
