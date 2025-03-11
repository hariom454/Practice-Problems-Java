package com.shashtra.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduledThreadPoolExample {

  private static AtomicInteger cnt = new AtomicInteger(1);

  private static Runnable getTask() {
    return () -> System.out.println(
        "My name is Hariom, this function is being executed: #" + cnt.getAndIncrement()
            + " :thread name: " + Thread.currentThread().getName());
  }

  private static void schedule() throws InterruptedException {
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    executorService.schedule(getTask(), 100, TimeUnit.MILLISECONDS);
    System.out.println("Task is waiting for: " + 100 + "ms");
    executorService.shutdown();
    boolean isShutdown = executorService.awaitTermination(200, TimeUnit.MILLISECONDS);
    System.out.println("scheduler has been shutdown? " + isShutdown);
  }

  private static void scheduleWithFixedRate() throws InterruptedException {
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    executorService.scheduleAtFixedRate(getTask(), 100, 5000, TimeUnit.MILLISECONDS);
    System.out.println("I am in thread: " + Thread.currentThread().getName());
    Thread.sleep(15000);
    executorService.shutdown();
  }

  private static void scheduleWithFixedDelay() throws InterruptedException {
    ScheduledExecutorService ex = Executors.newSingleThreadScheduledExecutor();
    ex.scheduleWithFixedDelay(getTask(), 100, 10000, TimeUnit.MILLISECONDS);
    System.out.println("I am in thread: " + Thread.currentThread().getName());
    Thread.sleep(20000);
    ex.shutdown();
  }

  public static void main(String[] args) throws InterruptedException {
    System.out.println("Testing schedule thread pool: " + Thread.currentThread().getName());
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    List<Future<?>> result = new ArrayList<>();
    result.add(executorService.submit(() -> {
      try {
        schedule();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }));
    result.add(executorService.submit(()-> {
      try {
        scheduleWithFixedRate();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }));
    result.add(executorService.submit(()-> {
      try {
        scheduleWithFixedDelay();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }));
    System.out.println(
        "All the tasks are submitted and now on: " + Thread.currentThread().getName());
    executorService.shutdown();
    System.out.println("is executor shutdown? " + executorService.isShutdown());

  }

}
