package com.shashtra.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class VirtualThreadExample {

  private static void virtualThreadHelloWorld() throws InterruptedException {
    Runnable task = () -> System.out.println(
        "Hello world from thread: " + Thread.currentThread().getName() + " "
            + Thread.currentThread().getThreadGroup());
    Thread thread = new Thread(task);
    thread.start();

    Thread thread1 = Thread.ofVirtual().start(task);
    thread.join();
    thread1.join();


  }

  private static void virtualThreadExecutor() {
    try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
      List<Future<?>> futures = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
        futures.add(executorService.submit(() -> System.out.println(
            "My thread id: " + Thread.currentThread().threadId() + " My group: "
                + Thread.currentThread().getThreadGroup())));
      }
      System.out.println("ALl the tasks are submitted");
      futures.forEach(item -> {
        try {
          item.get();
        } catch (InterruptedException | ExecutionException e) {
          throw new RuntimeException(e);
        }
      });
      System.out.println("All the tasks are finished");
    }
  }

  public static void main(String[] args) throws InterruptedException {
    virtualThreadHelloWorld();
    virtualThreadExecutor();

  }

}
