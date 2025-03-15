package com.shashtra.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

  public static void main(String[] args) throws InterruptedException {
    int n = 10;
    //start all the threads together
    CountDownLatch startTogether = new CountDownLatch(1);
    CountDownLatch stopSignal = new CountDownLatch(n);

    for (int i = 0; i < n; i++) {
      //new Thread(new Worker(startTogether, stopSignal), "worker thread - " + i).start();
      Thread.startVirtualThread(new Worker(startTogether, stopSignal))
          .setName("virtual worker thread - " + i);
    }

    doSomething();
    startTogether.countDown();//send signal to all the threads
    System.out.println("All the threads are running!");
    stopSignal.await();
    System.out.println("All the threads are done!");
  }

  private static void doSomething() {
    System.out.println("I don't have anything do: " + Thread.currentThread().getName());
  }

}

class Worker implements Runnable {

  CountDownLatch startSignal;
  CountDownLatch stopSignal;

  public Worker(CountDownLatch startSignal, CountDownLatch stopSignal) {
    this.startSignal = startSignal;
    this.stopSignal = stopSignal;
  }

  @Override
  public void run() {
    try {
      startSignal.await(); //wait till notification is received
      performSomeTask();
      stopSignal.countDown();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }

  void performSomeTask() {
    System.out.println(
        "I have nothing to do, name: " + Thread.currentThread().getName() + " group: "
            + Thread.currentThread().getThreadGroup());
  }
}
