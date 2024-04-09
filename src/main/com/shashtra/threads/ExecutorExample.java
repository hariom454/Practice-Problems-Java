package com.shashtra.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {

  private static final int THREAD_COUNT = 10;

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
    for (int i = 0; i < 500; i++) {
      MyRunnable worker = new MyRunnable(1000_000 + i);
      executorService.execute(worker);
    }
    executorService.shutdown();
    executorService.awaitTermination(100, TimeUnit.SECONDS);
    System.out.println("All task finished");


  }

}
