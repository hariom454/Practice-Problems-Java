package com.shashtra.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalExample {

  public static void main(String[] args) throws InterruptedException {
    List<Thread> allThreads = new ArrayList<>();
    for (int i = 0; i < 10; i++) {

      allThreads.add(Thread.startVirtualThread(() -> {
        System.out.println("Thread local, thread id: " + ThreadId.getThreadId());
        System.out.println("Thread group: " + Thread.currentThread().getThreadGroup() + " id: "
            + ThreadId.getThreadId());

        System.out.println("Thread group: " + Thread.currentThread().getThreadGroup() + " id: "
            + ThreadId.getThreadId());

      }));

    }

    allThreads.forEach(thread -> {
      try {
        thread.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

  }

}

class ThreadId {

  private static AtomicInteger id = new AtomicInteger(1);
  private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(
      () -> id.getAndIncrement());

  public static Integer getThreadId() {
    return threadId.get();
  }
}
