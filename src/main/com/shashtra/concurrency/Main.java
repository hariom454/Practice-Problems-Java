package com.shashtra.concurrency;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    List<Thread> threads = new ArrayList<>();
    for (int i = 0; i < 500; i++) {
      MyRunnable myTask = new MyRunnable(1000_000 + i);
      Thread worker = new Thread(myTask);
      worker.setName("thread - " + i);
      worker.start();
      threads.add(worker);
    }
    int running = 500;
    while (running > 0) {
      running = 0;
      for (Thread tHread : threads) {
        if (tHread.isAlive()) {
          running++;
        }

      }
      System.out.println("Currently running: " + running + " threads");
    }
  }

}
